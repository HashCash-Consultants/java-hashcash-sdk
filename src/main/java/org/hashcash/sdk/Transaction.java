package org.hashcash.sdk;

import com.google.common.io.BaseEncoding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hashcash.sdk.xdr.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


public class Transaction {
  private static final int BASE_FEE = 100;

  private final int mFee;
  private final KeyPair mSourceAccount;
  private final long mSequenceNumber;
  private final Operation[] mOperations;
  private final Memo mMemo;
  private final TimeBounds mTimeBounds;
  private List<DecoratedSignature> mSignatures;

  Transaction(KeyPair sourceAccount, int fee, long sequenceNumber, Operation[] operations, Memo memo, TimeBounds timeBounds) {
    mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
    mSequenceNumber = checkNotNull(sequenceNumber, "sequenceNumber cannot be null");
    mOperations = checkNotNull(operations, "operations cannot be null");
    checkArgument(operations.length > 0, "At least one operation required");

    mFee = fee;
    mSignatures = new ArrayList<DecoratedSignature>();
    mMemo = memo != null ? memo : Memo.none();
    mTimeBounds = timeBounds;
  }

  /**
   * Adds a new signature ed25519PublicKey to this transaction.
   * @param signer {@link KeyPair} object representing a signer
   */
  public void sign(KeyPair signer) {
    checkNotNull(signer, "signer cannot be null");
    byte[] txHash = this.hash();
    mSignatures.add(signer.signDecorated(txHash));
  }

  /**
   * Adds a new sha256Hash signature to this transaction by revealing preimage.
   * @param preimage the sha256 hash of preimage should be equal to signer hash
   */
  public void sign(byte[] preimage) {
    checkNotNull(preimage, "preimage cannot be null");
    org.hashcash.sdk.xdr.Signature signature = new org.hashcash.sdk.xdr.Signature();
    signature.setSignature(preimage);

    byte[] hash = Util.hash(preimage);
    byte[] signatureHintBytes = Arrays.copyOfRange(hash, hash.length - 4, hash.length);
    SignatureHint signatureHint = new SignatureHint();
    signatureHint.setSignatureHint(signatureHintBytes);

    DecoratedSignature decoratedSignature = new DecoratedSignature();
    decoratedSignature.setHint(signatureHint);
    decoratedSignature.setSignature(signature);

    mSignatures.add(decoratedSignature);
  }

  /**
   * Returns transaction hash.
   */
  public byte[] hash() {
    return Util.hash(this.signatureBase());
  }

  /**
   * Returns signature base.
   */
  public byte[] signatureBase() {
    if (Network.current() == null) {
      throw new NoNetworkSelectedException();
    }

    try {
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      // Hashed NetworkID
      outputStream.write(Network.current().getNetworkId());
      // Envelope Type - 4 bytes
      outputStream.write(ByteBuffer.allocate(4).putInt(EnvelopeType.ENVELOPE_TYPE_TX.getValue()).array());
      // Transaction XDR bytes
      ByteArrayOutputStream txOutputStream = new ByteArrayOutputStream();
      XdrDataOutputStream xdrOutputStream = new XdrDataOutputStream(txOutputStream);
      org.hashcash.sdk.xdr.Transaction.encode(xdrOutputStream, this.toXdr());
      outputStream.write(txOutputStream.toByteArray());

      return outputStream.toByteArray();
    } catch (IOException exception) {
      return null;
    }
  }

  public KeyPair getSourceAccount() {
    return mSourceAccount;
  }

  public long getSequenceNumber() {
    return mSequenceNumber;
  }

  public List<DecoratedSignature> getSignatures() {
    return mSignatures;
  }

  public Memo getMemo() {
    return mMemo;
  }
  
  /**
   * @return TimeBounds, or null (representing no time restrictions)
   */
  public TimeBounds getTimeBounds() {
    return mTimeBounds;
  }

  /**
   * Returns fee paid for transaction in stroops (1 stroop = 0.0000001 XLM).
   */
  public int getFee() {
    return mFee;
  }

  /**
   * Returns operations in this transaction.
   */
  public Operation[] getOperations() {
    return mOperations;
  }

  /**
   * Generates Transaction XDR object.
   */
  public org.hashcash.sdk.xdr.Transaction toXdr() {
    // fee
    org.hashcash.sdk.xdr.Uint32 fee = new org.hashcash.sdk.xdr.Uint32();
    fee.setUint32(mFee);
    // sequenceNumber
    org.hashcash.sdk.xdr.Int64 sequenceNumberUint = new org.hashcash.sdk.xdr.Int64();
    sequenceNumberUint.setInt64(mSequenceNumber);
    org.hashcash.sdk.xdr.SequenceNumber sequenceNumber = new org.hashcash.sdk.xdr.SequenceNumber();
    sequenceNumber.setSequenceNumber(sequenceNumberUint);
    // sourceAccount
    org.hashcash.sdk.xdr.AccountID sourceAccount = new org.hashcash.sdk.xdr.AccountID();
    sourceAccount.setAccountID(mSourceAccount.getXdrPublicKey());
    // operations
    org.hashcash.sdk.xdr.Operation[] operations = new org.hashcash.sdk.xdr.Operation[mOperations.length];
    for (int i = 0; i < mOperations.length; i++) {
      operations[i] = mOperations[i].toXdr();
    }
    // ext
    org.hashcash.sdk.xdr.Transaction.TransactionExt ext = new org.hashcash.sdk.xdr.Transaction.TransactionExt();
    ext.setDiscriminant(0);

    org.hashcash.sdk.xdr.Transaction transaction = new org.hashcash.sdk.xdr.Transaction();
    transaction.setFee(fee);
    transaction.setSeqNum(sequenceNumber);
    transaction.setSourceAccount(sourceAccount);
    transaction.setOperations(operations);
    transaction.setMemo(mMemo.toXdr());
    transaction.setTimeBounds(mTimeBounds == null ? null : mTimeBounds.toXdr());
    transaction.setExt(ext);
    return transaction;
  }

  /**
   * Creates a <code>Transaction</code> instance from previously build <code>TransactionEnvelope</code>
   * @param envelope Base-64 encoded <code>TransactionEnvelope</code>
   * @return
   * @throws IOException
   */
  public static Transaction fromEnvelopeXdr(String envelope) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(envelope);

    TransactionEnvelope transactionEnvelope = TransactionEnvelope.decode(new XdrDataInputStream(new ByteArrayInputStream(bytes)));
    return fromEnvelopeXdr(transactionEnvelope);
  }

  /**
   * Creates a <code>Transaction</code> instance from previously build <code>TransactionEnvelope</code>
   * @param envelope
   * @return
   */
  public static Transaction fromEnvelopeXdr(TransactionEnvelope envelope) {
    org.hashcash.sdk.xdr.Transaction tx = envelope.getTx();
    int mFee = tx.getFee().getUint32();
    KeyPair mSourceAccount = KeyPair.fromXdrPublicKey(tx.getSourceAccount().getAccountID());
    Long mSequenceNumber = tx.getSeqNum().getSequenceNumber().getInt64();
    Memo mMemo = Memo.fromXdr(tx.getMemo());
    TimeBounds mTimeBounds = TimeBounds.fromXdr(tx.getTimeBounds());

    Operation[] mOperations = new Operation[tx.getOperations().length];
    for (int i = 0; i < tx.getOperations().length; i++) {
      mOperations[i] = Operation.fromXdr(tx.getOperations()[i]);
    }

    Transaction transaction = new Transaction(mSourceAccount, mFee, mSequenceNumber, mOperations, mMemo, mTimeBounds);

    for (DecoratedSignature signature : envelope.getSignatures()) {
      transaction.mSignatures.add(signature);
    }

    return transaction;
  }

  /**
   * Generates TransactionEnvelope XDR object. Transaction need to have at least one signature.
   */
  public org.hashcash.sdk.xdr.TransactionEnvelope toEnvelopeXdr() {
    if (mSignatures.size() == 0) {
      throw new NotEnoughSignaturesException("Transaction must be signed by at least one signer. Use transaction.sign().");
    }

    org.hashcash.sdk.xdr.TransactionEnvelope xdr = new org.hashcash.sdk.xdr.TransactionEnvelope();
    org.hashcash.sdk.xdr.Transaction transaction = this.toXdr();
    xdr.setTx(transaction);

    DecoratedSignature[] signatures = new DecoratedSignature[mSignatures.size()];
    signatures = mSignatures.toArray(signatures);
    xdr.setSignatures(signatures);
    return xdr;
  }

  /**
   * Returns base64-encoded TransactionEnvelope XDR object. Transaction need to have at least one signature.
   */
  public String toEnvelopeXdrBase64() {
    try {
      org.hashcash.sdk.xdr.TransactionEnvelope envelope = this.toEnvelopeXdr();
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      XdrDataOutputStream xdrOutputStream = new XdrDataOutputStream(outputStream);
      org.hashcash.sdk.xdr.TransactionEnvelope.encode(xdrOutputStream, envelope);

      BaseEncoding base64Encoding = BaseEncoding.base64();
      return base64Encoding.encode(outputStream.toByteArray());
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  /**
   * Builds a new Transaction object.
   */
  public static class Builder {
    private final TransactionBuilderAccount mSourceAccount;
    private Memo mMemo;
    private TimeBounds mTimeBounds;
    List<Operation> mOperations;
    private boolean timeoutSet;

    public static final long TIMEOUT_INFINITE = 0;

    /**
     * Construct a new transaction builder.
     * @param sourceAccount The source account for this transaction. This account is the account
     * who will use a sequence number. When build() is called, the account object's sequence number
     * will be incremented.
     */
    public Builder(TransactionBuilderAccount sourceAccount) {
      checkNotNull(sourceAccount, "sourceAccount cannot be null");
      mSourceAccount = sourceAccount;
      mOperations = Collections.synchronizedList(new ArrayList<Operation>());
    }

    public int getOperationsCount() {
      return mOperations.size();
    }

    /**
     * @param operation
     * @return Builder object so you can chain methods.
     * @see Operation
     */
    public Builder addOperation(Operation operation) {
      checkNotNull(operation, "operation cannot be null");
      mOperations.add(operation);
      return this;
    }

    /**
     * @param memo
     * @return Builder object so you can chain methods.
     * @see Memo
     */
    public Builder addMemo(Memo memo) {
      if (mMemo != null) {
        throw new RuntimeException("Memo has been already added.");
      }
      checkNotNull(memo, "memo cannot be null");
      mMemo = memo;
      return this;
    }
    
    /**
     * @param timeBounds
     * @return Builder object so you can chain methods.
     * @see TimeBounds
     */
    public Builder addTimeBounds(TimeBounds timeBounds) {
      if (mTimeBounds != null) {
        throw new RuntimeException("TimeBounds has been already added.");
      }
      checkNotNull(timeBounds, "timeBounds cannot be null");
      mTimeBounds = timeBounds;
      return this;
    }

    /**
     * Because of the distributed nature of the HC-Net network it is possible that the status of your transaction
     * will be determined after a long time if the network is highly congested.
     * If you want to be sure to receive the status of the transaction within a given period you should set the
     * {@link TimeBounds} with <code>maxTime</code> on the transaction (this is what <code>setTimeout</code> does
     * internally; if there's <code>minTime</code> set but no <code>maxTime</code> it will be added).
     * Call to <code>Builder.setTimeout</code> is required if Transaction does not have <code>max_time</code> set.
     * If you don't want to set timeout, use <code>TIMEOUT_INFINITE</code>. In general you should set
     * <code>TIMEOUT_INFINITE</code> only in smart contracts.
     * Please note that aurora may still return <code>504 Gateway Timeout</code> error, even for short timeouts.
     * In such case you need to resubmit the same transaction again without making any changes to receive a status.
     * This method is using the machine system time (UTC), make sure it is set correctly.
     * @param timeout Timeout in seconds.
     * @see TimeBounds
     * @return
     */
    public Builder setTimeout(long timeout) {
      if (mTimeBounds != null && mTimeBounds.getMaxTime() > 0) {
        throw new RuntimeException("TimeBounds.max_time has been already set - setting timeout would overwrite it.");
      }

      if (timeout < 0) {
        throw new RuntimeException("timeout cannot be negative");
      }

      timeoutSet = true;
      if (timeout > 0) {
        long timeoutTimestamp = System.currentTimeMillis() / 1000L + timeout;
        if (mTimeBounds == null) {
          mTimeBounds = new TimeBounds(0, timeoutTimestamp);
        } else {
          mTimeBounds = new TimeBounds(mTimeBounds.getMinTime(), timeoutTimestamp);
        }
      }

      return this;
    }

    /**
     * Builds a transaction. It will increment sequence number of the source account.
     */
    public Transaction build() {
      // Ensure setTimeout called or maxTime is set
      if ((mTimeBounds == null || mTimeBounds != null && mTimeBounds.getMaxTime() == 0) && !timeoutSet) {
        throw new RuntimeException("TimeBounds has to be set or you must call setTimeout(TIMEOUT_INFINITE).");
      }

      Operation[] operations = new Operation[mOperations.size()];
      operations = mOperations.toArray(operations);
      Transaction transaction = new Transaction(mSourceAccount.getKeypair(), operations.length * BASE_FEE, mSourceAccount.getIncrementedSequenceNumber(), operations, mMemo, mTimeBounds);
      // Increment sequence number when there were no exceptions when creating a transaction
      mSourceAccount.incrementSequenceNumber();
      return transaction;
    }
  }
}
// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;
import java.util.Arrays;

// === xdr source ============================================================

//  struct Transaction
//  {
//      // account used to run the transaction
//      MuxedAccount sourceAccount;
//  
//      // the fee the sourceAccount will pay
//      uint32 fee;
//  
//      // sequence number to consume in the account
//      SequenceNumber seqNum;
//  
//      // validity conditions
//      Preconditions cond;
//  
//      Memo memo;
//  
//      Operation operations<MAX_OPS_PER_TX>;
//  
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class Transaction implements XdrElement {
  public Transaction () {}
  private MuxedAccount sourceAccount;
  public MuxedAccount getSourceAccount() {
    return this.sourceAccount;
  }
  public void setSourceAccount(MuxedAccount value) {
    this.sourceAccount = value;
  }
  private Uint32 fee;
  public Uint32 getFee() {
    return this.fee;
  }
  public void setFee(Uint32 value) {
    this.fee = value;
  }
  private SequenceNumber seqNum;
  public SequenceNumber getSeqNum() {
    return this.seqNum;
  }
  public void setSeqNum(SequenceNumber value) {
    this.seqNum = value;
  }
  private Preconditions cond;
  public Preconditions getCond() {
    return this.cond;
  }
  public void setCond(Preconditions value) {
    this.cond = value;
  }
  private Memo memo;
  public Memo getMemo() {
    return this.memo;
  }
  public void setMemo(Memo value) {
    this.memo = value;
  }
  private Operation[] operations;
  public Operation[] getOperations() {
    return this.operations;
  }
  public void setOperations(Operation[] value) {
    this.operations = value;
  }
  private TransactionExt ext;
  public TransactionExt getExt() {
    return this.ext;
  }
  public void setExt(TransactionExt value) {
    this.ext = value;
  }
  public static void encode(XdrDataOutputStream stream, Transaction encodedTransaction) throws IOException{
    MuxedAccount.encode(stream, encodedTransaction.sourceAccount);
    Uint32.encode(stream, encodedTransaction.fee);
    SequenceNumber.encode(stream, encodedTransaction.seqNum);
    Preconditions.encode(stream, encodedTransaction.cond);
    Memo.encode(stream, encodedTransaction.memo);
    int operationssize = encodedTransaction.getOperations().length;
    stream.writeInt(operationssize);
    for (int i = 0; i < operationssize; i++) {
      Operation.encode(stream, encodedTransaction.operations[i]);
    }
    TransactionExt.encode(stream, encodedTransaction.ext);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Transaction decode(XdrDataInputStream stream) throws IOException {
    Transaction decodedTransaction = new Transaction();
    decodedTransaction.sourceAccount = MuxedAccount.decode(stream);
    decodedTransaction.fee = Uint32.decode(stream);
    decodedTransaction.seqNum = SequenceNumber.decode(stream);
    decodedTransaction.cond = Preconditions.decode(stream);
    decodedTransaction.memo = Memo.decode(stream);
    int operationssize = stream.readInt();
    decodedTransaction.operations = new Operation[operationssize];
    for (int i = 0; i < operationssize; i++) {
      decodedTransaction.operations[i] = Operation.decode(stream);
    }
    decodedTransaction.ext = TransactionExt.decode(stream);
    return decodedTransaction;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.sourceAccount, this.fee, this.seqNum, this.cond, this.memo, Arrays.hashCode(this.operations), this.ext);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Transaction)) {
      return false;
    }

    Transaction other = (Transaction) object;
    return Objects.equal(this.sourceAccount, other.sourceAccount) && Objects.equal(this.fee, other.fee) && Objects.equal(this.seqNum, other.seqNum) && Objects.equal(this.cond, other.cond) && Objects.equal(this.memo, other.memo) && Arrays.equals(this.operations, other.operations) && Objects.equal(this.ext, other.ext);
  }

  public static final class Builder {
    private MuxedAccount sourceAccount;
    private Uint32 fee;
    private SequenceNumber seqNum;
    private Preconditions cond;
    private Memo memo;
    private Operation[] operations;
    private TransactionExt ext;

    public Builder sourceAccount(MuxedAccount sourceAccount) {
      this.sourceAccount = sourceAccount;
      return this;
    }

    public Builder fee(Uint32 fee) {
      this.fee = fee;
      return this;
    }

    public Builder seqNum(SequenceNumber seqNum) {
      this.seqNum = seqNum;
      return this;
    }

    public Builder cond(Preconditions cond) {
      this.cond = cond;
      return this;
    }

    public Builder memo(Memo memo) {
      this.memo = memo;
      return this;
    }

    public Builder operations(Operation[] operations) {
      this.operations = operations;
      return this;
    }

    public Builder ext(TransactionExt ext) {
      this.ext = ext;
      return this;
    }

    public Transaction build() {
      Transaction val = new Transaction();
      val.setSourceAccount(sourceAccount);
      val.setFee(fee);
      val.setSeqNum(seqNum);
      val.setCond(cond);
      val.setMemo(memo);
      val.setOperations(operations);
      val.setExt(ext);
      return val;
    }
  }

  public static class TransactionExt {
    public TransactionExt () {}
    Integer v;
    public Integer getDiscriminant() {
      return this.v;
    }
    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    public static final class Builder {
      private Integer discriminant;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public TransactionExt build() {
        TransactionExt val = new TransactionExt();
        val.setDiscriminant(discriminant);
        return val;
      }
    }

    public static void encode(XdrDataOutputStream stream, TransactionExt encodedTransactionExt) throws IOException {
    //Xdrgen::AST::Typespecs::Int
    //Integer
    stream.writeInt(encodedTransactionExt.getDiscriminant().intValue());
    switch (encodedTransactionExt.getDiscriminant()) {
    case 0:
    break;
    }
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static TransactionExt decode(XdrDataInputStream stream) throws IOException {
    TransactionExt decodedTransactionExt = new TransactionExt();
    Integer discriminant = stream.readInt();
    decodedTransactionExt.setDiscriminant(discriminant);
    switch (decodedTransactionExt.getDiscriminant()) {
    case 0:
    break;
    }
      return decodedTransactionExt;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.v);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof TransactionExt)) {
        return false;
      }

      TransactionExt other = (TransactionExt) object;
      return Objects.equal(this.v, other.v);
    }

  }
}

package org.hashcash.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

import org.hashcash.sdk.xdr.AccountID;
import org.hashcash.sdk.xdr.CreateAccountOp;
import org.hashcash.sdk.xdr.Int64;
import org.hashcash.sdk.xdr.OperationType;


public class CreateAccountOperation extends Operation {

  private final KeyPair destination;
  private final String startingBalance;

  private CreateAccountOperation(KeyPair destination, String startingBalance) {
    this.destination = checkNotNull(destination, "destination cannot be null");
    this.startingBalance = checkNotNull(startingBalance, "startingBalance cannot be null");
  }

  /**
   * Amount of XLM to send to the newly created account.
   */
  public String getStartingBalance() {
    return startingBalance;
  }

  /**
   * Account that is created and funded
   */
  public KeyPair getDestination() {
    return destination;
  }

  @Override
  org.hashcash.sdk.xdr.Operation.OperationBody toOperationBody() {
    CreateAccountOp op = new CreateAccountOp();
    AccountID destination = new AccountID();
    destination.setAccountID(this.destination.getXdrPublicKey());
    op.setDestination(destination);
    Int64 startingBalance = new Int64();
    startingBalance.setInt64(Operation.toXdrAmount(this.startingBalance));
    op.setStartingBalance(startingBalance);

    org.hashcash.sdk.xdr.Operation.OperationBody body = new org.hashcash.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.CREATE_ACCOUNT);
    body.setCreateAccountOp(op);
    return body;
  }

  /**
   * Builds CreateAccount operation.
   * @see CreateAccountOperation
   */
  public static class Builder {
    private final KeyPair destination;
    private final String startingBalance;

    private KeyPair mSourceAccount;

    /**
     * Construct a new CreateAccount builder from a CreateAccountOp XDR.
     * @param op {@link CreateAccountOp}
     */
    Builder(CreateAccountOp op) {
      destination = KeyPair.fromXdrPublicKey(op.getDestination().getAccountID());
      startingBalance = Operation.fromXdrAmount(op.getStartingBalance().getInt64().longValue());
    }

    /**
     * Creates a new CreateAccount builder.
     * @param destination The destination keypair (uses only the public key).
     * @param startingBalance The initial balance to start with in lumens.
     * @throws ArithmeticException when startingBalance has more than 7 decimal places.
     */
    public Builder(KeyPair destination, String startingBalance) {
      this.destination = destination;
      this.startingBalance = startingBalance;
    }

    /**
     * Sets the source account for this operation.
     * @param account The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public Builder setSourceAccount(KeyPair account) {
      mSourceAccount = account;
      return this;
    }

    /**
     * Builds an operation
     */
    public CreateAccountOperation build() {
      CreateAccountOperation operation = new CreateAccountOperation(destination, startingBalance);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }
}
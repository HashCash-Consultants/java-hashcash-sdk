package org.hashcash.sdk.responses.operations;

import org.hashcash.sdk.KeyPair;

import com.google.gson.annotations.SerializedName;


public class CreateAccountOperationResponse extends OperationResponse {
  @SerializedName("account")
  protected final KeyPair account;
  @SerializedName("funder")
  protected final KeyPair funder;
  @SerializedName("starting_balance")
  protected final String startingBalance;

  CreateAccountOperationResponse(KeyPair funder, String startingBalance, KeyPair account) {
    this.funder = funder;
    this.startingBalance = startingBalance;
    this.account = account;
  }

  public KeyPair getAccount() {
    return account;
  }

  public String getStartingBalance() {
    return startingBalance;
  }

  public KeyPair getFunder() {
    return funder;
  }
}

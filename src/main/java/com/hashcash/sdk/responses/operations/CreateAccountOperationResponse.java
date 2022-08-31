package com.hashcash.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.responses.MuxedAccount;

import java.math.BigInteger;

/**
 * Represents CreateAccount operation response.
 * @see <a href="https://developers.stellar.org/api/resources/operations/" target="_blank">Operation documentation</a>
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class CreateAccountOperationResponse extends OperationResponse {
  @SerializedName("account")
  private String account;
  @SerializedName("funder")
  private String funder;
  @SerializedName("funder_muxed")
  private String funderAccountMuxed;
  @SerializedName("funder_muxed_id")
  private BigInteger funderAccountMuxedId;
  @SerializedName("starting_balance")
  private String startingBalance;

  public Optional<MuxedAccount> getFunderMuxed() {
    if (this.funderAccountMuxed == null || this.funderAccountMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.funderAccountMuxed, this.funder, this.funderAccountMuxedId));
  }

  public String getAccount() {
    return account;
  }

  public String getStartingBalance() {
    return startingBalance;
  }

  public String getFunder() {
    return funder;
  }
}

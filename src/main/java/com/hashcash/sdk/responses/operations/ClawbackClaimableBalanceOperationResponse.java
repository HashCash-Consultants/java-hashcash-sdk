package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a Clawback Claimable Balance operation response.
 *
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class ClawbackClaimableBalanceOperationResponse extends OperationResponse {
  @SerializedName("balance_id")
  private final String balanceId;

  public ClawbackClaimableBalanceOperationResponse(String balanceId) {
    this.balanceId = balanceId;
  }

  public String getBalanceId() {
    return balanceId;
  }
}

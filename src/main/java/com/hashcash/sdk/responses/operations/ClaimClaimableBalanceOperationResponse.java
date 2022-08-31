package com.hashcash.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.responses.MuxedAccount;

import java.math.BigInteger;

/**
 * Represents ClaimClaimableBalance operation response.
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class ClaimClaimableBalanceOperationResponse extends OperationResponse {
  @SerializedName("balance_id")
  private String balanceId;
  @SerializedName("claimant")
  private String claimant;
  @SerializedName("claimant_muxed")
  private String claimantMuxed;
  @SerializedName("claimant_muxed_id")
  private BigInteger claimantMuxedId;

  public Optional<MuxedAccount> getClaimantMuxed() {
    if (this.claimantMuxed == null || this.claimantMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.claimantMuxed, this.claimant, this.claimantMuxedId));
  }

  public String getBalanceId() {
    return balanceId;
  }

  public String getClaimant() {
    return claimant;
  }
}

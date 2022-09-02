package com.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

/**
 * Represents claimable_balance_clawed_back effect response.
 *
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class ClaimableBalanceClawedBackEffectResponse extends EffectResponse {
  @SerializedName("balance_id")
  protected final String balanceId;

  public ClaimableBalanceClawedBackEffectResponse(String balanceId) {
    this.balanceId = balanceId;
  }

  public String getBalanceId() {
    return balanceId;
  }

}

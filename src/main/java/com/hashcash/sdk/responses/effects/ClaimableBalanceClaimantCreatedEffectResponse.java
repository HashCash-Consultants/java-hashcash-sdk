package com.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;
import com.hashcash.sdk.Predicate;

/**
 * Represents claimable_balance_claimant_created effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class ClaimableBalanceClaimantCreatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("balance_id")
  protected final String balanceId;
  @SerializedName("predicate")
  protected final Predicate predicate;

  public ClaimableBalanceClaimantCreatedEffectResponse(String assetString, String amount, String balanceId, Predicate predicate) {
    this.assetString = assetString;
    this.amount = amount;
    this.balanceId = balanceId;
    this.predicate = predicate;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getAmount() {
    return amount;
  }

  public String getBalanceId() {
    return balanceId;
  }

  public Predicate getPredicate() {
    return predicate;
  }
}

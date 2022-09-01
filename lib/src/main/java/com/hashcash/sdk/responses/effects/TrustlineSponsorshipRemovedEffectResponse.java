package com.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;

/**
 * Represents trustline_sponsorship_removed effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class TrustlineSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("former_sponsor")
  protected final String formerSponsor;

  public TrustlineSponsorshipRemovedEffectResponse(String assetString, String formerSponsor) {
    this.assetString = assetString;
    this.formerSponsor = formerSponsor;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
}

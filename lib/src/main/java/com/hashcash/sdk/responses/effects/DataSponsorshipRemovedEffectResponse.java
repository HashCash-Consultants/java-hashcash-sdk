package com.hashcash.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents data_sponsorship_removed effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class DataSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;
  @SerializedName("data_name")
  private final String dataName;

  public DataSponsorshipRemovedEffectResponse(String dataName, String formerSponsor) {
    this.dataName = dataName;
    this.formerSponsor = formerSponsor;
  }

  public String getFormerSponsor() {
    return formerSponsor;
  }
  public String getDataName() {
    return dataName;
  }
}

package com.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

/**
 * Represents account_thresholds_updated effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class AccountThresholdsUpdatedEffectResponse extends EffectResponse {
  @SerializedName("low_threshold")
  protected final Integer lowThreshold;
  @SerializedName("med_threshold")
  protected final Integer medThreshold;
  @SerializedName("high_threshold")
  protected final Integer highThreshold;

  AccountThresholdsUpdatedEffectResponse(Integer lowThreshold, Integer medThreshold, Integer highThreshold) {
    this.lowThreshold = lowThreshold;
    this.medThreshold = medThreshold;
    this.highThreshold = highThreshold;
  }

  public Integer getLowThreshold() {
    return lowThreshold;
  }

  public Integer getMedThreshold() {
    return medThreshold;
  }

  public Integer getHighThreshold() {
    return highThreshold;
  }
}

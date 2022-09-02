package com.hashcash.sdk.responses.effects;


import com.google.gson.annotations.SerializedName;

/**
 * Represents signer_sponsorship_removed effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class SignerSponsorshipRemovedEffectResponse extends EffectResponse {
  @SerializedName("former_sponsor")
  private final String formerSponsor;
  @SerializedName("signer")
  private final String signer;

  public SignerSponsorshipRemovedEffectResponse(String signer, String formerSponsor) {
    this.signer = signer;
    this.formerSponsor = formerSponsor;
  }

  public String getSigner() {
    return signer;
  }
  public String getFormerSponsor() {
    return formerSponsor;
  }

}

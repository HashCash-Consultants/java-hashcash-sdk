package org.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;

public class AccountHomeDomainUpdatedEffectResponse extends EffectResponse {
  @SerializedName("home_domain")
  protected final String homeDomain;

  AccountHomeDomainUpdatedEffectResponse(String homeDomain) {
    this.homeDomain = homeDomain;
  }

  public String getHomeDomain() {
    return homeDomain;
  }
}

package org.hashcash.sdk.responses.effects;

import org.hashcash.sdk.KeyPair;


public class TrustlineAuthorizedEffectResponse extends TrustlineAuthorizationResponse {
  TrustlineAuthorizedEffectResponse(KeyPair trustor, String assetType, String assetCode) {
    super(trustor, assetType, assetCode);
  }
}

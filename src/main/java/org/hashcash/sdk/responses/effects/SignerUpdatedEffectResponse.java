package org.hashcash.sdk.responses.effects;


public class SignerUpdatedEffectResponse extends SignerEffectResponse {
  SignerUpdatedEffectResponse(Integer weight, String publicKey) {
    super(weight, publicKey);
  }
}

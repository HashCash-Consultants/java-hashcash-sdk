package org.hashcash.sdk.responses.effects;


public class SignerCreatedEffectResponse extends SignerEffectResponse {
  SignerCreatedEffectResponse(Integer weight, String publicKey) {
    super(weight, publicKey);
  }
}

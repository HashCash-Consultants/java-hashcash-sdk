package com.hashcash.sdk.responses.effects;

import com.hashcash.sdk.AssetAmount;
import com.hashcash.sdk.LiquidityPoolID;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_removed effect response.
 *
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class LiquidityPoolRemovedEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool_id")
  protected final LiquidityPoolID liquidityPoolID;

  public LiquidityPoolRemovedEffectResponse(LiquidityPoolID liquidityPoolID) {
    this.liquidityPoolID = liquidityPoolID;
  }

  public LiquidityPoolID getLiquidityPoolID() {
    return liquidityPoolID;
  }
}

package com.hashcash.sdk.responses.effects;

import com.hashcash.sdk.AssetAmount;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_trade effect response.
 *
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class LiquidityPoolTradeEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool")
  protected final LiquidityPool liquidityPool;
  @SerializedName("sold")
  protected final AssetAmount sold;
  @SerializedName("bought")
  protected final AssetAmount bought;

  public LiquidityPoolTradeEffectResponse(LiquidityPool liquidityPool, AssetAmount sold, AssetAmount bought) {
    this.liquidityPool = liquidityPool;
    this.sold = sold;
    this.bought = bought;
  }

  public LiquidityPool getLiquidityPool() {
    return liquidityPool;
  }

  public AssetAmount getSold() {
    return sold;
  }

  public AssetAmount getBought() {
    return bought;
  }
}

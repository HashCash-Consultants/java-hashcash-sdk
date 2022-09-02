package com.hashcash.sdk.responses.effects;

import com.hashcash.sdk.AssetAmount;

import com.google.gson.annotations.SerializedName;

/**
 * Represents liquidity_pool_withdrew effect response.
 *
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class LiquidityPoolWithdrewEffectResponse extends EffectResponse {
  @SerializedName("liquidity_pool")
  protected final LiquidityPool liquidityPool;
  @SerializedName("reserves_received")
  protected final AssetAmount[] reservesReceived;
  @SerializedName("shares_redeemed")
  protected final String sharesRedeemed;

  public LiquidityPoolWithdrewEffectResponse(LiquidityPool liquidityPool, AssetAmount[] reservesReceived, String sharesRedeemed) {
    this.liquidityPool = liquidityPool;
    this.reservesReceived = reservesReceived;
    this.sharesRedeemed = sharesRedeemed;
  }

  public LiquidityPool getLiquidityPool() {
    return liquidityPool;
  }

  public AssetAmount[] getReservesReceived() {
    return reservesReceived;
  }

  public String getSharesRedeemed() {
    return sharesRedeemed;
  }
}

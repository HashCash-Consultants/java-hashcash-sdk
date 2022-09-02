package org.hashcash.sdk.responses.operations;

import org.hashcash.sdk.Asset;
import org.hashcash.sdk.AssetTypeNative;
import org.hashcash.sdk.KeyPair;

import com.google.gson.annotations.SerializedName;


public class AllowTrustOperationResponse extends OperationResponse {
  @SerializedName("trustor")
  protected final KeyPair trustor;
  @SerializedName("trustee")
  protected final KeyPair trustee;
  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;
  @SerializedName("authorize")
  protected final boolean authorize;

  AllowTrustOperationResponse(boolean authorize, String assetIssuer, String assetCode, String assetType, KeyPair trustee, KeyPair trustor) {
    this.authorize = authorize;
    this.assetIssuer = assetIssuer;
    this.assetCode = assetCode;
    this.assetType = assetType;
    this.trustee = trustee;
    this.trustor = trustor;
  }

  public KeyPair getTrustor() {
    return trustor;
  }

  public KeyPair getTrustee() {
    return trustee;
  }

  public boolean isAuthorize() {
    return authorize;
  }

  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      KeyPair issuer = KeyPair.fromAccountId(assetIssuer);
      return Asset.createNonNativeAsset(assetCode, issuer);
    }
  }
}

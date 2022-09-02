package org.hashcash.sdk.responses.operations;

import org.hashcash.sdk.Asset;
import org.hashcash.sdk.AssetTypeNative;
import org.hashcash.sdk.KeyPair;

import com.google.gson.annotations.SerializedName;


public class CreatePassiveOfferOperationResponse extends OperationResponse {
  @SerializedName("offer_id")
  protected final Integer offerId;
  @SerializedName("amount")
  protected final String amount;
  // Price is not implemented yet in aurora
  @SerializedName("price")
  protected final String price;


  @SerializedName("buying_asset_type")
  protected final String buyingAssetType;
  @SerializedName("buying_asset_code")
  protected final String buyingAssetCode;
  @SerializedName("buying_asset_issuer")
  protected final String buyingAssetIssuer;

  @SerializedName("selling_asset_type")
  protected final String sellingAssetType;
  @SerializedName("selling_asset_code")
  protected final String sellingAssetCode;
  @SerializedName("selling_asset_issuer")
  protected final String sellingAssetIssuer;

  CreatePassiveOfferOperationResponse(Integer offerId, String amount, String price, String buyingAssetType, String buyingAssetCode, String buyingAssetIssuer, String sellingAssetType, String sellingAssetCode, String sellingAssetIssuer) {
    this.offerId = offerId;
    this.amount = amount;
    this.price = price;
    this.buyingAssetType = buyingAssetType;
    this.buyingAssetCode = buyingAssetCode;
    this.buyingAssetIssuer = buyingAssetIssuer;
    this.sellingAssetType = sellingAssetType;
    this.sellingAssetCode = sellingAssetCode;
    this.sellingAssetIssuer = sellingAssetIssuer;
  }

  public Integer getOfferId() {
    return offerId;
  }

  public String getAmount() {
    return amount;
  }

  public String getPrice() {
    return price;
  }

  public Asset getBuyingAsset() {
    if (buyingAssetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      KeyPair issuer = KeyPair.fromAccountId(buyingAssetIssuer);
      return Asset.createNonNativeAsset(buyingAssetCode, issuer);
    }
  }

  public Asset getSellingAsset() {
    if (sellingAssetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      KeyPair issuer = KeyPair.fromAccountId(sellingAssetIssuer);
      return Asset.createNonNativeAsset(sellingAssetCode, issuer);
    }
  }
}

package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;
import com.hashcash.sdk.AssetTypeNative;

import static com.hashcash.sdk.Asset.create;

/**
 * Represents ManageBuyOffer operation response.
 * @see <a href="https://developers.stellar.org/api/resources/operations/" target="_blank">Operation documentation</a>
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class ManageBuyOfferOperationResponse extends OperationResponse {
  @SerializedName("offer_id")
  protected final Long offerId;
  @SerializedName("amount")
  protected final String amount;
  // Price is not implemented yet in horizon
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

  ManageBuyOfferOperationResponse(Long offerId, String amount, String price, String buyingAssetType, String buyingAssetCode, String buyingAssetIssuer, String sellingAssetType, String sellingAssetCode, String sellingAssetIssuer) {
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

  public Long getOfferId() {
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
      return create(buyingAssetType, buyingAssetCode, buyingAssetIssuer);
    }
  }

  public Asset getSellingAsset() {
    if (sellingAssetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      return create(sellingAssetType, sellingAssetCode, sellingAssetIssuer);
    }
  }
}

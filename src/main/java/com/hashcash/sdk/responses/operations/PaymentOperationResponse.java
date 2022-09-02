package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;
import com.hashcash.sdk.AssetTypeNative;

import static com.hashcash.sdk.Asset.create;

/**
 * Represents Payment operation response.
 * @see <a href="https://developers.stellar.org/api/resources/operations/" target="_blank">Operation documentation</a>
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class PaymentOperationResponse extends OperationResponse {
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;
  @SerializedName("from")
  protected final String from;
  @SerializedName("to")
  protected final String to;

  PaymentOperationResponse(String amount, String assetType, String assetCode, String assetIssuer, String from, String to) {
    this.amount = amount;
    this.assetType = assetType;
    this.assetCode = assetCode;
    this.assetIssuer = assetIssuer;
    this.from = from;
    this.to = to;
  }

  public String getAmount() {
    return amount;
  }

  public Asset getAsset() {
    if (assetType.equals("native")) {
      return new AssetTypeNative();
    } else {
      return create(assetType, assetCode, assetIssuer);
    }
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }
}

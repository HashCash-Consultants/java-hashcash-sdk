package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;
import com.hashcash.sdk.Claimant;

import java.util.List;

/**
 * Represents CreateClaimableBalance operation response.
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class CreateClaimableBalanceOperationResponse extends OperationResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("claimants")
  protected final List<Claimant> claimants;

  public CreateClaimableBalanceOperationResponse(String assetString, String amount, List<Claimant> claimants) {
    this.assetString = assetString;
    this.amount = amount;
    this.claimants = claimants;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getAmount() {
    return amount;
  }

  public List<Claimant> getClaimants() {
    return claimants;
  }
}

package com.hashcash.sdk.responses;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;

import java.util.ArrayList;

import static com.hashcash.sdk.Asset.create;

/**
 * Represents path response.
 * @see <a href="https://developers.stellar.org/api/aggregations/paths/" target="_blank">Path documentation</a>
 * @see com.hashcash.sdk.requests.StrictReceivePathsRequestBuilder
 * @see com.hashcash.sdk.requests.StrictSendPathsRequestBuilder
 * @see com.hashcash.sdk.Server#strictReceivePaths()
 * @see com.hashcash.sdk.Server#strictSendPaths()
 */
public class PathResponse extends Response {
  @SerializedName("destination_amount")
  private final String destinationAmount;
  @SerializedName("destination_asset_type")
  private final String destinationAssetType;
  @SerializedName("destination_asset_code")
  private final String destinationAssetCode;
  @SerializedName("destination_asset_issuer")
  private final String destinationAssetIssuer;

  @SerializedName("source_amount")
  private final String sourceAmount;
  @SerializedName("source_asset_type")
  private final String sourceAssetType;
  @SerializedName("source_asset_code")
  private final String sourceAssetCode;
  @SerializedName("source_asset_issuer")
  private final String sourceAssetIssuer;

  @SerializedName("path")
  private final ArrayList<Asset> path;

  @SerializedName("_links")
  private final Links links;

  PathResponse(String destinationAmount, String destinationAssetType, String destinationAssetCode, String destinationAssetIssuer, String sourceAmount, String sourceAssetType, String sourceAssetCode, String sourceAssetIssuer, ArrayList<Asset> path, Links links) {
    this.destinationAmount = destinationAmount;
    this.destinationAssetType = destinationAssetType;
    this.destinationAssetCode = destinationAssetCode;
    this.destinationAssetIssuer = destinationAssetIssuer;
    this.sourceAmount = sourceAmount;
    this.sourceAssetType = sourceAssetType;
    this.sourceAssetCode = sourceAssetCode;
    this.sourceAssetIssuer = sourceAssetIssuer;
    this.path = path;
    this.links = links;
  }

  public String getDestinationAmount() {
    return destinationAmount;
  }

  public String getSourceAmount() {
    return sourceAmount;
  }

  public ArrayList<Asset> getPath() {
    return path;
  }

  public Asset getDestinationAsset() {
    return create(destinationAssetType, destinationAssetCode, destinationAssetIssuer);
  }

  public Asset getSourceAsset() {
    return create(sourceAssetType,sourceAssetCode, sourceAssetIssuer);
  }

  public Links getLinks() {
    return links;
  }

  /**
   * Links connected to path.
   */
  public static class Links {
    @SerializedName("self")
    private final Link self;

    Links(Link self) {
      this.self = self;
    }

    public Link getSelf() {
      return self;
    }
  }
}

package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;

import java.util.List;

/**
 * Represents PATH_PAYMENT_STRICT_SEND operation response.
 *
 * @see <a href="https://developers.stellar.org/api/resources/operations/" target="_blank">Operation documentation</a>
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class PathPaymentStrictSendOperationResponse extends PathPaymentBaseOperationResponse {
  @SerializedName("destination_min")
  private String destinationMin;

  public String getDestinationMin() {
    return destinationMin;
  }
}

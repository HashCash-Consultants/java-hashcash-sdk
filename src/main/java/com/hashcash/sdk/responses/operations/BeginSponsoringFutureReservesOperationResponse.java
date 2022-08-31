package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

/**
 * Represents BeginSponsoringFutureReserves operation response.
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class BeginSponsoringFutureReservesOperationResponse extends OperationResponse {
  @SerializedName("sponsored_id")
  private final String sponsoredId;

  public BeginSponsoringFutureReservesOperationResponse(String sponsoredId) {
    this.sponsoredId = sponsoredId;
  }

  public String getSponsoredId() {
    return sponsoredId;
  }
}

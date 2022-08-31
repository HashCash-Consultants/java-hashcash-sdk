package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

/**
 * Represents ManageDataoperation response.
 * @see <a href="https://developers.stellar.org/api/resources/operations/" target="_blank">Operation documentation</a>
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class ManageDataOperationResponse extends OperationResponse {
  @SerializedName("name")
  protected final String name;
  @SerializedName("value")
  protected final String value;

  ManageDataOperationResponse(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }
}

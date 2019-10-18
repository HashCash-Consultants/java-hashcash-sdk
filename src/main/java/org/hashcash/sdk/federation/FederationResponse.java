package org.hashcash.sdk.federation;

import com.google.gson.annotations.SerializedName;


public class FederationResponse {
  @SerializedName("HcNet_address")
  private final String HcNetAddress;
  @SerializedName("account_id")
  private final String accountId;
  @SerializedName("memo_type")
  private final String memoType;
  @SerializedName("memo")
  private final String memo;

  public FederationResponse(String HcNetAddress, String accountId, String memoType, String memo) {
    this.HcNetAddress = HcNetAddress;
    this.accountId = accountId;
    this.memoType = memoType;
    this.memo = memo;
  }

  public String getHcNetAddress() {
    return HcNetAddress;
  }

  public String getAccountId() {
    return accountId;
  }

  /**
   * @return Memo type or null when no memo attached
   */
  public String getMemoType() {
    return memoType;
  }

  /**
   * @return Memo value or null when no memo attached
   */
  public String getMemo() {
    return memo;
  }
}

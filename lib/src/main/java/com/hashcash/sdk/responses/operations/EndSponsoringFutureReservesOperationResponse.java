package com.hashcash.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.responses.MuxedAccount;

import java.math.BigInteger;

/**
 * Represents EndSponsoringFutureReserves operation response.
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class EndSponsoringFutureReservesOperationResponse extends OperationResponse {
  @SerializedName("begin_sponsor")
  private String beginSponsor;
  @SerializedName("begin_sponsor_muxed")
  private String beginSponsorMuxed;
  @SerializedName("begin_sponsor_muxed_id")
  private BigInteger beginSponsorMuxedId;

  public Optional<MuxedAccount> getBeginSponsorMuxed() {
    if (this.beginSponsorMuxed == null || this.beginSponsorMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.beginSponsorMuxed, this.beginSponsor, this.beginSponsorMuxedId));
  }

  public String getBeginSponsor() {
    return beginSponsor;
  }
}

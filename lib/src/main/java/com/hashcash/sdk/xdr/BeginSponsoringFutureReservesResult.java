// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union BeginSponsoringFutureReservesResult switch (
//      BeginSponsoringFutureReservesResultCode code)
//  {
//  case BEGIN_SPONSORING_FUTURE_RESERVES_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class BeginSponsoringFutureReservesResult implements XdrElement {
  public BeginSponsoringFutureReservesResult () {}
  BeginSponsoringFutureReservesResultCode code;
  public BeginSponsoringFutureReservesResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(BeginSponsoringFutureReservesResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private BeginSponsoringFutureReservesResultCode discriminant;

    public Builder discriminant(BeginSponsoringFutureReservesResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public BeginSponsoringFutureReservesResult build() {
      BeginSponsoringFutureReservesResult val = new BeginSponsoringFutureReservesResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, BeginSponsoringFutureReservesResult encodedBeginSponsoringFutureReservesResult) throws IOException {
  //Xdrgen::AST::Identifier
  //BeginSponsoringFutureReservesResultCode
  stream.writeInt(encodedBeginSponsoringFutureReservesResult.getDiscriminant().getValue());
  switch (encodedBeginSponsoringFutureReservesResult.getDiscriminant()) {
  case BEGIN_SPONSORING_FUTURE_RESERVES_SUCCESS:
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static BeginSponsoringFutureReservesResult decode(XdrDataInputStream stream) throws IOException {
  BeginSponsoringFutureReservesResult decodedBeginSponsoringFutureReservesResult = new BeginSponsoringFutureReservesResult();
  BeginSponsoringFutureReservesResultCode discriminant = BeginSponsoringFutureReservesResultCode.decode(stream);
  decodedBeginSponsoringFutureReservesResult.setDiscriminant(discriminant);
  switch (decodedBeginSponsoringFutureReservesResult.getDiscriminant()) {
  case BEGIN_SPONSORING_FUTURE_RESERVES_SUCCESS:
  break;
  default:
  break;
  }
    return decodedBeginSponsoringFutureReservesResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof BeginSponsoringFutureReservesResult)) {
      return false;
    }

    BeginSponsoringFutureReservesResult other = (BeginSponsoringFutureReservesResult) object;
    return Objects.equal(this.code, other.code);
  }
}

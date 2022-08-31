// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union PaymentResult switch (PaymentResultCode code)
//  {
//  case PAYMENT_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class PaymentResult implements XdrElement {
  public PaymentResult () {}
  PaymentResultCode code;
  public PaymentResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(PaymentResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private PaymentResultCode discriminant;

    public Builder discriminant(PaymentResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public PaymentResult build() {
      PaymentResult val = new PaymentResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, PaymentResult encodedPaymentResult) throws IOException {
  //Xdrgen::AST::Identifier
  //PaymentResultCode
  stream.writeInt(encodedPaymentResult.getDiscriminant().getValue());
  switch (encodedPaymentResult.getDiscriminant()) {
  case PAYMENT_SUCCESS:
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static PaymentResult decode(XdrDataInputStream stream) throws IOException {
  PaymentResult decodedPaymentResult = new PaymentResult();
  PaymentResultCode discriminant = PaymentResultCode.decode(stream);
  decodedPaymentResult.setDiscriminant(discriminant);
  switch (decodedPaymentResult.getDiscriminant()) {
  case PAYMENT_SUCCESS:
  break;
  default:
  break;
  }
    return decodedPaymentResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof PaymentResult)) {
      return false;
    }

    PaymentResult other = (PaymentResult) object;
    return Objects.equal(this.code, other.code);
  }
}

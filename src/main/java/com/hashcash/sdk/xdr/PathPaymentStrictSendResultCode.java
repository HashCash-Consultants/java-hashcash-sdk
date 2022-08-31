// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum PathPaymentStrictSendResultCode
//  {
//      // codes considered as "success" for the operation
//      PATH_PAYMENT_STRICT_SEND_SUCCESS = 0, // success
//  
//      // codes considered as "failure" for the operation
//      PATH_PAYMENT_STRICT_SEND_MALFORMED = -1, // bad input
//      PATH_PAYMENT_STRICT_SEND_UNDERFUNDED =
//          -2, // not enough funds in source account
//      PATH_PAYMENT_STRICT_SEND_SRC_NO_TRUST =
//          -3, // no trust line on source account
//      PATH_PAYMENT_STRICT_SEND_SRC_NOT_AUTHORIZED =
//          -4, // source not authorized to transfer
//      PATH_PAYMENT_STRICT_SEND_NO_DESTINATION =
//          -5, // destination account does not exist
//      PATH_PAYMENT_STRICT_SEND_NO_TRUST =
//          -6, // dest missing a trust line for asset
//      PATH_PAYMENT_STRICT_SEND_NOT_AUTHORIZED =
//          -7, // dest not authorized to hold asset
//      PATH_PAYMENT_STRICT_SEND_LINE_FULL = -8, // dest would go above their limit
//      PATH_PAYMENT_STRICT_SEND_NO_ISSUER = -9, // missing issuer on one asset
//      PATH_PAYMENT_STRICT_SEND_TOO_FEW_OFFERS =
//          -10, // not enough offers to satisfy path
//      PATH_PAYMENT_STRICT_SEND_OFFER_CROSS_SELF =
//          -11, // would cross one of its own offers
//      PATH_PAYMENT_STRICT_SEND_UNDER_DESTMIN = -12 // could not satisfy destMin
//  };

//  ===========================================================================
public enum PathPaymentStrictSendResultCode implements XdrElement {
  PATH_PAYMENT_STRICT_SEND_SUCCESS(0),
  PATH_PAYMENT_STRICT_SEND_MALFORMED(-1),
  PATH_PAYMENT_STRICT_SEND_UNDERFUNDED(-2),
  PATH_PAYMENT_STRICT_SEND_SRC_NO_TRUST(-3),
  PATH_PAYMENT_STRICT_SEND_SRC_NOT_AUTHORIZED(-4),
  PATH_PAYMENT_STRICT_SEND_NO_DESTINATION(-5),
  PATH_PAYMENT_STRICT_SEND_NO_TRUST(-6),
  PATH_PAYMENT_STRICT_SEND_NOT_AUTHORIZED(-7),
  PATH_PAYMENT_STRICT_SEND_LINE_FULL(-8),
  PATH_PAYMENT_STRICT_SEND_NO_ISSUER(-9),
  PATH_PAYMENT_STRICT_SEND_TOO_FEW_OFFERS(-10),
  PATH_PAYMENT_STRICT_SEND_OFFER_CROSS_SELF(-11),
  PATH_PAYMENT_STRICT_SEND_UNDER_DESTMIN(-12),
  ;
  private int mValue;

  PathPaymentStrictSendResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static PathPaymentStrictSendResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return PATH_PAYMENT_STRICT_SEND_SUCCESS;
      case -1: return PATH_PAYMENT_STRICT_SEND_MALFORMED;
      case -2: return PATH_PAYMENT_STRICT_SEND_UNDERFUNDED;
      case -3: return PATH_PAYMENT_STRICT_SEND_SRC_NO_TRUST;
      case -4: return PATH_PAYMENT_STRICT_SEND_SRC_NOT_AUTHORIZED;
      case -5: return PATH_PAYMENT_STRICT_SEND_NO_DESTINATION;
      case -6: return PATH_PAYMENT_STRICT_SEND_NO_TRUST;
      case -7: return PATH_PAYMENT_STRICT_SEND_NOT_AUTHORIZED;
      case -8: return PATH_PAYMENT_STRICT_SEND_LINE_FULL;
      case -9: return PATH_PAYMENT_STRICT_SEND_NO_ISSUER;
      case -10: return PATH_PAYMENT_STRICT_SEND_TOO_FEW_OFFERS;
      case -11: return PATH_PAYMENT_STRICT_SEND_OFFER_CROSS_SELF;
      case -12: return PATH_PAYMENT_STRICT_SEND_UNDER_DESTMIN;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, PathPaymentStrictSendResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}

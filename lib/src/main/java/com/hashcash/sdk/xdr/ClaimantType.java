// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum ClaimantType
//  {
//      CLAIMANT_TYPE_V0 = 0
//  };

//  ===========================================================================
public enum ClaimantType implements XdrElement {
  CLAIMANT_TYPE_V0(0),
  ;
  private int mValue;

  ClaimantType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static ClaimantType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return CLAIMANT_TYPE_V0;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, ClaimantType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}

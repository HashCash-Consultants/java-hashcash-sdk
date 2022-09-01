// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  typedef int int32;

//  ===========================================================================
public class Int32 implements XdrElement {
  private Integer int32;

  public Int32() {}

  public Int32(Integer int32) {
    this.int32 = int32;
  }

  public Integer getInt32() {
    return this.int32;
  }

  public void setInt32(Integer value) {
    this.int32 = value;
  }

  public static void encode(XdrDataOutputStream stream, Int32  encodedInt32) throws IOException {
    stream.writeInt(encodedInt32.int32);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Int32 decode(XdrDataInputStream stream) throws IOException {
    Int32 decodedInt32 = new Int32();
    decodedInt32.int32 = stream.readInt();
    return decodedInt32;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.int32);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Int32)) {
      return false;
    }

    Int32 other = (Int32) object;
    return Objects.equal(this.int32, other.int32);
  }
}

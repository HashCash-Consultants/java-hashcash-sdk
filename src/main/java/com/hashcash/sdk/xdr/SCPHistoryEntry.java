// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union SCPHistoryEntry switch (int v)
//  {
//  case 0:
//      SCPHistoryEntryV0 v0;
//  };

//  ===========================================================================
public class SCPHistoryEntry implements XdrElement {
  public SCPHistoryEntry () {}
  Integer v;
  public Integer getDiscriminant() {
    return this.v;
  }
  public void setDiscriminant(Integer value) {
    this.v = value;
  }
  private SCPHistoryEntryV0 v0;
  public SCPHistoryEntryV0 getV0() {
    return this.v0;
  }
  public void setV0(SCPHistoryEntryV0 value) {
    this.v0 = value;
  }

  public static final class Builder {
    private Integer discriminant;
    private SCPHistoryEntryV0 v0;

    public Builder discriminant(Integer discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder v0(SCPHistoryEntryV0 v0) {
      this.v0 = v0;
      return this;
    }

    public SCPHistoryEntry build() {
      SCPHistoryEntry val = new SCPHistoryEntry();
      val.setDiscriminant(discriminant);
      val.setV0(v0);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, SCPHistoryEntry encodedSCPHistoryEntry) throws IOException {
  //Xdrgen::AST::Typespecs::Int
  //Integer
  stream.writeInt(encodedSCPHistoryEntry.getDiscriminant().intValue());
  switch (encodedSCPHistoryEntry.getDiscriminant()) {
  case 0:
  SCPHistoryEntryV0.encode(stream, encodedSCPHistoryEntry.v0);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static SCPHistoryEntry decode(XdrDataInputStream stream) throws IOException {
  SCPHistoryEntry decodedSCPHistoryEntry = new SCPHistoryEntry();
  Integer discriminant = stream.readInt();
  decodedSCPHistoryEntry.setDiscriminant(discriminant);
  switch (decodedSCPHistoryEntry.getDiscriminant()) {
  case 0:
  decodedSCPHistoryEntry.v0 = SCPHistoryEntryV0.decode(stream);
  break;
  }
    return decodedSCPHistoryEntry;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.v0, this.v);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCPHistoryEntry)) {
      return false;
    }

    SCPHistoryEntry other = (SCPHistoryEntry) object;
    return Objects.equal(this.v0, other.v0) && Objects.equal(this.v, other.v);
  }
}

// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct LedgerCloseValueSignature
//  {
//      NodeID nodeID;       // which node introduced the value
//      Signature signature; // nodeID's signature
//  };

//  ===========================================================================
public class LedgerCloseValueSignature implements XdrElement {
  public LedgerCloseValueSignature () {}
  private NodeID nodeID;
  public NodeID getNodeID() {
    return this.nodeID;
  }
  public void setNodeID(NodeID value) {
    this.nodeID = value;
  }
  private Signature signature;
  public Signature getSignature() {
    return this.signature;
  }
  public void setSignature(Signature value) {
    this.signature = value;
  }
  public static void encode(XdrDataOutputStream stream, LedgerCloseValueSignature encodedLedgerCloseValueSignature) throws IOException{
    NodeID.encode(stream, encodedLedgerCloseValueSignature.nodeID);
    Signature.encode(stream, encodedLedgerCloseValueSignature.signature);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static LedgerCloseValueSignature decode(XdrDataInputStream stream) throws IOException {
    LedgerCloseValueSignature decodedLedgerCloseValueSignature = new LedgerCloseValueSignature();
    decodedLedgerCloseValueSignature.nodeID = NodeID.decode(stream);
    decodedLedgerCloseValueSignature.signature = Signature.decode(stream);
    return decodedLedgerCloseValueSignature;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.nodeID, this.signature);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LedgerCloseValueSignature)) {
      return false;
    }

    LedgerCloseValueSignature other = (LedgerCloseValueSignature) object;
    return Objects.equal(this.nodeID, other.nodeID) && Objects.equal(this.signature, other.signature);
  }

  public static final class Builder {
    private NodeID nodeID;
    private Signature signature;

    public Builder nodeID(NodeID nodeID) {
      this.nodeID = nodeID;
      return this;
    }

    public Builder signature(Signature signature) {
      this.signature = signature;
      return this;
    }

    public LedgerCloseValueSignature build() {
      LedgerCloseValueSignature val = new LedgerCloseValueSignature();
      val.setNodeID(nodeID);
      val.setSignature(signature);
      return val;
    }
  }
}

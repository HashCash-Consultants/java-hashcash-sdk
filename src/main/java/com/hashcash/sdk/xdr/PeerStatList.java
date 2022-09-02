// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;

// === xdr source ============================================================

//  typedef PeerStats PeerStatList<25>;

//  ===========================================================================
public class PeerStatList implements XdrElement {
  private PeerStats[] PeerStatList;

  public PeerStatList() {}

  public PeerStatList(PeerStats[] PeerStatList) {
    this.PeerStatList = PeerStatList;
  }

  public PeerStats[] getPeerStatList() {
    return this.PeerStatList;
  }

  public void setPeerStatList(PeerStats[] value) {
    this.PeerStatList = value;
  }

  public static void encode(XdrDataOutputStream stream, PeerStatList  encodedPeerStatList) throws IOException {
    int PeerStatListsize = encodedPeerStatList.getPeerStatList().length;
    stream.writeInt(PeerStatListsize);
    for (int i = 0; i < PeerStatListsize; i++) {
      PeerStats.encode(stream, encodedPeerStatList.PeerStatList[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static PeerStatList decode(XdrDataInputStream stream) throws IOException {
    PeerStatList decodedPeerStatList = new PeerStatList();
    int PeerStatListsize = stream.readInt();
    decodedPeerStatList.PeerStatList = new PeerStats[PeerStatListsize];
    for (int i = 0; i < PeerStatListsize; i++) {
      decodedPeerStatList.PeerStatList[i] = PeerStats.decode(stream);
    }
    return decodedPeerStatList;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.PeerStatList);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof PeerStatList)) {
      return false;
    }

    PeerStatList other = (PeerStatList) object;
    return Arrays.equals(this.PeerStatList, other.PeerStatList);
  }
}

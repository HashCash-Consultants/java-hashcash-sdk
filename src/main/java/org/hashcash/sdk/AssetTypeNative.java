package org.hashcash.sdk;

import org.hashcash.sdk.xdr.AssetType;


public final class AssetTypeNative extends Asset {

  public AssetTypeNative() {}

  @Override
  public String getType() {
    return "native";
  }

  @Override
  public boolean equals(Object object) {
    return this.getClass().equals(object.getClass());
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public org.hashcash.sdk.xdr.Asset toXdr() {
    org.hashcash.sdk.xdr.Asset xdr = new org.hashcash.sdk.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_NATIVE);
    return xdr;
  }
}

package com.hashcash.sdk;

import com.hashcash.sdk.xdr.AssetType;

/**
 * Represents Stellar native asset - <a href="https://developers.stellar.org/docs/glossary/assets/" target="_blank">lumens (XLM)</a>
 * @see <a href="https://developers.stellar.org/docs/glossary/assets/" target="_blank">Assets</a>
 */
public final class AssetTypeNative extends Asset {

  public AssetTypeNative() {}

  @Override
  public String toString() {
    return "native";
  }

  @Override
  public String getType() {
    return "native";
  }

  @Override
  public boolean equals(Object object) {
    if (object != null) {
      return this.getClass().equals(object.getClass());
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public com.hashcash.sdk.xdr.Asset toXdr() {
    com.hashcash.sdk.xdr.Asset xdr = new com.hashcash.sdk.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_NATIVE);
    return xdr;
  }

  @Override
  public int compareTo(Asset other) {
    if (other.getType() == "native") {
      return 0;
    }
    return -1;
  }
}

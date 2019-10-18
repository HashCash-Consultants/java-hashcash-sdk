package org.hashcash.sdk;

import org.hashcash.sdk.xdr.AccountID;
import org.hashcash.sdk.xdr.AssetType;


public final class AssetTypeCreditAlphaNum4 extends AssetTypeCreditAlphaNum {

  /**
   * Class constructor
   * @param code Asset code
   * @param issuer Asset issuer
   */
  public AssetTypeCreditAlphaNum4(String code, KeyPair issuer) {
    super(code, issuer);
    if (code.length() < 1 || code.length() > 4) {
      throw new AssetCodeLengthInvalidException();
    }
  }

  @Override
  public String getType() {
    return "credit_alphanum4";
  }

  @Override
  public org.hashcash.sdk.xdr.Asset toXdr() {
    org.hashcash.sdk.xdr.Asset xdr = new org.hashcash.sdk.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_CREDIT_ALPHANUM4);
    org.hashcash.sdk.xdr.Asset.AssetAlphaNum4 credit = new org.hashcash.sdk.xdr.Asset.AssetAlphaNum4();
    credit.setAssetCode(Util.paddedByteArray(mCode, 4));
    AccountID accountID = new AccountID();
    accountID.setAccountID(mIssuer.getXdrPublicKey());
    credit.setIssuer(accountID);
    xdr.setAlphaNum4(credit);
    return xdr;
  }
}

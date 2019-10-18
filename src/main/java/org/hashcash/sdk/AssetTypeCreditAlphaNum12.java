package org.hashcash.sdk;

import org.hashcash.sdk.xdr.AccountID;
import org.hashcash.sdk.xdr.AssetType;


public final class AssetTypeCreditAlphaNum12 extends AssetTypeCreditAlphaNum {

  /**
   * Class constructor
   * @param code Asset code
   * @param issuer Asset issuer
   */
  public AssetTypeCreditAlphaNum12(String code, KeyPair issuer) {
    super(code, issuer);
    if (code.length() < 5 || code.length() > 12) {
      throw new AssetCodeLengthInvalidException();
    }
  }

  @Override
  public String getType() {
    return "credit_alphanum12";
  }

  @Override
  public org.hashcash.sdk.xdr.Asset toXdr() {
    org.hashcash.sdk.xdr.Asset xdr = new org.hashcash.sdk.xdr.Asset();
    xdr.setDiscriminant(AssetType.ASSET_TYPE_CREDIT_ALPHANUM12);
    org.hashcash.sdk.xdr.Asset.AssetAlphaNum12 credit = new org.hashcash.sdk.xdr.Asset.AssetAlphaNum12();
    credit.setAssetCode(Util.paddedByteArray(mCode, 12));
    AccountID accountID = new AccountID();
    accountID.setAccountID(mIssuer.getXdrPublicKey());
    credit.setIssuer(accountID);
    xdr.setAlphaNum12(credit);
    return xdr;
  }
}

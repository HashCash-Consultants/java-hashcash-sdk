// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;
import java.util.Arrays;

// === xdr source ============================================================

//  struct AccountEntryExtensionV2
//  {
//      uint32 numSponsored;
//      uint32 numSponsoring;
//      SponsorshipDescriptor signerSponsoringIDs<MAX_SIGNERS>;
//  
//      union switch (int v)
//      {
//      case 0:
//          void;
//      case 3:
//          AccountEntryExtensionV3 v3;
//      }
//      ext;
//  };

//  ===========================================================================
public class AccountEntryExtensionV2 implements XdrElement {
  public AccountEntryExtensionV2 () {}
  private Uint32 numSponsored;
  public Uint32 getNumSponsored() {
    return this.numSponsored;
  }
  public void setNumSponsored(Uint32 value) {
    this.numSponsored = value;
  }
  private Uint32 numSponsoring;
  public Uint32 getNumSponsoring() {
    return this.numSponsoring;
  }
  public void setNumSponsoring(Uint32 value) {
    this.numSponsoring = value;
  }
  private SponsorshipDescriptor[] signerSponsoringIDs;
  public SponsorshipDescriptor[] getSignerSponsoringIDs() {
    return this.signerSponsoringIDs;
  }
  public void setSignerSponsoringIDs(SponsorshipDescriptor[] value) {
    this.signerSponsoringIDs = value;
  }
  private AccountEntryExtensionV2Ext ext;
  public AccountEntryExtensionV2Ext getExt() {
    return this.ext;
  }
  public void setExt(AccountEntryExtensionV2Ext value) {
    this.ext = value;
  }
  public static void encode(XdrDataOutputStream stream, AccountEntryExtensionV2 encodedAccountEntryExtensionV2) throws IOException{
    Uint32.encode(stream, encodedAccountEntryExtensionV2.numSponsored);
    Uint32.encode(stream, encodedAccountEntryExtensionV2.numSponsoring);
    int signerSponsoringIDssize = encodedAccountEntryExtensionV2.getSignerSponsoringIDs().length;
    stream.writeInt(signerSponsoringIDssize);
    for (int i = 0; i < signerSponsoringIDssize; i++) {
      SponsorshipDescriptor.encode(stream, encodedAccountEntryExtensionV2.signerSponsoringIDs[i]);
    }
    AccountEntryExtensionV2Ext.encode(stream, encodedAccountEntryExtensionV2.ext);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static AccountEntryExtensionV2 decode(XdrDataInputStream stream) throws IOException {
    AccountEntryExtensionV2 decodedAccountEntryExtensionV2 = new AccountEntryExtensionV2();
    decodedAccountEntryExtensionV2.numSponsored = Uint32.decode(stream);
    decodedAccountEntryExtensionV2.numSponsoring = Uint32.decode(stream);
    int signerSponsoringIDssize = stream.readInt();
    decodedAccountEntryExtensionV2.signerSponsoringIDs = new SponsorshipDescriptor[signerSponsoringIDssize];
    for (int i = 0; i < signerSponsoringIDssize; i++) {
      decodedAccountEntryExtensionV2.signerSponsoringIDs[i] = SponsorshipDescriptor.decode(stream);
    }
    decodedAccountEntryExtensionV2.ext = AccountEntryExtensionV2Ext.decode(stream);
    return decodedAccountEntryExtensionV2;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.numSponsored, this.numSponsoring, Arrays.hashCode(this.signerSponsoringIDs), this.ext);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof AccountEntryExtensionV2)) {
      return false;
    }

    AccountEntryExtensionV2 other = (AccountEntryExtensionV2) object;
    return Objects.equal(this.numSponsored, other.numSponsored) && Objects.equal(this.numSponsoring, other.numSponsoring) && Arrays.equals(this.signerSponsoringIDs, other.signerSponsoringIDs) && Objects.equal(this.ext, other.ext);
  }

  public static final class Builder {
    private Uint32 numSponsored;
    private Uint32 numSponsoring;
    private SponsorshipDescriptor[] signerSponsoringIDs;
    private AccountEntryExtensionV2Ext ext;

    public Builder numSponsored(Uint32 numSponsored) {
      this.numSponsored = numSponsored;
      return this;
    }

    public Builder numSponsoring(Uint32 numSponsoring) {
      this.numSponsoring = numSponsoring;
      return this;
    }

    public Builder signerSponsoringIDs(SponsorshipDescriptor[] signerSponsoringIDs) {
      this.signerSponsoringIDs = signerSponsoringIDs;
      return this;
    }

    public Builder ext(AccountEntryExtensionV2Ext ext) {
      this.ext = ext;
      return this;
    }

    public AccountEntryExtensionV2 build() {
      AccountEntryExtensionV2 val = new AccountEntryExtensionV2();
      val.setNumSponsored(numSponsored);
      val.setNumSponsoring(numSponsoring);
      val.setSignerSponsoringIDs(signerSponsoringIDs);
      val.setExt(ext);
      return val;
    }
  }

  public static class AccountEntryExtensionV2Ext {
    public AccountEntryExtensionV2Ext () {}
    Integer v;
    public Integer getDiscriminant() {
      return this.v;
    }
    public void setDiscriminant(Integer value) {
      this.v = value;
    }
    private AccountEntryExtensionV3 v3;
    public AccountEntryExtensionV3 getV3() {
      return this.v3;
    }
    public void setV3(AccountEntryExtensionV3 value) {
      this.v3 = value;
    }

    public static final class Builder {
      private Integer discriminant;
      private AccountEntryExtensionV3 v3;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder v3(AccountEntryExtensionV3 v3) {
        this.v3 = v3;
        return this;
      }

      public AccountEntryExtensionV2Ext build() {
        AccountEntryExtensionV2Ext val = new AccountEntryExtensionV2Ext();
        val.setDiscriminant(discriminant);
        val.setV3(v3);
        return val;
      }
    }

    public static void encode(XdrDataOutputStream stream, AccountEntryExtensionV2Ext encodedAccountEntryExtensionV2Ext) throws IOException {
    //Xdrgen::AST::Typespecs::Int
    //Integer
    stream.writeInt(encodedAccountEntryExtensionV2Ext.getDiscriminant().intValue());
    switch (encodedAccountEntryExtensionV2Ext.getDiscriminant()) {
    case 0:
    break;
    case 3:
    AccountEntryExtensionV3.encode(stream, encodedAccountEntryExtensionV2Ext.v3);
    break;
    }
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static AccountEntryExtensionV2Ext decode(XdrDataInputStream stream) throws IOException {
    AccountEntryExtensionV2Ext decodedAccountEntryExtensionV2Ext = new AccountEntryExtensionV2Ext();
    Integer discriminant = stream.readInt();
    decodedAccountEntryExtensionV2Ext.setDiscriminant(discriminant);
    switch (decodedAccountEntryExtensionV2Ext.getDiscriminant()) {
    case 0:
    break;
    case 3:
    decodedAccountEntryExtensionV2Ext.v3 = AccountEntryExtensionV3.decode(stream);
    break;
    }
      return decodedAccountEntryExtensionV2Ext;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.v3, this.v);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof AccountEntryExtensionV2Ext)) {
        return false;
      }

      AccountEntryExtensionV2Ext other = (AccountEntryExtensionV2Ext) object;
      return Objects.equal(this.v3, other.v3) && Objects.equal(this.v, other.v);
    }

  }
}

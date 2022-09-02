// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union AuthenticatedMessage switch (uint32 v)
//  {
//  case 0:
//      struct
//      {
//          uint64 sequence;
//          StellarMessage message;
//          HmacSha256Mac mac;
//      } v0;
//  };

//  ===========================================================================
public class AuthenticatedMessage implements XdrElement {
  public AuthenticatedMessage () {}
  Uint32 v;
  public Uint32 getDiscriminant() {
    return this.v;
  }
  public void setDiscriminant(Uint32 value) {
    this.v = value;
  }
  private AuthenticatedMessageV0 v0;
  public AuthenticatedMessageV0 getV0() {
    return this.v0;
  }
  public void setV0(AuthenticatedMessageV0 value) {
    this.v0 = value;
  }

  public static final class Builder {
    private Uint32 discriminant;
    private AuthenticatedMessageV0 v0;

    public Builder discriminant(Uint32 discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder v0(AuthenticatedMessageV0 v0) {
      this.v0 = v0;
      return this;
    }

    public AuthenticatedMessage build() {
      AuthenticatedMessage val = new AuthenticatedMessage();
      val.setDiscriminant(discriminant);
      val.setV0(v0);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, AuthenticatedMessage encodedAuthenticatedMessage) throws IOException {
  //Xdrgen::AST::Identifier
  //Uint32
  stream.writeInt(encodedAuthenticatedMessage.getDiscriminant().getUint32());
  switch (encodedAuthenticatedMessage.getDiscriminant().getUint32()) {
  case 0:
  AuthenticatedMessageV0.encode(stream, encodedAuthenticatedMessage.v0);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static AuthenticatedMessage decode(XdrDataInputStream stream) throws IOException {
  AuthenticatedMessage decodedAuthenticatedMessage = new AuthenticatedMessage();
  Uint32 discriminant = Uint32.decode(stream);
  decodedAuthenticatedMessage.setDiscriminant(discriminant);
  switch (decodedAuthenticatedMessage.getDiscriminant().getUint32()) {
  case 0:
  decodedAuthenticatedMessage.v0 = AuthenticatedMessageV0.decode(stream);
  break;
  }
    return decodedAuthenticatedMessage;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.v0, this.v);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof AuthenticatedMessage)) {
      return false;
    }

    AuthenticatedMessage other = (AuthenticatedMessage) object;
    return Objects.equal(this.v0, other.v0) && Objects.equal(this.v, other.v);
  }

  public static class AuthenticatedMessageV0 {
    public AuthenticatedMessageV0 () {}
    private Uint64 sequence;
    public Uint64 getSequence() {
      return this.sequence;
    }
    public void setSequence(Uint64 value) {
      this.sequence = value;
    }
    private StellarMessage message;
    public StellarMessage getMessage() {
      return this.message;
    }
    public void setMessage(StellarMessage value) {
      this.message = value;
    }
    private HmacSha256Mac mac;
    public HmacSha256Mac getMac() {
      return this.mac;
    }
    public void setMac(HmacSha256Mac value) {
      this.mac = value;
    }
    public static void encode(XdrDataOutputStream stream, AuthenticatedMessageV0 encodedAuthenticatedMessageV0) throws IOException{
      Uint64.encode(stream, encodedAuthenticatedMessageV0.sequence);
      StellarMessage.encode(stream, encodedAuthenticatedMessageV0.message);
      HmacSha256Mac.encode(stream, encodedAuthenticatedMessageV0.mac);
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static AuthenticatedMessageV0 decode(XdrDataInputStream stream) throws IOException {
      AuthenticatedMessageV0 decodedAuthenticatedMessageV0 = new AuthenticatedMessageV0();
      decodedAuthenticatedMessageV0.sequence = Uint64.decode(stream);
      decodedAuthenticatedMessageV0.message = StellarMessage.decode(stream);
      decodedAuthenticatedMessageV0.mac = HmacSha256Mac.decode(stream);
      return decodedAuthenticatedMessageV0;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.sequence, this.message, this.mac);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof AuthenticatedMessageV0)) {
        return false;
      }

      AuthenticatedMessageV0 other = (AuthenticatedMessageV0) object;
      return Objects.equal(this.sequence, other.sequence) && Objects.equal(this.message, other.message) && Objects.equal(this.mac, other.mac);
    }

    public static final class Builder {
      private Uint64 sequence;
      private StellarMessage message;
      private HmacSha256Mac mac;

      public Builder sequence(Uint64 sequence) {
        this.sequence = sequence;
        return this;
      }

      public Builder message(StellarMessage message) {
        this.message = message;
        return this;
      }

      public Builder mac(HmacSha256Mac mac) {
        this.mac = mac;
        return this;
      }

      public AuthenticatedMessageV0 build() {
        AuthenticatedMessageV0 val = new AuthenticatedMessageV0();
        val.setSequence(sequence);
        val.setMessage(message);
        val.setMac(mac);
        return val;
      }
    }

  }
}
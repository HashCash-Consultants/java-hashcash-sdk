// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union TransactionEnvelope switch (EnvelopeType type)
//  {
//  case ENVELOPE_TYPE_TX_V0:
//      TransactionV0Envelope v0;
//  case ENVELOPE_TYPE_TX:
//      TransactionV1Envelope v1;
//  case ENVELOPE_TYPE_TX_FEE_BUMP:
//      FeeBumpTransactionEnvelope feeBump;
//  };

//  ===========================================================================
public class TransactionEnvelope implements XdrElement {
  public TransactionEnvelope () {}
  EnvelopeType type;
  public EnvelopeType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(EnvelopeType value) {
    this.type = value;
  }
  private TransactionV0Envelope v0;
  public TransactionV0Envelope getV0() {
    return this.v0;
  }
  public void setV0(TransactionV0Envelope value) {
    this.v0 = value;
  }
  private TransactionV1Envelope v1;
  public TransactionV1Envelope getV1() {
    return this.v1;
  }
  public void setV1(TransactionV1Envelope value) {
    this.v1 = value;
  }
  private FeeBumpTransactionEnvelope feeBump;
  public FeeBumpTransactionEnvelope getFeeBump() {
    return this.feeBump;
  }
  public void setFeeBump(FeeBumpTransactionEnvelope value) {
    this.feeBump = value;
  }

  public static final class Builder {
    private EnvelopeType discriminant;
    private TransactionV0Envelope v0;
    private TransactionV1Envelope v1;
    private FeeBumpTransactionEnvelope feeBump;

    public Builder discriminant(EnvelopeType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder v0(TransactionV0Envelope v0) {
      this.v0 = v0;
      return this;
    }

    public Builder v1(TransactionV1Envelope v1) {
      this.v1 = v1;
      return this;
    }

    public Builder feeBump(FeeBumpTransactionEnvelope feeBump) {
      this.feeBump = feeBump;
      return this;
    }

    public TransactionEnvelope build() {
      TransactionEnvelope val = new TransactionEnvelope();
      val.setDiscriminant(discriminant);
      val.setV0(v0);
      val.setV1(v1);
      val.setFeeBump(feeBump);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, TransactionEnvelope encodedTransactionEnvelope) throws IOException {
  //Xdrgen::AST::Identifier
  //EnvelopeType
  stream.writeInt(encodedTransactionEnvelope.getDiscriminant().getValue());
  switch (encodedTransactionEnvelope.getDiscriminant()) {
  case ENVELOPE_TYPE_TX_V0:
  TransactionV0Envelope.encode(stream, encodedTransactionEnvelope.v0);
  break;
  case ENVELOPE_TYPE_TX:
  TransactionV1Envelope.encode(stream, encodedTransactionEnvelope.v1);
  break;
  case ENVELOPE_TYPE_TX_FEE_BUMP:
  FeeBumpTransactionEnvelope.encode(stream, encodedTransactionEnvelope.feeBump);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static TransactionEnvelope decode(XdrDataInputStream stream) throws IOException {
  TransactionEnvelope decodedTransactionEnvelope = new TransactionEnvelope();
  EnvelopeType discriminant = EnvelopeType.decode(stream);
  decodedTransactionEnvelope.setDiscriminant(discriminant);
  switch (decodedTransactionEnvelope.getDiscriminant()) {
  case ENVELOPE_TYPE_TX_V0:
  decodedTransactionEnvelope.v0 = TransactionV0Envelope.decode(stream);
  break;
  case ENVELOPE_TYPE_TX:
  decodedTransactionEnvelope.v1 = TransactionV1Envelope.decode(stream);
  break;
  case ENVELOPE_TYPE_TX_FEE_BUMP:
  decodedTransactionEnvelope.feeBump = FeeBumpTransactionEnvelope.decode(stream);
  break;
  }
    return decodedTransactionEnvelope;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.v0, this.v1, this.feeBump, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TransactionEnvelope)) {
      return false;
    }

    TransactionEnvelope other = (TransactionEnvelope) object;
    return Objects.equal(this.v0, other.v0) && Objects.equal(this.v1, other.v1) && Objects.equal(this.feeBump, other.feeBump) && Objects.equal(this.type, other.type);
  }
}

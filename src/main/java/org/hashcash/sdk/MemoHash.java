package org.hashcash.sdk;

import org.hashcash.sdk.xdr.MemoType;

/**
 * Represents MEMO_HASH.
 */
public class MemoHash extends MemoHashAbstract {
  public MemoHash(byte[] bytes) {
    super(bytes);
  }

  public MemoHash(String hexString) {
    super(hexString);
  }

  @Override
  org.hashcash.sdk.xdr.Memo toXdr() {
	  org.hashcash.sdk.xdr.Memo memo = new org.hashcash.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_HASH);

    org.hashcash.sdk.xdr.Hash hash = new org.hashcash.sdk.xdr.Hash();
    hash.setHash(bytes);

    memo.setHash(hash);
    return memo;
  }
}

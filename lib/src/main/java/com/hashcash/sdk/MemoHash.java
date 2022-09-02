package com.hashcash.sdk;

import com.hashcash.sdk.xdr.MemoType;

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
  com.hashcash.sdk.xdr.Memo toXdr() {
    com.hashcash.sdk.xdr.Memo memo = new com.hashcash.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_HASH);

    com.hashcash.sdk.xdr.Hash hash = new com.hashcash.sdk.xdr.Hash();
    hash.setHash(bytes);

    memo.setHash(hash);
    return memo;
  }
}

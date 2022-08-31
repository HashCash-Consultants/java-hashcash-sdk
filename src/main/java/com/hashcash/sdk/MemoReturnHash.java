package com.hashcash.sdk;

import com.hashcash.sdk.xdr.Memo;
import com.hashcash.sdk.xdr.MemoType;

/**
 * Represents MEMO_RETURN.
 */
public class MemoReturnHash extends MemoHashAbstract {
  public MemoReturnHash(byte[] bytes) {
    super(bytes);
  }

  public MemoReturnHash(String hexString) {
    super(hexString);
  }

  @Override
  Memo toXdr() {
    com.hashcash.sdk.xdr.Memo memo = new com.hashcash.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_RETURN);

    com.hashcash.sdk.xdr.Hash hash = new com.hashcash.sdk.xdr.Hash();
    hash.setHash(bytes);

    memo.setRetHash(hash);
    return memo;
  }
}

package org.hashcash.sdk;

import org.hashcash.sdk.xdr.Memo;
import org.hashcash.sdk.xdr.MemoType;

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
	  org.hashcash.sdk.xdr.Memo memo = new org.hashcash.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_RETURN);

    org.hashcash.sdk.xdr.Hash hash = new org.hashcash.sdk.xdr.Hash();
    hash.setHash(bytes);

    memo.setRetHash(hash);
    return memo;
  }
}

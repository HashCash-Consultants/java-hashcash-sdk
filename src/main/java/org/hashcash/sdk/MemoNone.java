package org.hashcash.sdk;

import org.hashcash.sdk.xdr.MemoType;

/**
 * Represents MEMO_NONE.
 */
public class MemoNone extends Memo {
  @Override
  org.hashcash.sdk.xdr.Memo toXdr() {
	  org.hashcash.sdk.xdr.Memo memo = new org.hashcash.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_NONE);
    return memo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return true;
  }
}

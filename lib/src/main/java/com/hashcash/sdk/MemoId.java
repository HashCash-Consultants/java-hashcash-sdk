package com.hashcash.sdk;

import com.google.common.primitives.UnsignedLongs;
import com.google.common.base.Objects;
import com.hashcash.sdk.xdr.MemoType;
import com.hashcash.sdk.xdr.Uint64;


/**
 * Represents MEMO_ID.
 */
public class MemoId extends Memo {
  private long id;

  public MemoId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  @Override
  com.hashcash.sdk.xdr.Memo toXdr() {
    com.hashcash.sdk.xdr.Memo memo = new com.hashcash.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_ID);
    Uint64 idXdr = new Uint64();
    idXdr.setUint64(id);
    memo.setId(idXdr);
    return memo;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.id);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MemoId memoId = (MemoId) o;
    return id == memoId.id;
  }

  @Override
  public String toString() {
    return UnsignedLongs.toString(this.id);
  }
}

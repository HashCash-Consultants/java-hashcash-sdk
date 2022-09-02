package org.hashcash.sdk;

import com.google.common.base.Objects;

import java.nio.charset.Charset;

import org.hashcash.sdk.xdr.MemoType;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents MEMO_TEXT.
 */
public class MemoText extends Memo {
  private String text;

  public MemoText(String text) {
    this.text = checkNotNull(text, "text cannot be null");

    int length = text.getBytes((Charset.forName("UTF-8"))).length;
    if (length > 28) {
      throw new MemoTooLongException("text must be <= 28 bytes. length=" + String.valueOf(length));
    }
  }

  public String getText() {
    return text;
  }

  @Override
  org.hashcash.sdk.xdr.Memo toXdr() {
    org.hashcash.sdk.xdr.Memo memo = new org.hashcash.sdk.xdr.Memo();
    memo.setDiscriminant(MemoType.MEMO_TEXT);
    memo.setText(text);
    return memo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MemoText memoText = (MemoText) o;
    return Objects.equal(text, memoText.text);
  }
}

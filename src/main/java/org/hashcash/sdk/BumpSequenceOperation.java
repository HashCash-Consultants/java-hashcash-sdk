package org.hashcash.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

import org.hashcash.sdk.xdr.BumpSequenceOp;
import org.hashcash.sdk.xdr.Int64;
import org.hashcash.sdk.xdr.OperationType;
import org.hashcash.sdk.xdr.SequenceNumber;

public class BumpSequenceOperation extends Operation  {
    private final long bumpTo;

    private BumpSequenceOperation(long bumpTo) {
        this.bumpTo = bumpTo;
    }

    public long getBumpTo() {
        return bumpTo;
    }

    @Override
    org.hashcash.sdk.xdr.Operation.OperationBody toOperationBody() {
        BumpSequenceOp op = new BumpSequenceOp();
        Int64 bumpTo = new Int64();
        bumpTo.setInt64(this.bumpTo);
        SequenceNumber sequenceNumber = new SequenceNumber();
        sequenceNumber.setSequenceNumber(bumpTo);
        op.setBumpTo(sequenceNumber);

        org.hashcash.sdk.xdr.Operation.OperationBody body = new org.hashcash.sdk.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.BUMP_SEQUENCE);
        body.setBumpSequenceOp(op);

        return body;
    }

    public static class Builder {
        private final long bumpTo;

        private KeyPair mSourceAccount;

        /**
         * Construct a new BumpSequence builder from a BumpSequence XDR.
         * @param op {@link BumpSequenceOp}
         */
        Builder(BumpSequenceOp op) {
            bumpTo = op.getBumpTo().getSequenceNumber().getInt64();
        }

        /**
         * Creates a new BumpSequence builder.
         * @param bumpTo Sequence number to bump to
         */
        public Builder(long bumpTo) {
            this.bumpTo = bumpTo;
        }

        /**
         * Sets the source account for this operation.
         * @param sourceAccount The operation's source account.
         * @return Builder object so you can chain methods.
         */
        public BumpSequenceOperation.Builder setSourceAccount(KeyPair sourceAccount) {
            mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
            return this;
        }

        /**
         * Builds an operation
         */
        public BumpSequenceOperation build() {
            BumpSequenceOperation operation = new BumpSequenceOperation(bumpTo);
            if (mSourceAccount != null) {
                operation.setSourceAccount(mSourceAccount);
            }
            return operation;
        }
    }
}
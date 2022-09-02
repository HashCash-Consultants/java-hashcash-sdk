package com.hashcash.sdk;

import com.google.common.base.Objects;
import com.hashcash.sdk.xdr.OperationType;

/**
 * Represents <a href="https://developers.stellar.org/docs/start/list-of-operations/#inflation" target="_blank">Inflation</a> operation.
 * @see <a href="https://developers.stellar.org/docs/start/list-of-operations/" target="_blank">List of Operations</a>
 */
public class InflationOperation extends Operation {
    @Override
    com.hashcash.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
        com.hashcash.sdk.xdr.Operation.OperationBody body = new com.hashcash.sdk.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.INFLATION);
        return body;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getSourceAccount());
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof InflationOperation)) {
            return false;
        }

        InflationOperation other = (InflationOperation) object;
        return Objects.equal(this.getSourceAccount(), other.getSourceAccount());
    }
}

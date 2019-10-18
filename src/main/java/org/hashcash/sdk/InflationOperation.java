package org.hashcash.sdk;

import org.hashcash.sdk.xdr.OperationType;

public class InflationOperation extends Operation {
    @Override
    org.hashcash.sdk.xdr.Operation.OperationBody toOperationBody() {
    	org.hashcash.sdk.xdr.Operation.OperationBody body = new org.hashcash.sdk.xdr.Operation.OperationBody();
        body.setDiscriminant(OperationType.INFLATION);
        return body;
    }
}

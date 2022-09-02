package org.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;


public class BumpSequenceOperationResponse extends OperationResponse {
    @SerializedName("bump_to")
    protected final Long bumpTo;

    public BumpSequenceOperationResponse(Long bumpTo) {
        this.bumpTo = bumpTo;
    }

    public Long getBumpTo() {
        return bumpTo;
    }
}

package com.hashcash.sdk.responses.operations;

import com.google.gson.annotations.SerializedName;

/**
 * Represents BumpSequence operation response.
 * @see <a href="https://developers.stellar.org/api/resources/operations/" target="_blank">Operation documentation</a>
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
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

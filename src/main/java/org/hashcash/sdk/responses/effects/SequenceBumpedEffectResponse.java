package org.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;


public class SequenceBumpedEffectResponse extends EffectResponse {
    @SerializedName("new_seq")
    protected final Long newSequence;

    public SequenceBumpedEffectResponse(Long newSequence) {
        this.newSequence = newSequence;
    }

    public Long getNewSequence() {
        return newSequence;
    }
}

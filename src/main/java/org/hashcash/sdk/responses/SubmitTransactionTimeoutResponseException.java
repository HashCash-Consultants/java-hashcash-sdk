package org.hashcash.sdk.responses;

public class SubmitTransactionTimeoutResponseException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Timeout. Please resubmit your transaction to receive submission status. ";
    }
}

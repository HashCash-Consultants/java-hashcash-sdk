package org.hashcash.sdk.responses;

public class SubmitTransactionUnknownResponseException extends RuntimeException {
    private int code;
    private String body;

    public SubmitTransactionUnknownResponseException(int code, String body) {
        this.code = code;
        this.body = body;
    }

    @Override
    public String getMessage() {
        return "Unknown response from aurora";
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }
}

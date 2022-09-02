package org.hashcash.sdk.responses;

import com.google.common.io.BaseEncoding;
import com.google.gson.annotations.SerializedName;

import org.hashcash.sdk.Server;
import org.hashcash.sdk.xdr.OperationType;
import org.hashcash.sdk.xdr.TransactionResult;
import org.hashcash.sdk.xdr.XdrDataInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class SubmitTransactionResponse extends Response {
    @SerializedName("hash")
    private final String hash;
    @SerializedName("ledger")
    private final Long ledger;
    @SerializedName("envelope_xdr")
    private final String envelopeXdr;
    @SerializedName("result_xdr")
    private final String resultXdr;
    @SerializedName("extras")
    private final Extras extras;

    SubmitTransactionResponse(Extras extras, Long ledger, String hash, String envelopeXdr, String resultXdr) {
        this.extras = extras;
        this.ledger = ledger;
        this.hash = hash;
        this.envelopeXdr = envelopeXdr;
        this.resultXdr = resultXdr;
    }

    public boolean isSuccess() {
        return ledger != null;
    }

    public String getHash() {
        return hash;
    }

    public Long getLedger() {
        return ledger;
    }

    public String getEnvelopeXdr() {
        if (this.isSuccess()) {
            return this.envelopeXdr;
        } else {
            if (this.getExtras() != null) {
                return this.getExtras().getEnvelopeXdr();
            }
            return null;
        }
    }

    public String getResultXdr() {
        if (this.isSuccess()) {
            return this.resultXdr;
        } else {
            if (this.getExtras() != null) {
                return this.getExtras().getResultXdr();
            }
            return null;
        }
    }

    
    public Long getOfferIdFromResult(int position) {
        if (!this.isSuccess()) {
            return null;
        }

        BaseEncoding base64Encoding = BaseEncoding.base64();
        byte[] bytes = base64Encoding.decode(this.getResultXdr());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        XdrDataInputStream xdrInputStream = new XdrDataInputStream(inputStream);
        TransactionResult result;

        try {
            result = TransactionResult.decode(xdrInputStream);
        } catch (IOException e) {
            return null;
        }

        if (result.getResult().getResults()[position] == null) {
            return null;
        }

        if (result.getResult().getResults()[position].getTr().getDiscriminant() != OperationType.MANAGE_OFFER) {
            return null;
        }

        if (result.getResult().getResults()[0].getTr().getManageOfferResult().getSuccess().getOffer().getOffer() == null) {
            return null;
        }

        return result.getResult().getResults()[0].getTr().getManageOfferResult().getSuccess().getOffer().getOffer().getOfferID().getUint64();
    }

    
    public Extras getExtras() {
        return extras;
    }

   
    public static class Extras {
        @SerializedName("envelope_xdr")
        private final String envelopeXdr;
        @SerializedName("result_xdr")
        private final String resultXdr;
        @SerializedName("result_codes")
        private final ResultCodes resultCodes;

        Extras(String envelopeXdr, String resultXdr, ResultCodes resultCodes) {
            this.envelopeXdr = envelopeXdr;
            this.resultXdr = resultXdr;
            this.resultCodes = resultCodes;
        }

      
        public String getEnvelopeXdr() {
            return envelopeXdr;
        }

       
        public String getResultXdr() {
            return resultXdr;
        }

       
        public ResultCodes getResultCodes() {
            return resultCodes;
        }

       
        public static class ResultCodes {
            @SerializedName("transaction")
            private final String transactionResultCode;
            @SerializedName("operations")
            private final ArrayList<String> operationsResultCodes;

            public ResultCodes(String transactionResultCode, ArrayList<String> operationsResultCodes) {
                this.transactionResultCode = transactionResultCode;
                this.operationsResultCodes = operationsResultCodes;
            }

            public String getTransactionResultCode() {
                return transactionResultCode;
            }

            public ArrayList<String> getOperationsResultCodes() {
                return operationsResultCodes;
            }
        }
    }
}

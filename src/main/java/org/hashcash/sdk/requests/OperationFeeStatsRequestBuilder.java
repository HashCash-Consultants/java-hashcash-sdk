package org.hashcash.sdk.requests;

import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import org.hashcash.sdk.responses.OperationFeeStatsResponse;

public class OperationFeeStatsRequestBuilder extends RequestBuilder {
    public OperationFeeStatsRequestBuilder(OkHttpClient httpClient, HttpUrl serverURI) {
        super(httpClient, serverURI, "operation_fee_stats");
    }

    /**
     * Requests <code>GET /operation_fee_stats</code>
     * @throws IOException
     * @throws TooManyRequestsException
     */
    public OperationFeeStatsResponse execute() throws IOException, TooManyRequestsException {
        TypeToken type = new TypeToken<OperationFeeStatsResponse>() {};
        ResponseHandler<OperationFeeStatsResponse> responseHandler = new ResponseHandler<OperationFeeStatsResponse>(type);

        Request request = new Request.Builder().get().url(this.buildUri()).build();
        Response response = httpClient.newCall(request).execute();

        return responseHandler.handleResponse(response);
    }
}

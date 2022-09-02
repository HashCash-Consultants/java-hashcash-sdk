package org.hashcash.sdk.requests;

import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import org.hashcash.sdk.KeyPair;
import org.hashcash.sdk.responses.Page;
import org.hashcash.sdk.responses.effects.EffectResponse;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Builds requests connected to effects.
 */
public class EffectsRequestBuilder extends RequestBuilder {
  public EffectsRequestBuilder(OkHttpClient httpClient, HttpUrl serverURI) {
    super(httpClient, serverURI, "effects");
  }

  /**
   * Builds request to <code>GET /accounts/{account}/effects</code>
   * @param account Account for which to get effects
   */
  public EffectsRequestBuilder forAccount(KeyPair account) {
    account = checkNotNull(account, "account cannot be null");
    this.setSegments("accounts", account.getAccountId(), "effects");
    return this;
  }

  /**
   * Builds request to <code>GET /ledgers/{ledgerSeq}/effects</code>
   * @param ledgerSeq Ledger for which to get effects
   */
  public EffectsRequestBuilder forLedger(long ledgerSeq) {
    this.setSegments("ledgers", String.valueOf(ledgerSeq), "effects");
    return this;
  }

  /**
   * Builds request to <code>GET /transactions/{transactionId}/effects</code>
   * @param transactionId Transaction ID for which to get effects
   */
  public EffectsRequestBuilder forTransaction(String transactionId) {
    transactionId = checkNotNull(transactionId, "transactionId cannot be null");
    this.setSegments("transactions", transactionId, "effects");
    return this;
  }

  /**
   * Builds request to <code>GET /operation/{operationId}/effects</code>
   * @param operationId Operation ID for which to get effects
   */
  public EffectsRequestBuilder forOperation(long operationId) {
    this.setSegments("operations", String.valueOf(operationId), "effects");
    return this;
  }

  /**
   * Requests specific <code>uri</code> and returns {@link Page} of {@link EffectResponse}.
   * This method is helpful for getting the next set of results.
   * @return {@link Page} of {@link EffectResponse}
   * @throws TooManyRequestsException when too many requests were sent to the Aurora server.
   * @throws IOException
   */
  public static Page<EffectResponse> execute(OkHttpClient httpClient, HttpUrl uri) throws IOException, TooManyRequestsException {
    TypeToken type = new TypeToken<Page<EffectResponse>>() {};
    ResponseHandler<Page<EffectResponse>> responseHandler = new ResponseHandler<Page<EffectResponse>>(type);

    Request request = new Request.Builder().get().url(uri).build();
    Response response = httpClient.newCall(request).execute();

    return responseHandler.handleResponse(response);
  }

  /**
   * Allows to stream SSE events from Aurora.
   * Certain endpoints in Aurora can be called in streaming mode using Server-Sent Events.
   * This mode will keep the connection to Aurora open and Aurora will continue to return
   * responses as ledgers close.
   * @see <a href="http://www.w3.org/TR/eventsource/" target="_blank">Server-Sent Events</a>
   * @param listener {@link EventListener} implementation with {@link EffectResponse} type
   * @return EventSource object, so you can <code>close()</code> connection when not needed anymore
   */
  public SSEStream<EffectResponse> stream(final EventListener<EffectResponse> listener) {
    return SSEStream.create(httpClient,this,EffectResponse.class,listener);
  }

  /**
   * Build and execute request.
   * @return {@link Page} of {@link EffectResponse}
   * @throws TooManyRequestsException when too many requests were sent to the Aurora server.
   * @throws IOException
   */
  public Page<EffectResponse> execute() throws IOException, TooManyRequestsException {
    return this.execute(this.httpClient, this.buildUri());
  }

  @Override
  public EffectsRequestBuilder cursor(String token) {
    super.cursor(token);
    return this;
  }

  @Override
  public EffectsRequestBuilder limit(int number) {
    super.limit(number);
    return this;
  }

  @Override
  public EffectsRequestBuilder order(Order direction) {
    super.order(direction);
    return this;
  }
}

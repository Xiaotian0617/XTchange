package org.knowm.xchange.bittrex;

import org.knowm.xchange.bittrex.dto.account.*;
import org.knowm.xchange.bittrex.dto.trade.BittrexCancelOrderResponse;
import org.knowm.xchange.bittrex.dto.trade.BittrexOpenOrdersResponse;
import org.knowm.xchange.bittrex.dto.trade.BittrexTradeHistoryResponse;
import org.knowm.xchange.bittrex.dto.trade.BittrexTradeResponse;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("v1.1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface BittrexAuthenticated extends Bittrex {

  @GET
  @Path("account/getdepositaddress")
  BittrexDepositAddressResponse getdepositaddress(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("currency") String currency) throws IOException;

  @GET
  @Path("account/getbalances")
  BittrexBalancesResponse getBalances(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce) throws IOException;

  @GET
  @Path("/account/getbalance")
  BittrexBalanceResponse getBalance(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("currency") String currency) throws IOException;

  @GET
  @Path("market/buylimit")
  BittrexTradeResponse buylimit(@QueryParam("apikey") String apikey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("market") String market, @QueryParam("quantity") String quantity,
      @QueryParam("rate") String rate) throws IOException;

  @GET
  @Path("market/selllimit")
  BittrexTradeResponse selllimit(@QueryParam("apikey") String apikey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("market") String market, @QueryParam("quantity") String quantity,
      @QueryParam("rate") String rate) throws IOException;

  @GET
  @Path("market/buymarket")
  BittrexTradeResponse buymarket(@QueryParam("apikey") String apikey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("market") String market,
      @QueryParam("quantity") String quantity) throws IOException;

  @GET
  @Path("market/sellmarket")
  BittrexTradeResponse sellmarket(@QueryParam("apikey") String apikey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("market") String market,
      @QueryParam("quantity") String quantity) throws IOException;

  @GET
  @Path("market/cancel")
  BittrexCancelOrderResponse cancel(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("uuid") String uuid) throws IOException;

  @GET
  @Path("market/getopenorders")
  BittrexOpenOrdersResponse openorders(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("market") String market) throws IOException;

  @GET
  @Path("/account/getorder")
  BittrexOrderResponse getOrder(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("uuid") String uuid) throws IOException;

  @GET
  @Path("account/getorderhistory")
  BittrexTradeHistoryResponse getorderhistory(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("market") String market) throws IOException;

  @GET
  @Path("account/withdraw")
  BittrexWithdrawResponse withdraw(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("currency") String currency, @QueryParam("quantity") String quantity,
      @QueryParam("address") String address, @QueryParam("paymentid") String paymentId) throws IOException;

  @GET
  @Path("account/getwithdrawalhistory")
  BittrexWithdrawalsHistoryResponse getwithdrawalhistory(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("currency") String currency) throws IOException;

  @GET
  @Path("account/getdeposithistory")
  BittrexDepositsHistoryResponse getdeposithistory(@QueryParam("apikey") String apiKey, @HeaderParam("apisign") ParamsDigest signature,
      @QueryParam("nonce") SynchronizedValueFactory<Long> nonce, @QueryParam("currency") String currency) throws IOException;
}

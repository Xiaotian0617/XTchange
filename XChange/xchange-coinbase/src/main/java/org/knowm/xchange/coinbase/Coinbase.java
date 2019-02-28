package org.knowm.xchange.coinbase;

import org.knowm.xchange.coinbase.dto.CoinbaseException;
import org.knowm.xchange.coinbase.dto.account.CoinbaseToken;
import org.knowm.xchange.coinbase.dto.account.CoinbaseUser;
import org.knowm.xchange.coinbase.dto.marketdata.CoinbaseCurrency;
import org.knowm.xchange.coinbase.dto.marketdata.CoinbaseMoney;
import org.knowm.xchange.coinbase.dto.marketdata.CoinbasePrice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author jamespedwards42
 */
@Path("api/v1")
@Produces(MediaType.APPLICATION_JSON)
public interface Coinbase {

  @GET
  @Path("currencies")
  List<CoinbaseCurrency> getCurrencies() throws IOException, CoinbaseException;

  @GET
  @Path("currencies/exchange_rates")
  Map<String, BigDecimal> getCurrencyExchangeRates() throws IOException, CoinbaseException;

  @GET
  @Path("prices/buy")
  CoinbasePrice getBuyPrice(@QueryParam("qty") BigDecimal quantity, @QueryParam("currency") String currency) throws IOException, CoinbaseException;

  @GET
  @Path("prices/sell")
  CoinbasePrice getSellPrice(@QueryParam("qty") BigDecimal quantity, @QueryParam("currency") String currency) throws IOException, CoinbaseException;

  @GET
  @Path("prices/spot_rate")
  CoinbaseMoney getSpotRate(@QueryParam("currency") String currency) throws IOException, CoinbaseException;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Path("prices/historical")
  String getHistoricalSpotRates(@QueryParam("page") Integer page) throws IOException, CoinbaseException;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("users")
  CoinbaseUser createUser(CoinbaseUser user) throws IOException, CoinbaseException;

  @POST
  @Path("tokens")
  CoinbaseToken createToken() throws IOException, CoinbaseException;

}

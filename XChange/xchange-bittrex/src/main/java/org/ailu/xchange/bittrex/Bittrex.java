package org.knowm.xchange.bittrex;

import org.knowm.xchange.bittrex.dto.marketdata.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("v1.1")
@Produces(MediaType.APPLICATION_JSON)
public interface Bittrex {

  @GET
  @Path("/public/getticker")
  BittrexTickerResponse getTicker(@QueryParam("market") String market) throws IOException;

  @GET
  @Path("public/getmarketsummary/")
  BittrexMarketSummaryResponse getMarketSummary(@QueryParam("market") String market) throws IOException;

  @GET
  @Path("public/getmarketsummaries/")
  BittrexMarketSummariesResponse getMarketSummaries() throws IOException;

  @GET
  @Path("public/getorderbook/")
  BittrexDepthResponse getBook(@QueryParam("market") String market, @QueryParam("type") String type,
      @QueryParam("depth") int depth) throws IOException;

  @GET
  @Path("public/getmarkethistory/")
  BittrexTradesResponse getTrades(@QueryParam("market") String market, @QueryParam("count") int count) throws IOException;

  @GET
  @Path("public/getmarkets")
  BittrexSymbolsResponse getSymbols() throws IOException;

  @GET
  @Path("public/getcurrencies")
  BittrexCurrenciesResponse getCurrencies() throws IOException;

}

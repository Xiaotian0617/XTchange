package org.knowm.xchange.gateio;

import org.knowm.xchange.gateio.dto.marketdata.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Map;

@Path("api2/1")
@Produces(MediaType.APPLICATION_JSON)
public interface Gateio {

  @GET
  @Path("marketinfo")
  GateioMarketInfoWrapper getMarketInfo() throws IOException;

  @GET
  @Path("pairs")
  GateioCurrencyPairs getPairs() throws IOException;

  @GET
  @Path("orderBooks")
  Map<String, GateioDepth> getDepths() throws IOException;

  @GET
  @Path("tickers")
  Map<String, GateioTicker> getTickers() throws IOException;

  @GET
  @Path("ticker/{ident}_{currency}")
  GateioTicker getTicker(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency) throws IOException;

  @GET
  @Path("orderBook/{ident}_{currency}")
  GateioDepth getFullDepth(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency) throws IOException;

  @GET
  @Path("trade/{ident}_{currency}")
  GateioTradeHistory getTradeHistory(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency) throws IOException;

  @GET
  @Path("trade/{ident}_{currency}/{tradeId}")
  GateioTradeHistory getTradeHistorySince(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency,
                                          @PathParam("tradeId") String tradeId) throws IOException;
}

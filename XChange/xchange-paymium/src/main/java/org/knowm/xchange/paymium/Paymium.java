package org.knowm.xchange.paymium;

import org.knowm.xchange.paymium.dto.marketdata.PaymiumMarketDepth;
import org.knowm.xchange.paymium.dto.marketdata.PaymiumTicker;
import org.knowm.xchange.paymium.dto.marketdata.PaymiumTrade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface Paymium {

  /**
   * @return Paymium ticker
   * @throws IOException
   */
  @GET
  @Path("ticker/")
  PaymiumTicker getPaymiumTicker() throws IOException;

  @GET
  @Path("depth/")
  PaymiumMarketDepth getOrderBook() throws IOException;

  @GET
  @Path("trades/")
  PaymiumTrade[] getTrades() throws IOException;
}

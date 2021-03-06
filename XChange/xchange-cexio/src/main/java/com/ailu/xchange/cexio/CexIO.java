package org.knowm.xchange.cexio;

import org.knowm.xchange.cexio.dto.marketdata.CexIODepth;
import org.knowm.xchange.cexio.dto.marketdata.CexIOTicker;
import org.knowm.xchange.cexio.dto.marketdata.CexIOTrade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * @author brox
 */
@Path("api")
@Produces(MediaType.APPLICATION_JSON)
public interface CexIO {

  @GET
  @Path("ticker/{ident}/{currency}")
  CexIOTicker getTicker(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency) throws IOException;

  @GET
  @Path("order_book/{ident}/{currency}")
  CexIODepth getDepth(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency) throws IOException;

  @GET
  @Path("trade_history/{ident}/{currency}/")
  CexIOTrade[] getTrades(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency) throws IOException;

  @POST
  @Path("trade_history/{ident}/{currency}/")
  CexIOTrade[] getTradesSince(@PathParam("ident") String tradeableIdentifier, @PathParam("currency") String currency,
      @DefaultValue("1") @FormParam("since") long since) throws IOException;

}

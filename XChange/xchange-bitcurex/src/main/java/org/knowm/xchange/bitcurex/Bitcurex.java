package org.knowm.xchange.bitcurex;

import org.knowm.xchange.bitcurex.dto.marketdata.BitcurexDepth;
import org.knowm.xchange.bitcurex.dto.marketdata.BitcurexTicker;
import org.knowm.xchange.bitcurex.dto.marketdata.BitcurexTrade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("api")
@Produces(MediaType.APPLICATION_JSON)
public interface Bitcurex {

  @GET
  @Path("{currency}/ticker.json")
  BitcurexTicker getTicker(@PathParam("currency") String currency) throws IOException;

  @GET
  @Path("{currency}/orderbook.json")
  BitcurexDepth getFullDepth(@PathParam("currency") String currency) throws IOException;

  @GET
  @Path("{currency}/trades.json")
  BitcurexTrade[] getTrades(@PathParam("currency") String currency) throws IOException;

}

package org.knowm.xchange.truefx;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.truefx.dto.marketdata.TrueFxTicker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;

@Path("")
public interface TrueFxPublic {
  @GET
  @Path("rates/connect.html?f=csv&c={pair}")
  TrueFxTicker getTicker(@PathParam("pair") CurrencyPair pair) throws IOException;
}

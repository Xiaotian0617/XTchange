package org.knowm.xchange.koineks;

import org.knowm.xchange.koineks.dto.marketdata.KoineksTicker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by semihunaldi on 05/12/2017
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface Koineks {
  @GET
  @Path("ticker")
  KoineksTicker getTicker() throws IOException;
}

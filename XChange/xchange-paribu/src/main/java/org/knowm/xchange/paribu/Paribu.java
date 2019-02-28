package org.knowm.xchange.paribu;

import org.knowm.xchange.paribu.dto.marketdata.ParibuTicker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * @author semihunaldi
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface Paribu {

  @GET
  @Path("ticker")
  ParibuTicker getTicker() throws IOException;

}
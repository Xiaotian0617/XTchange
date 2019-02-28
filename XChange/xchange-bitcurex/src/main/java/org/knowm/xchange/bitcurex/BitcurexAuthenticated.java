package org.knowm.xchange.bitcurex;

import org.knowm.xchange.bitcurex.dto.marketdata.BitcurexFunds;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("api/0")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public interface BitcurexAuthenticated {

  @POST
  @Path("getFunds")
  BitcurexFunds getFunds(@HeaderParam("Rest-Key") String apiKey, @HeaderParam("Rest-Sign") ParamsDigest signer,
                         @FormParam("nonce") SynchronizedValueFactory<Long> nonce) throws IOException;
}

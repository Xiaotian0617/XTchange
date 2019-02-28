package org.knowm.xchange.lakebtc;

import org.knowm.xchange.lakebtc.dto.LakeBTCRequest;
import org.knowm.xchange.lakebtc.dto.account.LakeBTCAccountInfoResponse;
import org.knowm.xchange.lakebtc.dto.trade.*;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * User: cristian.lucaci Date: 10/3/2014 Time: 5:04 PM
 */

@Path("api_v1")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public interface LakeBTCAuthenticated {

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  LakeBTCAccountInfoResponse getAccountInfo(@HeaderParam("Authorization") ParamsDigest authorization,
      @HeaderParam("Json-Rpc-Tonce") SynchronizedValueFactory<Long> nonce, LakeBTCRequest getAccountInfoRequest) throws IOException;

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  LakeBTCOrderResponse placeBuyOrder(@HeaderParam("Authorization") ParamsDigest authorization,
      @HeaderParam("Json-Rpc-Tonce") SynchronizedValueFactory<Long> nonce, LakeBTCBuyOrderRequest orderRequest) throws IOException;

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  LakeBTCOrderResponse placeSellOrder(@HeaderParam("Authorization") ParamsDigest authorization,
      @HeaderParam("Json-Rpc-Tonce") SynchronizedValueFactory<Long> nonce, LakeBTCSellOrderRequest orderRequest) throws IOException;

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  LakeBTCCancelResponse cancelOrder(@HeaderParam("Authorization") ParamsDigest authorization,
      @HeaderParam("Json-Rpc-Tonce") SynchronizedValueFactory<Long> nonce, LakeBTCCancelRequest orderRequest) throws IOException;

  @POST
  @Path("/")
  LakeBTCTradeResponse[] pastTrades(@HeaderParam("Authorization") ParamsDigest authorization,
      @HeaderParam("Json-Rpc-Tonce") SynchronizedValueFactory<Long> nonce, LakeBTCTradesRequest pastTradesRequest) throws IOException;

  @POST
  @Path("/")
  LakeBTCOrdersResponse[] getOrders(@HeaderParam("Authorization") ParamsDigest authorization,
      @HeaderParam("Json-Rpc-Tonce") SynchronizedValueFactory<Long> nonce, LakeBTCOrdersRequest orderRequest) throws IOException;

}

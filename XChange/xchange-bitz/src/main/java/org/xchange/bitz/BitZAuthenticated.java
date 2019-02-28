package org.xchange.bitz;

import org.xchange.bitz.dto.trade.result.BitZOpenOrderResult;
import org.xchange.bitz.dto.trade.result.BitZTradeAddResult;
import org.xchange.bitz.dto.trade.result.BitZTradeCancelResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@Path("api_v1")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public interface BitZAuthenticated {
  
  @POST
  @Path("tradeAdd")
  BitZTradeAddResult addTrade(@FormParam("api_key") String apiKey, @FormParam("timestamp") String timestamp,
                              @FormParam("nonce") String nonce, @FormParam("type") String type, @FormParam("price") BigDecimal price,
                              @FormParam("number") BigDecimal amount, @FormParam("coin") String pair, @FormParam("tradepwd") String tradePwd,
                              @FormParam("sign") String signed);
  
  @POST
  @Path("tradeCancel")
  BitZTradeCancelResult cancelTrade(@FormParam("api_key") String apiKey, @FormParam("timestamp") String timestamp,
                                    @FormParam("nonce") String nonce, @FormParam("id") String id, @FormParam("sign") String signed);
  
  @POST
  @Path("openOrders")
  BitZOpenOrderResult openOrders(@FormParam("api_key") String apiKey, @FormParam("timesamp") String timestamp,
                                 @FormParam("nonce") String nonce, @FormParam("coin") String coin, @FormParam("sign") String signed);
}
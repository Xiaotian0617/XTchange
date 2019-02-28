package org.xchange.bitz;

import org.xchange.bitz.dto.marketdata.result.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("api_v1")
@Produces(MediaType.APPLICATION_JSON)
public interface BitZ {

  @GET
  @Path("tickerall")
  BitZTickerAllResult getTickerAllResult() throws IOException;
  
  @GET
  @Path("ticker?coin={symbol}")
  BitZTickerResult getTickerResult(@PathParam("symbol") String symbol) throws IOException;
  
  @GET
  @Path("depth?coin={symbol}")
  BitZOrdersResult getOrdersResult(@PathParam("symbol") String symbol) throws IOException;
  
  @GET
  @Path("orders?coin={symbol}")
  BitZTradesResult getTradesResult(@PathParam("symbol") String symbol) throws IOException;

  @GET
  @Path("kline?coin={symbol}&type={type}")
  BitZKlineResult getKlineResult(@PathParam("symbol") String symbol, @PathParam("type") String type)  throws IOException;
  
}
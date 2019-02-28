package org.knowm.xchange.kraken;

import org.knowm.xchange.kraken.dto.marketdata.results.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * @author Benedikt Bünz
 */
@Path("0")
@Produces(MediaType.APPLICATION_JSON)
public interface Kraken {

  @GET
  @Path("public/Ticker")
  KrakenTickerResult getTicker(@QueryParam("pair") String currencyPairs);

  @GET
  @Path("public/OHLC")
  KrakenOHLCResult getOHLC(@QueryParam("pair") String currencyPairs, @QueryParam("interval") Integer interval, @QueryParam("since") Long since);

  @GET
  @Path("public/Depth")
  KrakenDepthResult getDepth(@QueryParam("pair") String currencyPair, @QueryParam("count") long count) throws IOException;

  @GET
  @Path("public/Trades")
  KrakenPublicTradesResult getTrades(@QueryParam("pair") String currencyPair) throws IOException;

  @GET
  @Path("public/Trades")
  KrakenPublicTradesResult getTrades(@QueryParam("pair") String currencyPair, @QueryParam("since") Long since) throws IOException;

  @GET
  @Path("public/Spread")
  KrakenSpreadsResult getSpread(@QueryParam("pair") String currencyPair, @QueryParam("since") Long since);

  @GET
  @Path("public/Assets")
  KrakenAssetsResult getAssets(@FormParam("aclass") String assetClass, @FormParam("asset") String assets) throws IOException;

  @GET
  @Path("public/AssetPairs")
  KrakenAssetPairsResult getAssetPairs(@FormParam("pair") String assetPairs) throws IOException;

  @GET
  @Path("public/Time")
  KrakenServerTimeResult getServerTime() throws IOException;
}

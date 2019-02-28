package org.knowm.xchange.bitflyer;

import org.knowm.xchange.bitflyer.dto.BitflyerException;
import org.knowm.xchange.bitflyer.dto.account.*;
import org.knowm.xchange.bitflyer.dto.marketdata.BitflyerOrderbook;
import org.knowm.xchange.bitflyer.dto.marketdata.BitflyerTicker;
import org.knowm.xchange.bitflyer.dto.trade.BitflyerExecution;
import org.knowm.xchange.bitflyer.dto.trade.BitflyerPosition;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
public interface Bitflyer {

  String ACCESS_KEY = "ACCESS-KEY";
  String ACCESS_TIMESTAMP = "ACCESS-TIMESTAMP";
  String ACCESS_SIGN = "ACCESS-SIGN";

  @GET
  @Path("getmarkets")
  List<BitflyerMarket> getMarkets() throws IOException, BitflyerException;

  /**
   * return "BTC_JPY" or "BTC_USD" for U.S. accounts.
   */
  @GET
  @Path("getticker")
  BitflyerTicker getTicker() throws IOException, BitflyerException;

  @GET
  @Path("getticker")
  BitflyerTicker getTicker(@QueryParam("product_code") String productCode) throws IOException, BitflyerException;

  /**
   * return "BTC_JPY" or "BTC_USD" for U.S. accounts.
   */
  @GET
  @Path("getboard")
  BitflyerOrderbook getBoard() throws IOException, BitflyerException;

  @GET
  @Path("getboard")
  BitflyerOrderbook getBoard(@QueryParam("product_code") String productCode) throws IOException, BitflyerException;

  @GET
  @Path("getexecutions")
  List<BitflyerExecution> getExecutions() throws IOException, BitflyerException;

  @GET
  @Path("getexecutions")
  List<BitflyerExecution> getExecutions(@QueryParam("product_code") String productCode) throws IOException, BitflyerException;

  @GET
  @Path("me/getpositions")
  List<BitflyerPosition> getPositions(@HeaderParam(ACCESS_KEY) String apiKey,
                                      @HeaderParam(ACCESS_TIMESTAMP) SynchronizedValueFactory<Long> nonce,
                                      @HeaderParam(ACCESS_SIGN) ParamsDigest paramsDigest,
                                      @QueryParam("product_code") String productCode) throws IOException, BitflyerException;

  @GET
  @Path("me/getcollateral")
  BitflyerMarginStatus getMarginStatus(@HeaderParam(ACCESS_KEY) String apiKey,
                                       @HeaderParam(ACCESS_TIMESTAMP) SynchronizedValueFactory<Long> nonce,
                                       @HeaderParam(ACCESS_SIGN) ParamsDigest paramsDigest) throws IOException, BitflyerException;

  @GET
  @Path("/me/getbalance")
  List<BitflyerBalance> getBalances(@HeaderParam(ACCESS_KEY) String apiKey,
                                    @HeaderParam(ACCESS_TIMESTAMP) SynchronizedValueFactory<Long> nonce,
                                    @HeaderParam(ACCESS_SIGN) ParamsDigest paramsDigest) throws IOException, BitflyerException;

  @GET
  @Path("me/getcollateralaccounts")
  List<BitflyerMarginAccount> getMarginAccounts(@HeaderParam(ACCESS_KEY) String apiKey,
                                                @HeaderParam(ACCESS_TIMESTAMP) SynchronizedValueFactory<Long> nonce,
                                                @HeaderParam(ACCESS_SIGN) ParamsDigest paramsDigest) throws IOException, BitflyerException;

  @GET
  @Path("me/getcollateralhistory")
  List<BitflyerMarginTransaction> getMarginHistory(@HeaderParam(ACCESS_KEY) String apiKey,
                                                   @HeaderParam(ACCESS_TIMESTAMP) SynchronizedValueFactory<Long> nonce,
                                                   @HeaderParam(ACCESS_SIGN) ParamsDigest paramsDigest) throws IOException, BitflyerException;
}

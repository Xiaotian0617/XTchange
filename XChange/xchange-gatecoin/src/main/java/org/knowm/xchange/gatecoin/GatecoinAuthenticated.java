package org.knowm.xchange.gatecoin;

import org.knowm.xchange.gatecoin.dto.GatecoinException;
import org.knowm.xchange.gatecoin.dto.account.Results.GatecoinBalanceResult;
import org.knowm.xchange.gatecoin.dto.account.Results.GatecoinDepositAddressResult;
import org.knowm.xchange.gatecoin.dto.account.Results.GatecoinWithdrawResult;
import org.knowm.xchange.gatecoin.dto.trade.Results.GatecoinCancelOrderResult;
import org.knowm.xchange.gatecoin.dto.trade.Results.GatecoinOrderResult;
import org.knowm.xchange.gatecoin.dto.trade.Results.GatecoinPlaceOrderResult;
import org.knowm.xchange.gatecoin.dto.trade.Results.GatecoinTradeHistoryResult;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface GatecoinAuthenticated {

  @GET
  @Path("Trade/Orders")
  GatecoinOrderResult getOpenOrders(@HeaderParam("API_PUBLIC_KEY") String publicKey, @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature,
                                    @HeaderParam("API_REQUEST_DATE") String date) throws IOException, GatecoinException;

  @POST
  @Path("Trade/Orders")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  GatecoinPlaceOrderResult placeOrder(@HeaderParam("API_PUBLIC_KEY") String publicKey, @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature,
                                      @HeaderParam("API_REQUEST_DATE") String date, @FormParam("Amount") BigDecimal Amount, @FormParam("Price") BigDecimal Price,
                                      @FormParam("Way") String Way, @FormParam("Code") String Code) throws IOException, GatecoinException;

  @DELETE
  @Path("Trade/Orders")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  GatecoinCancelOrderResult cancelAllOrders(@HeaderParam("API_PUBLIC_KEY") String publicKey,
                                            @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature,
                                            @HeaderParam("API_REQUEST_DATE") String date) throws IOException, GatecoinException;

  @DELETE
  @Path("Trade/Orders/{OrderId}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  GatecoinCancelOrderResult cancelOrder(@HeaderParam("API_PUBLIC_KEY") String publicKey, @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature,
                                        @HeaderParam("API_REQUEST_DATE") String date, @PathParam("OrderId") String OrderId) throws IOException, GatecoinException;

  @GET
  @Path("Trade/Trades")
  GatecoinTradeHistoryResult getUserTrades(@HeaderParam("API_PUBLIC_KEY") String publicKey,
                                           @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature,
                                           @HeaderParam("API_REQUEST_DATE") String date) throws IOException, GatecoinException;

  @GET
  @Path("Trade/Trades")
  GatecoinTradeHistoryResult getUserTrades(@HeaderParam("API_PUBLIC_KEY") String publicKey,
                                           @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature, @HeaderParam("API_REQUEST_DATE") String date,
                                           @QueryParam("Count") int Count) throws IOException, GatecoinException;

  @GET
  @Path("Trade/Trades")
  GatecoinTradeHistoryResult getUserTrades(@HeaderParam("API_PUBLIC_KEY") String publicKey,
                                           @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature, @HeaderParam("API_REQUEST_DATE") String date, @QueryParam("Count") Integer Count,
                                           @QueryParam("TransactionID") Long TransactionID) throws IOException, GatecoinException;

  @GET
  @Path("Balance/Balances")
  GatecoinBalanceResult getUserBalance(@HeaderParam("API_PUBLIC_KEY") String publicKey, @HeaderParam("API_USER_ID") String userId,
                                       @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature,
                                       @HeaderParam("API_REQUEST_DATE") String date) throws IOException, GatecoinException;

  @GET
  @Path("ElectronicWallet/DepositWallets")
  GatecoinDepositAddressResult getDepositAddress(@HeaderParam("API_PUBLIC_KEY") String publicKey,
                                                 @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature,
                                                 @HeaderParam("API_REQUEST_DATE") String date) throws IOException, GatecoinException;

  @POST
  @Path("ElectronicWallet/Withdrawals/{DigiCurrency}")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  GatecoinWithdrawResult withdrawBitcoin(@HeaderParam("API_PUBLIC_KEY") String publicKey,
                                         @HeaderParam("API_REQUEST_SIGNATURE") ParamsDigest signature, @HeaderParam("API_REQUEST_DATE") String date,
                                         @PathParam("DigiCurrency") String DigiCurrency, @FormParam("AddressName") String AddressName,
                                         @FormParam("Amount") BigDecimal Amount) throws IOException, GatecoinException;

}

package org.knowm.xchange.abucoins;

import org.knowm.xchange.abucoins.dto.AbucoinsBaseCreateOrderRequest;
import org.knowm.xchange.abucoins.dto.AbucoinsCryptoDepositRequest;
import org.knowm.xchange.abucoins.dto.AbucoinsCryptoWithdrawalRequest;
import org.knowm.xchange.abucoins.dto.account.*;
import org.knowm.xchange.abucoins.dto.marketdata.AbucoinsCreateOrderResponse;
import org.knowm.xchange.abucoins.dto.trade.AbucoinsOrder;
import org.knowm.xchange.abucoins.dto.trade.AbucoinsOrders;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AbucoinsAuthenticated extends Abucoins {
  @GET
  @Path("accounts")
  AbucoinsAccounts getAccounts(@HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @GET
  @Path("accounts/{account-id}")
  AbucoinsAccount getAccount(@PathParam("account-id") String accountID, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @GET
  @Path("payment-methods")
  AbucoinsPaymentMethods getPaymentMethods(@HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @GET
  @Path("orders")
  AbucoinsOrders getOrders(@HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @GET
  @Path("orders?status={status}")
  AbucoinsOrders getOrdersByStatus(@PathParam("status") String status, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;

  @GET
  @Path("orders?product_id={product-id}")
  AbucoinsOrders getOrdersByProductID(@PathParam("product-id") String productID, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @GET
  @Path("orders?status={status}&product_id={product-id}")
  AbucoinsOrders getOrdersByStatusAndProductID(@PathParam("status") String status, @PathParam("product-id") String productID, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @GET
  @Path("orders/{order-id}")
  AbucoinsOrder getOrder(@PathParam("order-id") String orderID, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @POST
  @Path("orders")
  AbucoinsCreateOrderResponse createOrder(@HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp, AbucoinsBaseCreateOrderRequest req) throws IOException;
  
  @DELETE
  @Path("orders/{order-id}")
  @Produces(MediaType.TEXT_PLAIN)
  String deleteOrder(@PathParam("order-id") String orderID, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @DELETE
  @Path("orders")
  @Produces(MediaType.TEXT_PLAIN)
  String deleteAllOrders(@HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @DELETE
  @Path("orders?product_id={product-id}")
  @Produces(MediaType.TEXT_PLAIN)
  String deleteAllOrdersForProduct(@PathParam("product-id") String productID, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @GET
  @Path("fills")
  @Produces(MediaType.APPLICATION_JSON)
  AbucoinsFills getFills(@HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @POST
  @Path("withdrawals/crypto")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  AbucoinsCryptoWithdrawal cryptoWithdrawal(AbucoinsCryptoWithdrawalRequest cryptoWithdrawalRequest, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
  
  @POST
  @Path("deposits/crypto")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  AbucoinsCryptoDeposit cryptoDeposit(AbucoinsCryptoDepositRequest cryptoRequest, @HeaderParam("AC-ACCESS-KEY") String accessKey, @HeaderParam("AC-ACCESS-SIGN") ParamsDigest sign, @HeaderParam("AC-ACCESS-PASSPHRASE") String passphrase, @HeaderParam("AC-ACCESS-TIMESTAMP") String timestamp) throws IOException;
}

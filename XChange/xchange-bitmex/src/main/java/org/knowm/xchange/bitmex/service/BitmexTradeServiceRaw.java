package org.knowm.xchange.bitmex.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.bitmex.BitmexException;
import org.knowm.xchange.bitmex.dto.marketdata.BitmexPrivateOrder;
import org.knowm.xchange.bitmex.dto.trade.BitmexPosition;

public class BitmexTradeServiceRaw extends BitmexBaseService {

  /**
   * Constructor
   *
   * @param exchange
   */
  String apiKey = exchange.getExchangeSpecification().getApiKey();

  public BitmexTradeServiceRaw(Exchange exchange) {

    super(exchange);
  }

  public List<BitmexPosition> getBitmexPositions() throws IOException {

    try {
      return bitmex.getPositions(apiKey, exchange.getNonceFactory(), signatureCreator);
    } catch (BitmexException e) {
      throw handleError(e);
    }
  }

  public List<BitmexPosition> getBitmexPositions(String symbol,String filter) throws IOException {

    try {
      return bitmex.getPositions(apiKey, exchange.getNonceFactory(), signatureCreator,symbol, filter);
    } catch (BitmexException e) {
      throw handleError(e);
    }
  }

  public List<BitmexPrivateOrder> getBitmexOrders() throws IOException {
    ArrayList<BitmexPrivateOrder> orders = new ArrayList<>();

    for (int i = 0; orders.size() % 500 == 0; i++) {
      List<BitmexPrivateOrder> orderResponse = bitmex.getOrders(apiKey, exchange.getNonceFactory(), signatureCreator,
              null, null, 500, i * 500, true, null, null);
      if (orderResponse==null||orderResponse.size()==0){
        break;
      }
      orders.addAll(orderResponse.stream().filter(bitmexPrivateOrder -> bitmexPrivateOrder.getPrice()!=null).collect(Collectors.toList()));
    }

    return orders;
  }

  public List<BitmexPrivateOrder> getBitmexOrders(String symbol, String filter,Date startTime,Date endTime,Integer pageNum,Integer pageSize) throws IOException {
    ArrayList<BitmexPrivateOrder> orders = new ArrayList<>();

      List<BitmexPrivateOrder> orderResponse = bitmex.getOrders(apiKey, exchange.getNonceFactory(), signatureCreator,
              symbol, filter, pageSize, pageNum * pageSize, true, startTime, endTime);
      if (orderResponse==null||orderResponse.size()==0){
        return Collections.EMPTY_LIST;
      }
      orders.addAll(orderResponse.stream().filter(bitmexPrivateOrder -> bitmexPrivateOrder.getPrice()!=null).collect(Collectors.toList()));

    return orders;
  }
}

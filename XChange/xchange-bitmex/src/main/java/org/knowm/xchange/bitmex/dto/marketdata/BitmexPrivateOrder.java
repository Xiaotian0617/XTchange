package org.knowm.xchange.bitmex.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.bitmex.dto.trade.BitmexOrderStatus;
import org.knowm.xchange.bitmex.dto.trade.BitmexOrderType;
import org.knowm.xchange.bitmex.dto.trade.BitmexSide;

import java.math.BigDecimal;
import java.util.Date;

public class BitmexPrivateOrder {

  private final BigDecimal price;
  private final BigDecimal avgPx;
  private final BigDecimal size;
  private final String symbol;
  private final String id;
  private final BitmexSide side;
  private final Date timestamp;
  private final OrderStatus orderStatus;
  private final String currency;
  private final String settleCurrency;
  private final BigDecimal cumQty;
  private final String ordType;

  public enum OrderStatus {
    New, Partially_filled, Filled, Canceled
  }

  public BitmexPrivateOrder(@JsonProperty("ordType") String ordType,@JsonProperty("price") BigDecimal price, @JsonProperty("orderID") String id,
                            @JsonProperty("orderQty") BigDecimal size, @JsonProperty("side") BitmexSide side,
                            @JsonProperty("symbol") String symbol, @JsonProperty("timestamp") Date timestamp,
                            @JsonProperty("ordStatus") OrderStatus orderStatus,
                            @JsonProperty("currency") String currency,
                            @JsonProperty("settlCurrency") String settleCurrency,@JsonProperty("cumQty") BigDecimal cumQty,@JsonProperty("avgPx") BigDecimal avgPx) {

    this.symbol = symbol;
    this.id = id;
    this.side = side;
    this.size = size;
    this.price = price;
    this.timestamp = timestamp;
    this.orderStatus = orderStatus;
    this.currency = currency;
    this.settleCurrency = settleCurrency;
    this.cumQty = cumQty;
    this.avgPx = avgPx;
    this.ordType = ordType;
  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getVolume() {

    return size;
  }

  public BitmexSide getSide() {

    return side;
  }

  public String getId() {

    return id;
  }

  public String getSymbol() {

    return symbol;
  }

  public Date getTimestamp() {

    return timestamp;
  }

  public OrderStatus getOrderStatus() {

    return orderStatus;
  }

  public String getCurrency() {
    return currency;
  }

  public String getSettleCurrency() {
    return settleCurrency;
  }

  public BigDecimal getCumQty() {
    return cumQty;
  }

  public BigDecimal getAvgPx() {
    return avgPx;
  }

  public BigDecimal getSize() {
    return size;
  }

  @Override
  public String toString() {

    return "BitmexOrder [price=" + price + ", volume=" + size + ", symbol=" + symbol + ", side=" + side +
            ", timestamp=" + timestamp + ", cumQty=" + cumQty +"]";
  }

}

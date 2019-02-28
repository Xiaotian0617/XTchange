package com.ailu.bitmex.bean.marketdata;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class BitmexPublicOrder {

  private final BigDecimal price;
  private final BigDecimal size;
  private final String symbol;
  private final BigDecimal id;
  private final String side;

  public BitmexPublicOrder(@JSONField(name = "price") BigDecimal price, @JSONField(name = "id") BigDecimal id, @JSONField(name = "size") BigDecimal size, @JSONField(name = "side") String side,
                           @JSONField(name = "symbol") String symbol) {

    this.symbol = symbol;
    this.id = id;
    this.side = side;
    this.size = size;
    this.price = price;

  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getVolume() {

    return size;
  }

  public String getSide() {

    return side;
  }

  public BigDecimal getId() {

    return id;
  }

  public String getSymbol() {

    return symbol;
  }

  @Override
  public String toString() {

    return "BitmexOrder [price=" + price + ", volume=" + size + ", symbol=" + symbol + ", side=" + side + "]";
  }

}

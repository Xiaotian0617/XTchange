package com.ailu.bitmex.bean.marketdata;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

public class BitmexPublicTrade {

  private final BigDecimal price;
  private final BigDecimal size;
  private final Date timestamp;
  private final String side;
  private final String tickDirection;
  private final String symbol;
  private final String trdMatchID;
  private final BigDecimal grossValue;
  private final BigDecimal homeNotional;
  private final BigDecimal foreignNotional;

  public BitmexPublicTrade(@JSONField(name = "price") BigDecimal price, @JSONField(name = "size") BigDecimal size, @JSONField(name = "timestamp") Date timestamp, @JSONField(name = "side") String side,
                           @JSONField(name = "tickDirection") String tickDirection, @JSONField(name = "symbol") String symbol, @JSONField(name = "trdMatchID") String trdMatchID,
                           @JSONField(name = "grossValue") BigDecimal grossValue, @JSONField(name = "homeNotional") BigDecimal homeNotional, @JSONField(name = "foreignNotional") BigDecimal foreignNotional) {

    this.price = price;
    this.size = size;
    this.timestamp = timestamp;
    this.side = side;
    this.tickDirection = tickDirection;
    this.symbol = symbol;
    this.trdMatchID = trdMatchID;
    this.homeNotional = homeNotional;
    this.foreignNotional = foreignNotional;
    this.grossValue = grossValue;

  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getSize() {

    return size;
  }

  public Date getTime() {

    return timestamp;
  }

  public String getSide() {

    return side;
  }

  public String getTickDirection() {

    return tickDirection;
  }

  public String getSymbol() {

    return symbol;
  }

  public String getTrdMatchID() {

    return trdMatchID;
  }

  @Override
  public String toString() {

    return "BitmexPublicTrade [symbol=" + symbol + " price=" + price + ", size=" + size + ", time=" + timestamp + ", side=" + side + ", tickDirection=" + tickDirection + "]";
  }

}

package com.ailu.bitmex.bean.trade;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public final class BitmexTrade {

  @JSONField(name = "timestamp")
  public Date timestamp;
  @JSONField(name = "symbol")
  public String symbol;
  @JSONField(name = "side")
  public String side;
  @JSONField(name = "size")
  public BigDecimal size;
  @JSONField(name = "price")
  public BigDecimal price;
  @JSONField(name = "tickDirection")
  public String tickDirection;
  @JSONField(name = "trdMatchID")
  public String trdMatchID;
  @JSONField(name = "grossValue")
  public BigDecimal grossValue;
  @JSONField(name = "homeNotional")
  public BigDecimal homeNotional;
  @JSONField(name = "foreignNotional")
  public BigDecimal foreignNotional;
  @JSONField(serialize = false)
  private Map<String, Object> additionalProperties = new HashMap<>();

  public String getSymbol() {

    return symbol;
  }

  public String getSide() {

    return side;
  }

  public BigDecimal getSize() {

    return size;
  }

  public BigDecimal getPrice() {

    return price;
  }

  public String getTickDirection() {

    return tickDirection;
  }

  public String getTrdMatchID() {

    return trdMatchID;
  }

  public BigDecimal getGrossValue() {

    return grossValue;
  }

  public BigDecimal getHomeNotional() {

    return homeNotional;
  }

  public BigDecimal getForeignNotional() {

    return foreignNotional;
  }

  public Map<String, Object> getAdditionalProperties() {

    return additionalProperties;
  }

  @Override
  public String toString() {

    return "BitmexTrade{" + "symbol='" + symbol + '\'' + ", side='" + side + '\'' + ", size=" + size + ", price=" + price + ", tickDirection='" + tickDirection + '\'' + ", trdMatchID='" + trdMatchID
        + '\'' + ", grossValue=" + grossValue + ", homeNotional=" + homeNotional + ", foreignNotional=" + foreignNotional + '}';
  }

}
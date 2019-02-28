package com.ailu.bitmex.bean.trade;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class BitmexOrderDescription {

  private final String assetPair;
  private final String type;
  private final String orderType;
  private final BigDecimal price;
  private final BigDecimal secondaryPrice;
  private final String leverage;
  private final String positionTxId;
  private final String orderDescription;
  private final String closeDescription;

  /**
   * Constructor
   * 
   * @param assetPair
   * @param type
   * @param orderType
   * @param price
   * @param secondaryPrice
   * @param leverage
   * @param positionTxId
   * @param orderDescription
   * @param closeDescription
   */
  public BitmexOrderDescription(@JSONField(name = "pair") String assetPair, @JSONField(name = "type") String type, @JSONField(name = "ordertype") String orderType,
                                @JSONField(name = "price") BigDecimal price, @JSONField(name = "price2") BigDecimal secondaryPrice, @JSONField(name = "leverage") String leverage, @JSONField(name = "position") String positionTxId,
                                @JSONField(name = "order") String orderDescription, @JSONField(name = "close") String closeDescription) {

    this.assetPair = assetPair;
    this.type = type;
    this.orderType = orderType;
    this.price = price;
    this.secondaryPrice = secondaryPrice;
    this.leverage = leverage;
    this.positionTxId = positionTxId;
    this.orderDescription = orderDescription;
    this.closeDescription = closeDescription;
  }

  public String getAssetPair() {

    return assetPair;
  }

  public String getType() {

    return type;
  }

  public String getOrderType() {

    return orderType;
  }

  public BigDecimal getPrice() {

    return price;
  }

  public BigDecimal getSecondaryPrice() {

    return secondaryPrice;
  }

  public String getLeverage() {

    return leverage;
  }

  public String getPositionTxId() {

    return positionTxId;
  }

  public String getOrderDescription() {

    return orderDescription;
  }

  public String getCloseDescription() {

    return closeDescription;
  }

  @Override
  public String toString() {

    return "BitmexOrderDescription [assetPair=" + assetPair + ", type=" + type + ", orderType=" + orderType + ", price=" + price + ", secondaryPrice=" + secondaryPrice + ", leverage=" + leverage
        + ", positionTxId=" + positionTxId + ", orderDescription=" + orderDescription + ", closeDescription=" + closeDescription + "]";
  }

}

package com.ailu.bitmex.bean.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public final class BitmexWalletTransaction {

  @JSONField(name = "transactID")
  private String transactID;
  @JSONField(name = "account")
  private Integer account;
  @JSONField(name = "currency")
  private String currency;
  @JSONField(name = "transactType")
  private String transactType;
  @JSONField(name = "amount")
  private BigDecimal amount;
  @JSONField(name = "fee")
  private BigDecimal fee;
  @JSONField(name = "transactStatus")
  private String transactStatus;
  @JSONField(name = "address")
  private String address;
  @JSONField(name = "tx")
  private String tx;
  @JSONField(name = "text")
  private String text;
  @JSONField(name = "transactTime")
  private String transactTime;
  @JSONField(name = "timestamp")
  private String timestamp;
  @JSONField(serialize = false)
  private Map<String, Object> additionalProperties = new HashMap<>();


  public String getTransactID() {
    return transactID;
  }

  public Integer getAccount() {
    return account;
  }

  public String getCurrency() {
    return currency;
  }

  public String getTransactType() {
    return transactType;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getFee() {
    return fee;
  }

  public String getTransactStatus() {
    return transactStatus;
  }

  public String getAddress() {
    return address;
  }

  public String getTx() {
    return tx;
  }

  public String getText() {
    return text;
  }

  public String getTransactTime() {
    return transactTime;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }
}
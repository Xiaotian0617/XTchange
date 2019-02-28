package com.ailu.bitmex.bean.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class BitmexMarginAccount {

  @JSONField(name = "account")
  public Integer account;
  @JSONField(name = "currency")
  public String currency;
  @JSONField(name = "riskLimit")
  public BigDecimal riskLimit;
  @JSONField(name = "prevState")
  public String prevState;
  @JSONField(name = "state")
  public String state;
  @JSONField(name = "action")
  public String action;
  @JSONField(name = "amount")
  public BigDecimal amount;
  @JSONField(name = "pendingCredit")
  public BigDecimal pendingCredit;
  @JSONField(name = "pendingDebit")
  public BigDecimal pendingDebit;
  @JSONField(name = "confirmedDebit")
  public BigDecimal confirmedDebit;
  @JSONField(name = "prevRealisedPnl")
  public BigDecimal prevRealisedPnl;
  @JSONField(name = "prevUnrealisedPnl")
  public BigDecimal prevUnrealisedPnl;
  @JSONField(name = "grossComm")
  public BigDecimal grossComm;
  @JSONField(name = "grossOpenCost")
  public BigDecimal grossOpenCost;
  @JSONField(name = "grossOpenPremium")
  public BigDecimal grossOpenPremium;
  @JSONField(name = "grossExecCost")
  public BigDecimal grossExecCost;
  @JSONField(name = "grossMarkValue")
  public BigDecimal grossMarkValue;
  @JSONField(name = "riskValue")
  public BigDecimal riskValue;
  @JSONField(name = "taxableMargin")
  public BigDecimal taxableMargin;
  @JSONField(name = "initMargin")
  public BigDecimal initMargin;
  @JSONField(name = "maintMargin")
  public BigDecimal maintMargin;
  @JSONField(name = "sessionMargin")
  public BigDecimal sessionMargin;
  @JSONField(name = "targetExcessMargin")
  public BigDecimal targetExcessMargin;
  @JSONField(name = "varMargin")
  public BigDecimal varMargin;
  @JSONField(name = "realisedPnl")
  public BigDecimal realisedPnl;
  @JSONField(name = "unrealisedPnl")
  public BigDecimal unrealisedPnl;
  @JSONField(name = "indicativeTax")
  public BigDecimal indicativeTax;
  @JSONField(name = "unrealisedProfit")
  public BigDecimal unrealisedProfit;
  @JSONField(name = "syntheticMargin")
  public BigDecimal syntheticMargin;
  @JSONField(name = "walletBalance")
  public BigDecimal walletBalance;
  @JSONField(name = "marginBalance")
  public BigDecimal marginBalance;
  @JSONField(name = "marginBalancePcnt")
  public BigDecimal marginBalancePcnt;
  @JSONField(name = "marginLeverage")
  public BigDecimal marginLeverage;
  @JSONField(name = "marginUsedPcnt")
  public BigDecimal marginUsedPcnt;
  @JSONField(name = "excessMargin")
  public BigDecimal excessMargin;
  @JSONField(name = "excessMarginPcnt")
  public BigDecimal excessMarginPcnt;
  @JSONField(name = "availableMargin")
  public BigDecimal availableMargin;
  @JSONField(name = "withdrawableMargin")
  public BigDecimal withdrawableMargin;
  @JSONField(name = "timestamp")
  public String timestamp;
  @JSONField(name = "grossLastValue")
  public BigDecimal grossLastValue;
  @JSONField(name = "commission")
  public BigDecimal commission;
  @JSONField(serialize = false)
  private Map<String, Object> additionalProperties = new HashMap<>();

  public Integer getAccount() {
    return account;
  }

  public void setAccount(Integer account) {
    this.account = account;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getRiskLimit() {
    return riskLimit;
  }

  public void setRiskLimit(BigDecimal riskLimit) {
    this.riskLimit = riskLimit;
  }

  public String getPrevState() {
    return prevState;
  }

  public void setPrevState(String prevState) {
    this.prevState = prevState;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getPendingCredit() {
    return pendingCredit;
  }

  public void setPendingCredit(BigDecimal pendingCredit) {
    this.pendingCredit = pendingCredit;
  }

  public BigDecimal getPendingDebit() {
    return pendingDebit;
  }

  public void setPendingDebit(BigDecimal pendingDebit) {
    this.pendingDebit = pendingDebit;
  }

  public BigDecimal getConfirmedDebit() {
    return confirmedDebit;
  }

  public void setConfirmedDebit(BigDecimal confirmedDebit) {
    this.confirmedDebit = confirmedDebit;
  }

  public BigDecimal getPrevRealisedPnl() {
    return prevRealisedPnl;
  }

  public void setPrevRealisedPnl(BigDecimal prevRealisedPnl) {
    this.prevRealisedPnl = prevRealisedPnl;
  }

  public BigDecimal getPrevUnrealisedPnl() {
    return prevUnrealisedPnl;
  }

  public void setPrevUnrealisedPnl(BigDecimal prevUnrealisedPnl) {
    this.prevUnrealisedPnl = prevUnrealisedPnl;
  }

  public BigDecimal getGrossComm() {
    return grossComm;
  }

  public void setGrossComm(BigDecimal grossComm) {
    this.grossComm = grossComm;
  }

  public BigDecimal getGrossOpenCost() {
    return grossOpenCost;
  }

  public void setGrossOpenCost(BigDecimal grossOpenCost) {
    this.grossOpenCost = grossOpenCost;
  }

  public BigDecimal getGrossOpenPremium() {
    return grossOpenPremium;
  }

  public void setGrossOpenPremium(BigDecimal grossOpenPremium) {
    this.grossOpenPremium = grossOpenPremium;
  }

  public BigDecimal getGrossExecCost() {
    return grossExecCost;
  }

  public void setGrossExecCost(BigDecimal grossExecCost) {
    this.grossExecCost = grossExecCost;
  }

  public BigDecimal getGrossMarkValue() {
    return grossMarkValue;
  }

  public void setGrossMarkValue(BigDecimal grossMarkValue) {
    this.grossMarkValue = grossMarkValue;
  }

  public BigDecimal getRiskValue() {
    return riskValue;
  }

  public void setRiskValue(BigDecimal riskValue) {
    this.riskValue = riskValue;
  }

  public BigDecimal getTaxableMargin() {
    return taxableMargin;
  }

  public void setTaxableMargin(BigDecimal taxableMargin) {
    this.taxableMargin = taxableMargin;
  }

  public BigDecimal getInitMargin() {
    return initMargin;
  }

  public void setInitMargin(BigDecimal initMargin) {
    this.initMargin = initMargin;
  }

  public BigDecimal getMaintMargin() {
    return maintMargin;
  }

  public void setMaintMargin(BigDecimal maintMargin) {
    this.maintMargin = maintMargin;
  }

  public BigDecimal getSessionMargin() {
    return sessionMargin;
  }

  public void setSessionMargin(BigDecimal sessionMargin) {
    this.sessionMargin = sessionMargin;
  }

  public BigDecimal getTargetExcessMargin() {
    return targetExcessMargin;
  }

  public void setTargetExcessMargin(BigDecimal targetExcessMargin) {
    this.targetExcessMargin = targetExcessMargin;
  }

  public BigDecimal getVarMargin() {
    return varMargin;
  }

  public void setVarMargin(BigDecimal varMargin) {
    this.varMargin = varMargin;
  }

  public BigDecimal getRealisedPnl() {
    return realisedPnl;
  }

  public void setRealisedPnl(BigDecimal realisedPnl) {
    this.realisedPnl = realisedPnl;
  }

  public BigDecimal getUnrealisedPnl() {
    return unrealisedPnl;
  }

  public void setUnrealisedPnl(BigDecimal unrealisedPnl) {
    this.unrealisedPnl = unrealisedPnl;
  }

  public BigDecimal getIndicativeTax() {
    return indicativeTax;
  }

  public void setIndicativeTax(BigDecimal indicativeTax) {
    this.indicativeTax = indicativeTax;
  }

  public BigDecimal getUnrealisedProfit() {
    return unrealisedProfit;
  }

  public void setUnrealisedProfit(BigDecimal unrealisedProfit) {
    this.unrealisedProfit = unrealisedProfit;
  }

  public BigDecimal getSyntheticMargin() {
    return syntheticMargin;
  }

  public void setSyntheticMargin(BigDecimal syntheticMargin) {
    this.syntheticMargin = syntheticMargin;
  }

  public BigDecimal getWalletBalance() {
    return walletBalance;
  }

  public void setWalletBalance(BigDecimal walletBalance) {
    this.walletBalance = walletBalance;
  }

  public BigDecimal getMarginBalance() {
    return marginBalance;
  }

  public void setMarginBalance(BigDecimal marginBalance) {
    this.marginBalance = marginBalance;
  }

  public BigDecimal getMarginBalancePcnt() {
    return marginBalancePcnt;
  }

  public void setMarginBalancePcnt(BigDecimal marginBalancePcnt) {
    this.marginBalancePcnt = marginBalancePcnt;
  }

  public BigDecimal getMarginLeverage() {
    return marginLeverage;
  }

  public void setMarginLeverage(BigDecimal marginLeverage) {
    this.marginLeverage = marginLeverage;
  }

  public BigDecimal getMarginUsedPcnt() {
    return marginUsedPcnt;
  }

  public void setMarginUsedPcnt(BigDecimal marginUsedPcnt) {
    this.marginUsedPcnt = marginUsedPcnt;
  }

  public BigDecimal getExcessMargin() {
    return excessMargin;
  }

  public void setExcessMargin(BigDecimal excessMargin) {
    this.excessMargin = excessMargin;
  }

  public BigDecimal getExcessMarginPcnt() {
    return excessMarginPcnt;
  }

  public void setExcessMarginPcnt(BigDecimal excessMarginPcnt) {
    this.excessMarginPcnt = excessMarginPcnt;
  }

  public BigDecimal getAvailableMargin() {
    return availableMargin;
  }

  public void setAvailableMargin(BigDecimal availableMargin) {
    this.availableMargin = availableMargin;
  }

  public BigDecimal getWithdrawableMargin() {
    return withdrawableMargin;
  }

  public void setWithdrawableMargin(BigDecimal withdrawableMargin) {
    this.withdrawableMargin = withdrawableMargin;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public BigDecimal getGrossLastValue() {
    return grossLastValue;
  }

  public void setGrossLastValue(BigDecimal grossLastValue) {
    this.grossLastValue = grossLastValue;
  }

  public BigDecimal getCommission() {
    return commission;
  }

  public void setCommission(BigDecimal commission) {
    this.commission = commission;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}
package com.ailu.bitmex.bean.trade;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class BitmexPosition {
  @JSONField(name = "account")
  private Integer account;
  @JSONField(name = "symbol")
  private String symbol;
  @JSONField(name = "currency")
  private String currency;
  @JSONField(name = "underlying")
  private String underlying;
  @JSONField(name = "quoteCurrency")
  private String quoteCurrency;
  @JSONField(name = "commission")
  private BigDecimal commission;
  @JSONField(name = "initMarginReq")
  private BigDecimal initMarginReq;
  @JSONField(name = "maintMarginReq")
  private BigDecimal maintMarginReq;
  @JSONField(name = "riskLimit")
  private BigDecimal riskLimit;
  @JSONField(name = "leverage")
  private BigDecimal leverage;
  @JSONField(name = "crossMargin")
  private Boolean crossMargin;
  @JSONField(name = "deleveragePercentile")
  private BigDecimal deleveragePercentile;
  @JSONField(name = "rebalancedPnl")
  private BigDecimal rebalancedPnl;
  @JSONField(name = "prevRealisedPnl")
  private BigDecimal prevRealisedPnl;
  @JSONField(name = "prevUnrealisedPnl")
  private BigDecimal prevUnrealisedPnl;
  @JSONField(name = "prevClosePrice")
  private BigDecimal prevClosePrice;
  @JSONField(name = "openingTimestamp")
  private String openingTimestamp;
  @JSONField(name = "openingQty")
  private BigDecimal openingQty;
  @JSONField(name = "openingCost")
  private BigDecimal openingCost;
  @JSONField(name = "openingComm")
  private BigDecimal openingComm;
  @JSONField(name = "openOrderBuyQty")
  private BigDecimal openOrderBuyQty;
  @JSONField(name = "openOrderBuyCost")
  private BigDecimal openOrderBuyCost;
  @JSONField(name = "openOrderBuyPremium")
  private BigDecimal openOrderBuyPremium;
  @JSONField(name = "openOrderSellQty")
  private BigDecimal openOrderSellQty;
  @JSONField(name = "openOrderSellCost")
  private BigDecimal openOrderSellCost;
  @JSONField(name = "openOrderSellPremium")
  private BigDecimal openOrderSellPremium;
  @JSONField(name = "execBuyQty")
  private BigDecimal execBuyQty;
  @JSONField(name = "execBuyCost")
  private BigDecimal execBuyCost;
  @JSONField(name = "execSellQty")
  private BigDecimal execSellQty;
  @JSONField(name = "execSellCost")
  private BigDecimal execSellCost;
  @JSONField(name = "execQty")
  private BigDecimal execQty;
  @JSONField(name = "execCost")
  private BigDecimal execCost;
  @JSONField(name = "execComm")
  private BigDecimal execComm;
  @JSONField(name = "currentTimestamp")
  private String currentTimestamp;
  @JSONField(name = "currentQty")
  private BigDecimal currentQty;
  @JSONField(name = "currentCost")
  private BigDecimal currentCost;
  @JSONField(name = "currentComm")
  private BigDecimal currentComm;
  @JSONField(name = "realisedCost")
  private BigDecimal realisedCost;
  @JSONField(name = "unrealisedCost")
  private BigDecimal unrealisedCost;
  @JSONField(name = "grossOpenCost")
  private BigDecimal grossOpenCost;
  @JSONField(name = "grossOpenPremium")
  private BigDecimal grossOpenPremium;
  @JSONField(name = "grossExecCost")
  private BigDecimal grossExecCost;
  @JSONField(name = "isOpen")
  private Boolean isOpen;
  @JSONField(name = "markPrice")
  private BigDecimal markPrice;
  @JSONField(name = "markValue")
  private BigDecimal markValue;
  @JSONField(name = "riskValue")
  private BigDecimal riskValue;
  @JSONField(name = "homeNotional")
  private BigDecimal homeNotional;
  @JSONField(name = "foreignNotional")
  private BigDecimal foreignNotional;
  @JSONField(name = "posState")
  private String posState;
  @JSONField(name = "posCost")
  private BigDecimal posCost;
  @JSONField(name = "posCost2")
  private BigDecimal posCost2;
  @JSONField(name = "posCross")
  private BigDecimal posCross;
  @JSONField(name = "posInit")
  private BigDecimal posInit;
  @JSONField(name = "posComm")
  private BigDecimal posComm;
  @JSONField(name = "posLoss")
  private BigDecimal posLoss;
  @JSONField(name = "posMargin")
  private BigDecimal posMargin;
  @JSONField(name = "posMaint")
  private BigDecimal posMaint;
  @JSONField(name = "posAllowance")
  private BigDecimal posAllowance;
  @JSONField(name = "taxableMargin")
  private BigDecimal taxableMargin;
  @JSONField(name = "initMargin")
  private BigDecimal initMargin;
  @JSONField(name = "maintMargin")
  private BigDecimal maintMargin;
  @JSONField(name = "sessionMargin")
  private BigDecimal sessionMargin;
  @JSONField(name = "targetExcessMargin")
  private BigDecimal targetExcessMargin;
  @JSONField(name = "varMargin")
  private BigDecimal varMargin;
  @JSONField(name = "realisedGrossPnl")
  private BigDecimal realisedGrossPnl;
  @JSONField(name = "realisedTax")
  private BigDecimal realisedTax;
  @JSONField(name = "realisedPnl")
  private BigDecimal realisedPnl;
  @JSONField(name = "unrealisedGrossPnl")
  private BigDecimal unrealisedGrossPnl;
  @JSONField(name = "longBankrupt")
  private BigDecimal longBankrupt;
  @JSONField(name = "shortBankrupt")
  private BigDecimal shortBankrupt;
  @JSONField(name = "taxBase")
  private BigDecimal taxBase;
  @JSONField(name = "indicativeTaxRate")
  private BigDecimal indicativeTaxRate;
  @JSONField(name = "indicativeTax")
  private BigDecimal indicativeTax;
  @JSONField(name = "unrealisedTax")
  private BigDecimal unrealisedTax;
  @JSONField(name = "unrealisedPnl")
  private BigDecimal unrealisedPnl;
  @JSONField(name = "unrealisedPnlPcnt")
  private BigDecimal unrealisedPnlPcnt;
  @JSONField(name = "unrealisedRoePcnt")
  private BigDecimal unrealisedRoePcnt;
  @JSONField(name = "simpleQty")
  private BigDecimal simpleQty;
  @JSONField(name = "simpleCost")
  private BigDecimal simpleCost;
  @JSONField(name = "simpleValue")
  private BigDecimal simpleValue;
  @JSONField(name = "simplePnl")
  private BigDecimal simplePnl;
  @JSONField(name = "simplePnlPcnt")
  private BigDecimal simplePnlPcnt;
  @JSONField(name = "avgCostPrice")
  private BigDecimal avgCostPrice;
  @JSONField(name = "avgEntryPrice")
  private BigDecimal avgEntryPrice;
  @JSONField(name = "breakEvenPrice")
  private BigDecimal breakEvenPrice;
  @JSONField(name = "marginCallPrice")
  private BigDecimal marginCallPrice;
  @JSONField(name = "liquidationPrice")
  private BigDecimal liquidationPrice;
  @JSONField(name = "bankruptPrice")
  private BigDecimal bankruptPrice;
  @JSONField(name = "timestamp")
  private String timestamp;
  @JSONField(name = "lastPrice")
  private BigDecimal lastPrice;
  @JSONField(name = "lastValue")
  private BigDecimal lastValue;


  public Integer getAccount() {
    return account;
  }

  public void setAccount(Integer account) {
    this.account = account;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getUnderlying() {
    return underlying;
  }

  public void setUnderlying(String underlying) {
    this.underlying = underlying;
  }

  public String getQuoteCurrency() {
    return quoteCurrency;
  }

  public void setQuoteCurrency(String quoteCurrency) {
    this.quoteCurrency = quoteCurrency;
  }

  public BigDecimal getCommission() {
    return commission;
  }

  public void setCommission(BigDecimal commission) {
    this.commission = commission;
  }

  public BigDecimal getInitMarginReq() {
    return initMarginReq;
  }

  public void setInitMarginReq(BigDecimal initMarginReq) {
    this.initMarginReq = initMarginReq;
  }

  public BigDecimal getMaintMarginReq() {
    return maintMarginReq;
  }

  public void setMaintMarginReq(BigDecimal maintMarginReq) {
    this.maintMarginReq = maintMarginReq;
  }

  public BigDecimal getRiskLimit() {
    return riskLimit;
  }

  public void setRiskLimit(BigDecimal riskLimit) {
    this.riskLimit = riskLimit;
  }

  public BigDecimal getLeverage() {
    return leverage;
  }

  public void setLeverage(BigDecimal leverage) {
    this.leverage = leverage;
  }

  public Boolean getCrossMargin() {
    return crossMargin;
  }

  public void setCrossMargin(Boolean crossMargin) {
    this.crossMargin = crossMargin;
  }

  public BigDecimal getDeleveragePercentile() {
    return deleveragePercentile;
  }

  public void setDeleveragePercentile(BigDecimal deleveragePercentile) {
    this.deleveragePercentile = deleveragePercentile;
  }

  public BigDecimal getRebalancedPnl() {
    return rebalancedPnl;
  }

  public void setRebalancedPnl(BigDecimal rebalancedPnl) {
    this.rebalancedPnl = rebalancedPnl;
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

  public BigDecimal getPrevClosePrice() {
    return prevClosePrice;
  }

  public void setPrevClosePrice(BigDecimal prevClosePrice) {
    this.prevClosePrice = prevClosePrice;
  }

  public String getOpeningTimestamp() {
    return openingTimestamp;
  }

  public void setOpeningTimestamp(String openingTimestamp) {
    this.openingTimestamp = openingTimestamp;
  }

  public BigDecimal getOpeningQty() {
    return openingQty;
  }

  public void setOpeningQty(BigDecimal openingQty) {
    this.openingQty = openingQty;
  }

  public BigDecimal getOpeningCost() {
    return openingCost;
  }

  public void setOpeningCost(BigDecimal openingCost) {
    this.openingCost = openingCost;
  }

  public BigDecimal getOpeningComm() {
    return openingComm;
  }

  public void setOpeningComm(BigDecimal openingComm) {
    this.openingComm = openingComm;
  }

  public BigDecimal getOpenOrderBuyQty() {
    return openOrderBuyQty;
  }

  public void setOpenOrderBuyQty(BigDecimal openOrderBuyQty) {
    this.openOrderBuyQty = openOrderBuyQty;
  }

  public BigDecimal getOpenOrderBuyCost() {
    return openOrderBuyCost;
  }

  public void setOpenOrderBuyCost(BigDecimal openOrderBuyCost) {
    this.openOrderBuyCost = openOrderBuyCost;
  }

  public BigDecimal getOpenOrderBuyPremium() {
    return openOrderBuyPremium;
  }

  public void setOpenOrderBuyPremium(BigDecimal openOrderBuyPremium) {
    this.openOrderBuyPremium = openOrderBuyPremium;
  }

  public BigDecimal getOpenOrderSellQty() {
    return openOrderSellQty;
  }

  public void setOpenOrderSellQty(BigDecimal openOrderSellQty) {
    this.openOrderSellQty = openOrderSellQty;
  }

  public BigDecimal getOpenOrderSellCost() {
    return openOrderSellCost;
  }

  public void setOpenOrderSellCost(BigDecimal openOrderSellCost) {
    this.openOrderSellCost = openOrderSellCost;
  }

  public BigDecimal getOpenOrderSellPremium() {
    return openOrderSellPremium;
  }

  public void setOpenOrderSellPremium(BigDecimal openOrderSellPremium) {
    this.openOrderSellPremium = openOrderSellPremium;
  }

  public BigDecimal getExecBuyQty() {
    return execBuyQty;
  }

  public void setExecBuyQty(BigDecimal execBuyQty) {
    this.execBuyQty = execBuyQty;
  }

  public BigDecimal getExecBuyCost() {
    return execBuyCost;
  }

  public void setExecBuyCost(BigDecimal execBuyCost) {
    this.execBuyCost = execBuyCost;
  }

  public BigDecimal getExecSellQty() {
    return execSellQty;
  }

  public void setExecSellQty(BigDecimal execSellQty) {
    this.execSellQty = execSellQty;
  }

  public BigDecimal getExecSellCost() {
    return execSellCost;
  }

  public void setExecSellCost(BigDecimal execSellCost) {
    this.execSellCost = execSellCost;
  }

  public BigDecimal getExecQty() {
    return execQty;
  }

  public void setExecQty(BigDecimal execQty) {
    this.execQty = execQty;
  }

  public BigDecimal getExecCost() {
    return execCost;
  }

  public void setExecCost(BigDecimal execCost) {
    this.execCost = execCost;
  }

  public BigDecimal getExecComm() {
    return execComm;
  }

  public void setExecComm(BigDecimal execComm) {
    this.execComm = execComm;
  }

  public String getCurrentTimestamp() {
    return currentTimestamp;
  }

  public void setCurrentTimestamp(String currentTimestamp) {
    this.currentTimestamp = currentTimestamp;
  }

  public BigDecimal getCurrentQty() {
    return currentQty;
  }

  public void setCurrentQty(BigDecimal currentQty) {
    this.currentQty = currentQty;
  }

  public BigDecimal getCurrentCost() {
    return currentCost;
  }

  public void setCurrentCost(BigDecimal currentCost) {
    this.currentCost = currentCost;
  }

  public BigDecimal getCurrentComm() {
    return currentComm;
  }

  public void setCurrentComm(BigDecimal currentComm) {
    this.currentComm = currentComm;
  }

  public BigDecimal getRealisedCost() {
    return realisedCost;
  }

  public void setRealisedCost(BigDecimal realisedCost) {
    this.realisedCost = realisedCost;
  }

  public BigDecimal getUnrealisedCost() {
    return unrealisedCost;
  }

  public void setUnrealisedCost(BigDecimal unrealisedCost) {
    this.unrealisedCost = unrealisedCost;
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

  public Boolean getOpen() {
    return isOpen;
  }

  public void setOpen(Boolean open) {
    isOpen = open;
  }

  public BigDecimal getMarkPrice() {
    return markPrice;
  }

  public void setMarkPrice(BigDecimal markPrice) {
    this.markPrice = markPrice;
  }

  public BigDecimal getMarkValue() {
    return markValue;
  }

  public void setMarkValue(BigDecimal markValue) {
    this.markValue = markValue;
  }

  public BigDecimal getRiskValue() {
    return riskValue;
  }

  public void setRiskValue(BigDecimal riskValue) {
    this.riskValue = riskValue;
  }

  public BigDecimal getHomeNotional() {
    return homeNotional;
  }

  public void setHomeNotional(BigDecimal homeNotional) {
    this.homeNotional = homeNotional;
  }

  public BigDecimal getForeignNotional() {
    return foreignNotional;
  }

  public void setForeignNotional(BigDecimal foreignNotional) {
    this.foreignNotional = foreignNotional;
  }

  public String getPosState() {
    return posState;
  }

  public void setPosState(String posState) {
    this.posState = posState;
  }

  public BigDecimal getPosCost() {
    return posCost;
  }

  public void setPosCost(BigDecimal posCost) {
    this.posCost = posCost;
  }

  public BigDecimal getPosCost2() {
    return posCost2;
  }

  public void setPosCost2(BigDecimal posCost2) {
    this.posCost2 = posCost2;
  }

  public BigDecimal getPosCross() {
    return posCross;
  }

  public void setPosCross(BigDecimal posCross) {
    this.posCross = posCross;
  }

  public BigDecimal getPosInit() {
    return posInit;
  }

  public void setPosInit(BigDecimal posInit) {
    this.posInit = posInit;
  }

  public BigDecimal getPosComm() {
    return posComm;
  }

  public void setPosComm(BigDecimal posComm) {
    this.posComm = posComm;
  }

  public BigDecimal getPosLoss() {
    return posLoss;
  }

  public void setPosLoss(BigDecimal posLoss) {
    this.posLoss = posLoss;
  }

  public BigDecimal getPosMargin() {
    return posMargin;
  }

  public void setPosMargin(BigDecimal posMargin) {
    this.posMargin = posMargin;
  }

  public BigDecimal getPosMaint() {
    return posMaint;
  }

  public void setPosMaint(BigDecimal posMaint) {
    this.posMaint = posMaint;
  }

  public BigDecimal getPosAllowance() {
    return posAllowance;
  }

  public void setPosAllowance(BigDecimal posAllowance) {
    this.posAllowance = posAllowance;
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

  public BigDecimal getRealisedGrossPnl() {
    return realisedGrossPnl;
  }

  public void setRealisedGrossPnl(BigDecimal realisedGrossPnl) {
    this.realisedGrossPnl = realisedGrossPnl;
  }

  public BigDecimal getRealisedTax() {
    return realisedTax;
  }

  public void setRealisedTax(BigDecimal realisedTax) {
    this.realisedTax = realisedTax;
  }

  public BigDecimal getRealisedPnl() {
    return realisedPnl;
  }

  public void setRealisedPnl(BigDecimal realisedPnl) {
    this.realisedPnl = realisedPnl;
  }

  public BigDecimal getUnrealisedGrossPnl() {
    return unrealisedGrossPnl;
  }

  public void setUnrealisedGrossPnl(BigDecimal unrealisedGrossPnl) {
    this.unrealisedGrossPnl = unrealisedGrossPnl;
  }

  public BigDecimal getLongBankrupt() {
    return longBankrupt;
  }

  public void setLongBankrupt(BigDecimal longBankrupt) {
    this.longBankrupt = longBankrupt;
  }

  public BigDecimal getShortBankrupt() {
    return shortBankrupt;
  }

  public void setShortBankrupt(BigDecimal shortBankrupt) {
    this.shortBankrupt = shortBankrupt;
  }

  public BigDecimal getTaxBase() {
    return taxBase;
  }

  public void setTaxBase(BigDecimal taxBase) {
    this.taxBase = taxBase;
  }

  public BigDecimal getIndicativeTaxRate() {
    return indicativeTaxRate;
  }

  public void setIndicativeTaxRate(BigDecimal indicativeTaxRate) {
    this.indicativeTaxRate = indicativeTaxRate;
  }

  public BigDecimal getIndicativeTax() {
    return indicativeTax;
  }

  public void setIndicativeTax(BigDecimal indicativeTax) {
    this.indicativeTax = indicativeTax;
  }

  public BigDecimal getUnrealisedTax() {
    return unrealisedTax;
  }

  public void setUnrealisedTax(BigDecimal unrealisedTax) {
    this.unrealisedTax = unrealisedTax;
  }

  public BigDecimal getUnrealisedPnl() {
    return unrealisedPnl;
  }

  public void setUnrealisedPnl(BigDecimal unrealisedPnl) {
    this.unrealisedPnl = unrealisedPnl;
  }

  public BigDecimal getUnrealisedPnlPcnt() {
    return unrealisedPnlPcnt;
  }

  public void setUnrealisedPnlPcnt(BigDecimal unrealisedPnlPcnt) {
    this.unrealisedPnlPcnt = unrealisedPnlPcnt;
  }

  public BigDecimal getUnrealisedRoePcnt() {
    return unrealisedRoePcnt;
  }

  public void setUnrealisedRoePcnt(BigDecimal unrealisedRoePcnt) {
    this.unrealisedRoePcnt = unrealisedRoePcnt;
  }

  public BigDecimal getSimpleQty() {
    return simpleQty;
  }

  public void setSimpleQty(BigDecimal simpleQty) {
    this.simpleQty = simpleQty;
  }

  public BigDecimal getSimpleCost() {
    return simpleCost;
  }

  public void setSimpleCost(BigDecimal simpleCost) {
    this.simpleCost = simpleCost;
  }

  public BigDecimal getSimpleValue() {
    return simpleValue;
  }

  public void setSimpleValue(BigDecimal simpleValue) {
    this.simpleValue = simpleValue;
  }

  public BigDecimal getSimplePnl() {
    return simplePnl;
  }

  public void setSimplePnl(BigDecimal simplePnl) {
    this.simplePnl = simplePnl;
  }

  public BigDecimal getSimplePnlPcnt() {
    return simplePnlPcnt;
  }

  public void setSimplePnlPcnt(BigDecimal simplePnlPcnt) {
    this.simplePnlPcnt = simplePnlPcnt;
  }

  public BigDecimal getAvgCostPrice() {
    return avgCostPrice;
  }

  public void setAvgCostPrice(BigDecimal avgCostPrice) {
    this.avgCostPrice = avgCostPrice;
  }

  public BigDecimal getAvgEntryPrice() {
    return avgEntryPrice;
  }

  public void setAvgEntryPrice(BigDecimal avgEntryPrice) {
    this.avgEntryPrice = avgEntryPrice;
  }

  public BigDecimal getBreakEvenPrice() {
    return breakEvenPrice;
  }

  public void setBreakEvenPrice(BigDecimal breakEvenPrice) {
    this.breakEvenPrice = breakEvenPrice;
  }

  public BigDecimal getMarginCallPrice() {
    return marginCallPrice;
  }

  public void setMarginCallPrice(BigDecimal marginCallPrice) {
    this.marginCallPrice = marginCallPrice;
  }

  public BigDecimal getLiquidationPrice() {
    return liquidationPrice;
  }

  public void setLiquidationPrice(BigDecimal liquidationPrice) {
    this.liquidationPrice = liquidationPrice;
  }

  public BigDecimal getBankruptPrice() {
    return bankruptPrice;
  }

  public void setBankruptPrice(BigDecimal bankruptPrice) {
    this.bankruptPrice = bankruptPrice;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public BigDecimal getLastPrice() {
    return lastPrice;
  }

  public void setLastPrice(BigDecimal lastPrice) {
    this.lastPrice = lastPrice;
  }

  public BigDecimal getLastValue() {
    return lastValue;
  }

  public void setLastValue(BigDecimal lastValue) {
    this.lastValue = lastValue;
  }
}

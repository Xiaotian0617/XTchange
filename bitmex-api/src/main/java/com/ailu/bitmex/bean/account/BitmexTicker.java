package com.ailu.bitmex.bean.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


public class BitmexTicker {

  @JSONField(name = "symbol")
  private String symbol;
  @JSONField(name = "rootSymbol")
  private String rootSymbol;
  @JSONField(name = "state")
  private String state;
  @JSONField(name = "typ")
  private String typ;
  @JSONField(name = "listing")
  private String listing;
  @JSONField(name = "front")
  private String front;
  @JSONField(name = "expiry")
  private String expiry;
  @JSONField(name = "settle")
  private String settle;
  @JSONField(name = "relistInterval")
  private String relistInterval;
  @JSONField(name = "inverseLeg")
  private String inverseLeg;
  @JSONField(name = "sellLeg")
  private String sellLeg;
  @JSONField(name = "buyLeg")
  private String buyLeg;
  @JSONField(name = "positionCurrency")
  private String positionCurrency;
  @JSONField(name = "underlying")
  private String underlying;
  @JSONField(name = "quoteCurrency")
  private String quoteCurrency;
  @JSONField(name = "underlyingSymbol")
  private String underlyingSymbol;
  @JSONField(name = "reference")
  private String reference;
  @JSONField(name = "referenceSymbol")
  private String referenceSymbol;
  @JSONField(name = "calcInterval")
  private String calcInterval;
  @JSONField(name = "publishInterval")
  private String publishInterval;
  @JSONField(name = "publishTime")
  private String publishTime;
  @JSONField(name = "maxOrderQty")
  private BigDecimal maxOrderQty;
  @JSONField(name = "maxPrice")
  private BigDecimal maxPrice;
  @JSONField(name = "lotSize")
  private BigDecimal lotSize;
  @JSONField(name = "tickSize")
  private BigDecimal tickSize;
  @JSONField(name = "multiplier")
  private BigDecimal multiplier;
  @JSONField(name = "settlCurrency")
  private String settlCurrency;
  @JSONField(name = "underlyingToPositionMultiplier")
  private BigDecimal underlyingToPositionMultiplier;
  @JSONField(name = "underlyingToSettleMultiplier")
  private BigDecimal underlyingToSettleMultiplier;
  @JSONField(name = "quoteToSettleMultiplier")
  private BigDecimal quoteToSettleMultiplier;
  @JSONField(name = "isQuanto")
  private Boolean isQuanto;
  @JSONField(name = "isInverse")
  private Boolean isInverse;
  @JSONField(name = "initMargin")
  private BigDecimal initMargin;
  @JSONField(name = "maintMargin")
  private BigDecimal maintMargin;
  @JSONField(name = "riskLimit")
  private BigInteger riskLimit;
  @JSONField(name = "riskStep")
  private BigInteger riskStep;
  @JSONField(name = "limit")
  private BigDecimal limit;
  @JSONField(name = "capped")
  private Boolean capped;
  @JSONField(name = "taxed")
  private Boolean taxed;
  @JSONField(name = "deleverage")
  private Boolean deleverage;
  @JSONField(name = "makerFee")
  private BigDecimal makerFee;
  @JSONField(name = "takerFee")
  private BigDecimal takerFee;
  @JSONField(name = "settlementFee")
  private BigDecimal settlementFee;
  @JSONField(name = "insuranceFee")
  private BigDecimal insuranceFee;
  @JSONField(name = "fundingBaseSymbol")
  private String fundingBaseSymbol;
  @JSONField(name = "fundingQuoteSymbol")
  private String fundingQuoteSymbol;
  @JSONField(name = "fundingPremiumSymbol")
  private String fundingPremiumSymbol;
  @JSONField(name = "fundingTimestamp")
  private String fundingTimestamp;
  @JSONField(name = "fundingInterval")
  private String fundingInterval;
  @JSONField(name = "fundingRate")
  private BigDecimal fundingRate;
  @JSONField(name = "indicativeFundingRate")
  private BigDecimal indicativeFundingRate;
  @JSONField(name = "rebalanceTimestamp")
  private String rebalanceTimestamp;
  @JSONField(name = "rebalanceInterval")
  private String rebalanceInterval;
  @JSONField(name = "openingTimestamp")
  private String openingTimestamp;
  @JSONField(name = "closingTimestamp")
  private String closingTimestamp;
  @JSONField(name = "sessionInterval")
  private String sessionInterval;
  @JSONField(name = "prevClosePrice")
  private BigDecimal prevClosePrice;
  @JSONField(name = "limitDownPrice")
  private BigDecimal limitDownPrice;
  @JSONField(name = "limitUpPrice")
  private BigDecimal limitUpPrice;
  @JSONField(name = "bankruptLimitDownPrice")
  private BigDecimal bankruptLimitDownPrice;
  @JSONField(name = "bankruptLimitUpPrice")
  private BigDecimal bankruptLimitUpPrice;
  @JSONField(name = "prevTotalVolume")
  private BigDecimal prevTotalVolume;
  @JSONField(name = "totalVolume")
  private BigDecimal totalVolume;
  @JSONField(name = "volume")
  private BigDecimal volume;
  @JSONField(name = "volume24h")
  private BigDecimal volume24h;
  @JSONField(name = "prevTotalTurnover")
  private BigInteger prevTotalTurnover;
  @JSONField(name = "totalTurnover")
  private BigInteger totalTurnover;
  @JSONField(name = "turnover")
  private BigInteger turnover;
  @JSONField(name = "turnover24h")
  private BigInteger turnover24h;
  @JSONField(name = "prevPrice24h")
  private BigInteger prevPrice24h;
  @JSONField(name = "vwap")
  private BigInteger vwap;
  @JSONField(name = "highPrice")
  private BigDecimal highPrice;
  @JSONField(name = "lowPrice")
  private BigDecimal lowPrice;
  @JSONField(name = "lastPrice")
  private BigDecimal lastPrice;
  @JSONField(name = "lastPriceProtected")
  private BigDecimal lastPriceProtected;
  @JSONField(name = "lastTickDirection")
  private String lastTickDirection;
  @JSONField(name = "lastChangePcnt")
  private BigDecimal lastChangePcnt;
  @JSONField(name = "bidPrice")
  private BigDecimal bidPrice;
  @JSONField(name = "midPrice")
  private BigDecimal midPrice;
  @JSONField(name = "askPrice")
  private BigDecimal askPrice;
  @JSONField(name = "impactBidPrice")
  private BigDecimal impactBidPrice;
  @JSONField(name = "impactMidPrice")
  private BigDecimal impactMidPrice;
  @JSONField(name = "impactAskPrice")
  private BigDecimal impactAskPrice;
  @JSONField(name = "hasLiquidity")
  private Boolean hasLiquidity;
  @JSONField(name = "openInterest")
  private BigDecimal openInterest;
  @JSONField(name = "openValue")
  private BigDecimal openValue;
  @JSONField(name = "fairMethod")
  private String fairMethod;
  @JSONField(name = "fairBasisRate")
  private BigDecimal fairBasisRate;
  @JSONField(name = "fairBasis")
  private BigDecimal fairBasis;
  @JSONField(name = "fairPrice")
  private BigDecimal fairPrice;
  @JSONField(name = "markMethod")
  private String markMethod;
  @JSONField(name = "markPrice")
  private BigDecimal markPrice;
  @JSONField(name = "indicativeTaxRate")
  private BigDecimal indicativeTaxRate;
  @JSONField(name = "indicativeSettlePrice")
  private BigDecimal indicativeSettlePrice;
  @JSONField(name = "settledPrice")
  private BigDecimal settledPrice;
  @JSONField(name = "timestamp")
  private String timestamp;
  @JSONField(serialize = false)
  private Map<String, Object> additionalProperties = new HashMap<>();

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getRootSymbol() {
    return rootSymbol;
  }

  public void setRootSymbol(String rootSymbol) {
    this.rootSymbol = rootSymbol;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getTyp() {
    return typ;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }

  public String getListing() {
    return listing;
  }

  public void setListing(String listing) {
    this.listing = listing;
  }

  public String getFront() {
    return front;
  }

  public void setFront(String front) {
    this.front = front;
  }

  public String getExpiry() {
    return expiry;
  }

  public void setExpiry(String expiry) {
    this.expiry = expiry;
  }

  public String getSettle() {
    return settle;
  }

  public void setSettle(String settle) {
    this.settle = settle;
  }

  public String getRelistInterval() {
    return relistInterval;
  }

  public void setRelistInterval(String relistInterval) {
    this.relistInterval = relistInterval;
  }

  public String getInverseLeg() {
    return inverseLeg;
  }

  public void setInverseLeg(String inverseLeg) {
    this.inverseLeg = inverseLeg;
  }

  public String getSellLeg() {
    return sellLeg;
  }

  public void setSellLeg(String sellLeg) {
    this.sellLeg = sellLeg;
  }

  public String getBuyLeg() {
    return buyLeg;
  }

  public void setBuyLeg(String buyLeg) {
    this.buyLeg = buyLeg;
  }

  public String getPositionCurrency() {
    return positionCurrency;
  }

  public void setPositionCurrency(String positionCurrency) {
    this.positionCurrency = positionCurrency;
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

  public String getUnderlyingSymbol() {
    return underlyingSymbol;
  }

  public void setUnderlyingSymbol(String underlyingSymbol) {
    this.underlyingSymbol = underlyingSymbol;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getReferenceSymbol() {
    return referenceSymbol;
  }

  public void setReferenceSymbol(String referenceSymbol) {
    this.referenceSymbol = referenceSymbol;
  }

  public String getCalcInterval() {
    return calcInterval;
  }

  public void setCalcInterval(String calcInterval) {
    this.calcInterval = calcInterval;
  }

  public String getPublishInterval() {
    return publishInterval;
  }

  public void setPublishInterval(String publishInterval) {
    this.publishInterval = publishInterval;
  }

  public String getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(String publishTime) {
    this.publishTime = publishTime;
  }

  public BigDecimal getMaxOrderQty() {
    return maxOrderQty;
  }

  public void setMaxOrderQty(BigDecimal maxOrderQty) {
    this.maxOrderQty = maxOrderQty;
  }

  public BigDecimal getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(BigDecimal maxPrice) {
    this.maxPrice = maxPrice;
  }

  public BigDecimal getLotSize() {
    return lotSize;
  }

  public void setLotSize(BigDecimal lotSize) {
    this.lotSize = lotSize;
  }

  public BigDecimal getTickSize() {
    return tickSize;
  }

  public void setTickSize(BigDecimal tickSize) {
    this.tickSize = tickSize;
  }

  public BigDecimal getMultiplier() {
    return multiplier;
  }

  public void setMultiplier(BigDecimal multiplier) {
    this.multiplier = multiplier;
  }

  public String getSettlCurrency() {
    return settlCurrency;
  }

  public void setSettlCurrency(String settlCurrency) {
    this.settlCurrency = settlCurrency;
  }

  public BigDecimal getUnderlyingToPositionMultiplier() {
    return underlyingToPositionMultiplier;
  }

  public void setUnderlyingToPositionMultiplier(BigDecimal underlyingToPositionMultiplier) {
    this.underlyingToPositionMultiplier = underlyingToPositionMultiplier;
  }

  public BigDecimal getUnderlyingToSettleMultiplier() {
    return underlyingToSettleMultiplier;
  }

  public void setUnderlyingToSettleMultiplier(BigDecimal underlyingToSettleMultiplier) {
    this.underlyingToSettleMultiplier = underlyingToSettleMultiplier;
  }

  public BigDecimal getQuoteToSettleMultiplier() {
    return quoteToSettleMultiplier;
  }

  public void setQuoteToSettleMultiplier(BigDecimal quoteToSettleMultiplier) {
    this.quoteToSettleMultiplier = quoteToSettleMultiplier;
  }

  public Boolean getQuanto() {
    return isQuanto;
  }

  public void setQuanto(Boolean quanto) {
    isQuanto = quanto;
  }

  public Boolean getInverse() {
    return isInverse;
  }

  public void setInverse(Boolean inverse) {
    isInverse = inverse;
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

  public BigInteger getRiskLimit() {
    return riskLimit;
  }

  public void setRiskLimit(BigInteger riskLimit) {
    this.riskLimit = riskLimit;
  }

  public BigInteger getRiskStep() {
    return riskStep;
  }

  public void setRiskStep(BigInteger riskStep) {
    this.riskStep = riskStep;
  }

  public BigDecimal getLimit() {
    return limit;
  }

  public void setLimit(BigDecimal limit) {
    this.limit = limit;
  }

  public Boolean getCapped() {
    return capped;
  }

  public void setCapped(Boolean capped) {
    this.capped = capped;
  }

  public Boolean getTaxed() {
    return taxed;
  }

  public void setTaxed(Boolean taxed) {
    this.taxed = taxed;
  }

  public Boolean getDeleverage() {
    return deleverage;
  }

  public void setDeleverage(Boolean deleverage) {
    this.deleverage = deleverage;
  }

  public BigDecimal getMakerFee() {
    return makerFee;
  }

  public void setMakerFee(BigDecimal makerFee) {
    this.makerFee = makerFee;
  }

  public BigDecimal getTakerFee() {
    return takerFee;
  }

  public void setTakerFee(BigDecimal takerFee) {
    this.takerFee = takerFee;
  }

  public BigDecimal getSettlementFee() {
    return settlementFee;
  }

  public void setSettlementFee(BigDecimal settlementFee) {
    this.settlementFee = settlementFee;
  }

  public BigDecimal getInsuranceFee() {
    return insuranceFee;
  }

  public void setInsuranceFee(BigDecimal insuranceFee) {
    this.insuranceFee = insuranceFee;
  }

  public String getFundingBaseSymbol() {
    return fundingBaseSymbol;
  }

  public void setFundingBaseSymbol(String fundingBaseSymbol) {
    this.fundingBaseSymbol = fundingBaseSymbol;
  }

  public String getFundingQuoteSymbol() {
    return fundingQuoteSymbol;
  }

  public void setFundingQuoteSymbol(String fundingQuoteSymbol) {
    this.fundingQuoteSymbol = fundingQuoteSymbol;
  }

  public String getFundingPremiumSymbol() {
    return fundingPremiumSymbol;
  }

  public void setFundingPremiumSymbol(String fundingPremiumSymbol) {
    this.fundingPremiumSymbol = fundingPremiumSymbol;
  }

  public String getFundingTimestamp() {
    return fundingTimestamp;
  }

  public void setFundingTimestamp(String fundingTimestamp) {
    this.fundingTimestamp = fundingTimestamp;
  }

  public String getFundingInterval() {
    return fundingInterval;
  }

  public void setFundingInterval(String fundingInterval) {
    this.fundingInterval = fundingInterval;
  }

  public BigDecimal getFundingRate() {
    return fundingRate;
  }

  public void setFundingRate(BigDecimal fundingRate) {
    this.fundingRate = fundingRate;
  }

  public BigDecimal getIndicativeFundingRate() {
    return indicativeFundingRate;
  }

  public void setIndicativeFundingRate(BigDecimal indicativeFundingRate) {
    this.indicativeFundingRate = indicativeFundingRate;
  }

  public String getRebalanceTimestamp() {
    return rebalanceTimestamp;
  }

  public void setRebalanceTimestamp(String rebalanceTimestamp) {
    this.rebalanceTimestamp = rebalanceTimestamp;
  }

  public String getRebalanceInterval() {
    return rebalanceInterval;
  }

  public void setRebalanceInterval(String rebalanceInterval) {
    this.rebalanceInterval = rebalanceInterval;
  }

  public String getOpeningTimestamp() {
    return openingTimestamp;
  }

  public void setOpeningTimestamp(String openingTimestamp) {
    this.openingTimestamp = openingTimestamp;
  }

  public String getClosingTimestamp() {
    return closingTimestamp;
  }

  public void setClosingTimestamp(String closingTimestamp) {
    this.closingTimestamp = closingTimestamp;
  }

  public String getSessionInterval() {
    return sessionInterval;
  }

  public void setSessionInterval(String sessionInterval) {
    this.sessionInterval = sessionInterval;
  }

  public BigDecimal getPrevClosePrice() {
    return prevClosePrice;
  }

  public void setPrevClosePrice(BigDecimal prevClosePrice) {
    this.prevClosePrice = prevClosePrice;
  }

  public BigDecimal getLimitDownPrice() {
    return limitDownPrice;
  }

  public void setLimitDownPrice(BigDecimal limitDownPrice) {
    this.limitDownPrice = limitDownPrice;
  }

  public BigDecimal getLimitUpPrice() {
    return limitUpPrice;
  }

  public void setLimitUpPrice(BigDecimal limitUpPrice) {
    this.limitUpPrice = limitUpPrice;
  }

  public BigDecimal getBankruptLimitDownPrice() {
    return bankruptLimitDownPrice;
  }

  public void setBankruptLimitDownPrice(BigDecimal bankruptLimitDownPrice) {
    this.bankruptLimitDownPrice = bankruptLimitDownPrice;
  }

  public BigDecimal getBankruptLimitUpPrice() {
    return bankruptLimitUpPrice;
  }

  public void setBankruptLimitUpPrice(BigDecimal bankruptLimitUpPrice) {
    this.bankruptLimitUpPrice = bankruptLimitUpPrice;
  }

  public BigDecimal getPrevTotalVolume() {
    return prevTotalVolume;
  }

  public void setPrevTotalVolume(BigDecimal prevTotalVolume) {
    this.prevTotalVolume = prevTotalVolume;
  }

  public BigDecimal getTotalVolume() {
    return totalVolume;
  }

  public void setTotalVolume(BigDecimal totalVolume) {
    this.totalVolume = totalVolume;
  }

  public BigDecimal getVolume() {
    return volume;
  }

  public void setVolume(BigDecimal volume) {
    this.volume = volume;
  }

  public BigDecimal getVolume24h() {
    return volume24h;
  }

  public void setVolume24h(BigDecimal volume24h) {
    this.volume24h = volume24h;
  }

  public BigInteger getPrevTotalTurnover() {
    return prevTotalTurnover;
  }

  public void setPrevTotalTurnover(BigInteger prevTotalTurnover) {
    this.prevTotalTurnover = prevTotalTurnover;
  }

  public BigInteger getTotalTurnover() {
    return totalTurnover;
  }

  public void setTotalTurnover(BigInteger totalTurnover) {
    this.totalTurnover = totalTurnover;
  }

  public BigInteger getTurnover() {
    return turnover;
  }

  public void setTurnover(BigInteger turnover) {
    this.turnover = turnover;
  }

  public BigInteger getTurnover24h() {
    return turnover24h;
  }

  public void setTurnover24h(BigInteger turnover24h) {
    this.turnover24h = turnover24h;
  }

  public BigInteger getPrevPrice24h() {
    return prevPrice24h;
  }

  public void setPrevPrice24h(BigInteger prevPrice24h) {
    this.prevPrice24h = prevPrice24h;
  }

  public BigInteger getVwap() {
    return vwap;
  }

  public void setVwap(BigInteger vwap) {
    this.vwap = vwap;
  }

  public BigDecimal getHighPrice() {
    return highPrice;
  }

  public void setHighPrice(BigDecimal highPrice) {
    this.highPrice = highPrice;
  }

  public BigDecimal getLowPrice() {
    return lowPrice;
  }

  public void setLowPrice(BigDecimal lowPrice) {
    this.lowPrice = lowPrice;
  }

  public BigDecimal getLastPrice() {
    return lastPrice;
  }

  public void setLastPrice(BigDecimal lastPrice) {
    this.lastPrice = lastPrice;
  }

  public BigDecimal getLastPriceProtected() {
    return lastPriceProtected;
  }

  public void setLastPriceProtected(BigDecimal lastPriceProtected) {
    this.lastPriceProtected = lastPriceProtected;
  }

  public String getLastTickDirection() {
    return lastTickDirection;
  }

  public void setLastTickDirection(String lastTickDirection) {
    this.lastTickDirection = lastTickDirection;
  }

  public BigDecimal getLastChangePcnt() {
    return lastChangePcnt;
  }

  public void setLastChangePcnt(BigDecimal lastChangePcnt) {
    this.lastChangePcnt = lastChangePcnt;
  }

  public BigDecimal getBidPrice() {
    return bidPrice;
  }

  public void setBidPrice(BigDecimal bidPrice) {
    this.bidPrice = bidPrice;
  }

  public BigDecimal getMidPrice() {
    return midPrice;
  }

  public void setMidPrice(BigDecimal midPrice) {
    this.midPrice = midPrice;
  }

  public BigDecimal getAskPrice() {
    return askPrice;
  }

  public void setAskPrice(BigDecimal askPrice) {
    this.askPrice = askPrice;
  }

  public BigDecimal getImpactBidPrice() {
    return impactBidPrice;
  }

  public void setImpactBidPrice(BigDecimal impactBidPrice) {
    this.impactBidPrice = impactBidPrice;
  }

  public BigDecimal getImpactMidPrice() {
    return impactMidPrice;
  }

  public void setImpactMidPrice(BigDecimal impactMidPrice) {
    this.impactMidPrice = impactMidPrice;
  }

  public BigDecimal getImpactAskPrice() {
    return impactAskPrice;
  }

  public void setImpactAskPrice(BigDecimal impactAskPrice) {
    this.impactAskPrice = impactAskPrice;
  }

  public Boolean getHasLiquidity() {
    return hasLiquidity;
  }

  public void setHasLiquidity(Boolean hasLiquidity) {
    this.hasLiquidity = hasLiquidity;
  }

  public BigDecimal getOpenInterest() {
    return openInterest;
  }

  public void setOpenInterest(BigDecimal openInterest) {
    this.openInterest = openInterest;
  }

  public BigDecimal getOpenValue() {
    return openValue;
  }

  public void setOpenValue(BigDecimal openValue) {
    this.openValue = openValue;
  }

  public String getFairMethod() {
    return fairMethod;
  }

  public void setFairMethod(String fairMethod) {
    this.fairMethod = fairMethod;
  }

  public BigDecimal getFairBasisRate() {
    return fairBasisRate;
  }

  public void setFairBasisRate(BigDecimal fairBasisRate) {
    this.fairBasisRate = fairBasisRate;
  }

  public BigDecimal getFairBasis() {
    return fairBasis;
  }

  public void setFairBasis(BigDecimal fairBasis) {
    this.fairBasis = fairBasis;
  }

  public BigDecimal getFairPrice() {
    return fairPrice;
  }

  public void setFairPrice(BigDecimal fairPrice) {
    this.fairPrice = fairPrice;
  }

  public String getMarkMethod() {
    return markMethod;
  }

  public void setMarkMethod(String markMethod) {
    this.markMethod = markMethod;
  }

  public BigDecimal getMarkPrice() {
    return markPrice;
  }

  public void setMarkPrice(BigDecimal markPrice) {
    this.markPrice = markPrice;
  }

  public BigDecimal getIndicativeTaxRate() {
    return indicativeTaxRate;
  }

  public void setIndicativeTaxRate(BigDecimal indicativeTaxRate) {
    this.indicativeTaxRate = indicativeTaxRate;
  }

  public BigDecimal getIndicativeSettlePrice() {
    return indicativeSettlePrice;
  }

  public void setIndicativeSettlePrice(BigDecimal indicativeSettlePrice) {
    this.indicativeSettlePrice = indicativeSettlePrice;
  }

  public BigDecimal getSettledPrice() {
    return settledPrice;
  }

  public void setSettledPrice(BigDecimal settledPrice) {
    this.settledPrice = settledPrice;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}
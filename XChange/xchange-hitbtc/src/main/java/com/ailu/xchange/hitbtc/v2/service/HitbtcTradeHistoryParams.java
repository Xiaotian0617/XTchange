package org.knowm.xchange.hitbtc.v2.service;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.service.trade.params.TradeHistoryParamCurrencyPair;
import org.knowm.xchange.service.trade.params.TradeHistoryParamLimit;
import org.knowm.xchange.service.trade.params.TradeHistoryParamOffset;

public class HitbtcTradeHistoryParams implements TradeHistoryParamLimit, TradeHistoryParamOffset, TradeHistoryParamCurrencyPair {

  private CurrencyPair pair;
  private Integer limit;
  private Long offset;

  public HitbtcTradeHistoryParams(CurrencyPair pair, Integer limit, Long offset) {
    this.pair = pair;
    this.limit = limit;
    this.offset = offset;
  }

  @Override
  public void setCurrencyPair(CurrencyPair pair) {
    this.pair = pair;
  }

  @Override
  public CurrencyPair getCurrencyPair() {
    return pair;
  }

  @Override
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  @Override
  public Integer getLimit() {
    return limit;
  }

  @Override
  public void setOffset(Long offset) {
    this.offset = offset;
  }

  @Override
  public Long getOffset() {
    return offset;
  }
}

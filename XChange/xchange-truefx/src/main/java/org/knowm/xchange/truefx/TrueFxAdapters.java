package org.knowm.xchange.truefx;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.truefx.dto.marketdata.TrueFxTicker;
import org.knowm.xchange.utils.jackson.CurrencyPairDeserializer;

import java.util.Date;

public class TrueFxAdapters {
  public static Ticker adaptTicker(TrueFxTicker rawTicker) {
    Date timestamp = new Date(rawTicker.getTimestamp());
    CurrencyPair pair = CurrencyPairDeserializer.getCurrencyPairFromString(rawTicker.getPair());
    return new Ticker.Builder().currencyPair(pair).timestamp(timestamp).bid(rawTicker.calcBid()).ask(rawTicker.calcAsk()).high(rawTicker.getHigh())
        .low(rawTicker.getLow()).build();
  }
}

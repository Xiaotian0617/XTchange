package com.ailu.bitmex.bean.marketdata.results;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class BitmexSymbolsAndPromptsResult<V> {

  private final V intervals;
  private final V symbols;

  /**
   * Constructor
   *
   * @param intervals
   * @param symbols
   */

  public BitmexSymbolsAndPromptsResult(@JSONField(name = "intervals") V intervals, @JSONField(name = "symbols") V symbols) {

    this.intervals = intervals;
    this.symbols = symbols;
  }

  public boolean isSuccess() {

    return symbols.toString().length() != 0;
  }

  public List<V> getIntervals() {

    return (List<V>) intervals;

  }

  public List<V> getSymbols() {

    return (List<V>) symbols;
  }

  @Override
  public String toString() {

    return String.format("BitmexSymbolsAndPromptsResult[%s: %s]", isSuccess() ? "OK" : "error", isSuccess() ? intervals.toString() + " / " + symbols.toString() : "error");
  }

}

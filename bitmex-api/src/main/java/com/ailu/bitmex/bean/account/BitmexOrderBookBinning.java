package com.ailu.bitmex.bean.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.Map;

public final class BitmexOrderBookBinning {

  @JSONField(serialize = false)
  private Map<String, Object> additionalProperties = new HashMap<>();

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}
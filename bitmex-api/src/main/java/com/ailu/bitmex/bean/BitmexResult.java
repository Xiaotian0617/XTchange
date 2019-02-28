package com.ailu.bitmex.bean;

/**
 * @author Raphael Voellmy
 */
public class BitmexResult {

  private Long XRateLimitLimit;

  private Long XRateLimitRemaining;

  private Long XRateLimitReset;

  private Object data;

  public Long getXRateLimitLimit() {
    return XRateLimitLimit;
  }

  public void setXRateLimitLimit(Long XRateLimitLimit) {
    this.XRateLimitLimit = XRateLimitLimit;
  }

  public Long getXRateLimitRemaining() {
    return XRateLimitRemaining;
  }

  public void setXRateLimitRemaining(Long XRateLimitRemaining) {
    this.XRateLimitRemaining = XRateLimitRemaining;
  }

  public Long getXRateLimitReset() {
    return XRateLimitReset;
  }

  public void setXRateLimitReset(Long XRateLimitReset) {
    this.XRateLimitReset = XRateLimitReset;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}

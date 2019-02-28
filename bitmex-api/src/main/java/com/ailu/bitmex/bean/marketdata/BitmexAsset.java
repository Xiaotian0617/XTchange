package com.ailu.bitmex.bean.marketdata;

import com.alibaba.fastjson.annotation.JSONField;

public class BitmexAsset {

  private final String altName;
  private final String assetClass;
  private final int scale;
  private final int displayScale;

  /**
   * Constructor
   *
   * @param altName
   * @param assetClass
   * @param scale
   * @param displayScale
   */
  public BitmexAsset(@JSONField(name = "altname") String altName, @JSONField(name = "aclass") String assetClass, @JSONField(name = "decimals") int scale,
                     @JSONField(name = "display_decimals") int displayScale) {

    this.altName = altName;
    this.assetClass = assetClass;
    this.scale = scale;
    this.displayScale = displayScale;
  }

  public String getAltName() {

    return altName;
  }

  public String getAssetClass() {

    return assetClass;
  }

  public int getScale() {

    return scale;
  }

  public int getDisplayScale() {

    return displayScale;
  }

  @Override
  public String toString() {

    return "KrakenAssetInfo [altName=" + altName + ", assetClass=" + assetClass + ", scale=" + scale + ", displayScale=" + displayScale + "]";
  }
}

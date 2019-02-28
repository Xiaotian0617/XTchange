package com.ailu.bitmex.bean.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BitmexAccountPreferences {

  @JSONField(name = "alertOnLiquidations")
  private Boolean alertOnLiquidations;
  @JSONField(name = "animationsEnabled")
  private Boolean animationsEnabled;
  @JSONField(name = "announcementsLastSeen")
  private String announcementsLastSeen;
  @JSONField(name = "chatChannelID")
  private Integer chatChannelID;
  @JSONField(name = "colorTheme")
  private String colorTheme;
  @JSONField(name = "currency")
  private String currency;
  @JSONField(name = "debug")
  private Boolean debug;
  @JSONField(name = "disableEmails")
  private List<String> disableEmails = null;
  @JSONField(name = "hideConfirmDialogs")
  private List<String> hideConfirmDialogs = null;
  @JSONField(name = "hideConnectionModal")
  private Boolean hideConnectionModal;
  @JSONField(name = "hideFromLeaderboard")
  private Boolean hideFromLeaderboard;
  @JSONField(name = "hideNameFromLeaderboard")
  private Boolean hideNameFromLeaderboard;
  @JSONField(name = "hideNotifications")
  private List<String> hideNotifications = null;
  @JSONField(name = "locale")
  private String locale;
  @JSONField(name = "msgsSeen")
  private List<String> msgsSeen = null;
  @JSONField(name = "orderBookBinning")
  private BitmexOrderBookBinning orderBookBinning;
  @JSONField(name = "orderBookType")
  private String orderBookType;
  @JSONField(name = "orderClearImmediate")
  private Boolean orderClearImmediate;
  @JSONField(name = "orderControlsPlusMinus")
  private Boolean orderControlsPlusMinus;
  @JSONField(name = "showLocaleNumbers")
  private Boolean showLocaleNumbers;
  @JSONField(name = "sounds")
  private List<String> sounds = null;
  @JSONField(name = "strictIPCheck")
  private Boolean strictIPCheck;
  @JSONField(name = "strictTimeout")
  private Boolean strictTimeout;
  @JSONField(name = "tickerGroup")
  private String tickerGroup;
  @JSONField(name = "tickerPinned")
  private Boolean tickerPinned;
  @JSONField(name = "tradeLayout")
  private String tradeLayout;
  @JSONField(serialize = false)
  private Map<String, Object> additionalProperties = new HashMap<>();

  public Boolean getAlertOnLiquidations() {
    return alertOnLiquidations;
  }

  public void setAlertOnLiquidations(Boolean alertOnLiquidations) {
    this.alertOnLiquidations = alertOnLiquidations;
  }

  public Boolean getAnimationsEnabled() {
    return animationsEnabled;
  }

  public void setAnimationsEnabled(Boolean animationsEnabled) {
    this.animationsEnabled = animationsEnabled;
  }

  public String getAnnouncementsLastSeen() {
    return announcementsLastSeen;
  }

  public void setAnnouncementsLastSeen(String announcementsLastSeen) {
    this.announcementsLastSeen = announcementsLastSeen;
  }

  public Integer getChatChannelID() {
    return chatChannelID;
  }

  public void setChatChannelID(Integer chatChannelID) {
    this.chatChannelID = chatChannelID;
  }

  public String getColorTheme() {
    return colorTheme;
  }

  public void setColorTheme(String colorTheme) {
    this.colorTheme = colorTheme;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Boolean getDebug() {
    return debug;
  }

  public void setDebug(Boolean debug) {
    this.debug = debug;
  }

  public List<String> getDisableEmails() {
    return disableEmails;
  }

  public void setDisableEmails(List<String> disableEmails) {
    this.disableEmails = disableEmails;
  }

  public List<String> getHideConfirmDialogs() {
    return hideConfirmDialogs;
  }

  public void setHideConfirmDialogs(List<String> hideConfirmDialogs) {
    this.hideConfirmDialogs = hideConfirmDialogs;
  }

  public Boolean getHideConnectionModal() {
    return hideConnectionModal;
  }

  public void setHideConnectionModal(Boolean hideConnectionModal) {
    this.hideConnectionModal = hideConnectionModal;
  }

  public Boolean getHideFromLeaderboard() {
    return hideFromLeaderboard;
  }

  public void setHideFromLeaderboard(Boolean hideFromLeaderboard) {
    this.hideFromLeaderboard = hideFromLeaderboard;
  }

  public Boolean getHideNameFromLeaderboard() {
    return hideNameFromLeaderboard;
  }

  public void setHideNameFromLeaderboard(Boolean hideNameFromLeaderboard) {
    this.hideNameFromLeaderboard = hideNameFromLeaderboard;
  }

  public List<String> getHideNotifications() {
    return hideNotifications;
  }

  public void setHideNotifications(List<String> hideNotifications) {
    this.hideNotifications = hideNotifications;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public List<String> getMsgsSeen() {
    return msgsSeen;
  }

  public void setMsgsSeen(List<String> msgsSeen) {
    this.msgsSeen = msgsSeen;
  }

  public BitmexOrderBookBinning getOrderBookBinning() {
    return orderBookBinning;
  }

  public void setOrderBookBinning(BitmexOrderBookBinning orderBookBinning) {
    this.orderBookBinning = orderBookBinning;
  }

  public String getOrderBookType() {
    return orderBookType;
  }

  public void setOrderBookType(String orderBookType) {
    this.orderBookType = orderBookType;
  }

  public Boolean getOrderClearImmediate() {
    return orderClearImmediate;
  }

  public void setOrderClearImmediate(Boolean orderClearImmediate) {
    this.orderClearImmediate = orderClearImmediate;
  }

  public Boolean getOrderControlsPlusMinus() {
    return orderControlsPlusMinus;
  }

  public void setOrderControlsPlusMinus(Boolean orderControlsPlusMinus) {
    this.orderControlsPlusMinus = orderControlsPlusMinus;
  }

  public Boolean getShowLocaleNumbers() {
    return showLocaleNumbers;
  }

  public void setShowLocaleNumbers(Boolean showLocaleNumbers) {
    this.showLocaleNumbers = showLocaleNumbers;
  }

  public List<String> getSounds() {
    return sounds;
  }

  public void setSounds(List<String> sounds) {
    this.sounds = sounds;
  }

  public Boolean getStrictIPCheck() {
    return strictIPCheck;
  }

  public void setStrictIPCheck(Boolean strictIPCheck) {
    this.strictIPCheck = strictIPCheck;
  }

  public Boolean getStrictTimeout() {
    return strictTimeout;
  }

  public void setStrictTimeout(Boolean strictTimeout) {
    this.strictTimeout = strictTimeout;
  }

  public String getTickerGroup() {
    return tickerGroup;
  }

  public void setTickerGroup(String tickerGroup) {
    this.tickerGroup = tickerGroup;
  }

  public Boolean getTickerPinned() {
    return tickerPinned;
  }

  public void setTickerPinned(Boolean tickerPinned) {
    this.tickerPinned = tickerPinned;
  }

  public String getTradeLayout() {
    return tradeLayout;
  }

  public void setTradeLayout(String tradeLayout) {
    this.tradeLayout = tradeLayout;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}

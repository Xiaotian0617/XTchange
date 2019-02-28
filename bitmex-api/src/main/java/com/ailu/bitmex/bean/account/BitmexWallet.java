package com.ailu.bitmex.bean.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BitmexWallet {

  @JSONField(name = "account")
  private Integer account;
  @JSONField(name = "currency")
  private String currency;
  @JSONField(name = "prevDeposited")
  private BigDecimal prevDeposited;
  @JSONField(name = "prevWithdrawn")
  private BigDecimal prevWithdrawn;
  @JSONField(name = "prevTransferIn")
  private BigDecimal prevTransferIn;
  @JSONField(name = "prevTransferOut")
  private BigDecimal prevTransferOut;
  @JSONField(name = "prevAmount")
  private BigDecimal prevAmount;
  @JSONField(name = "prevTimestamp")
  private String prevTimestamp;
  @JSONField(name = "deltaDeposited")
  private BigDecimal deltaDeposited;
  @JSONField(name = "deltaWithdrawn")
  private BigDecimal deltaWithdrawn;
  @JSONField(name = "deltaTransferIn")
  private BigDecimal deltaTransferIn;
  @JSONField(name = "deltaTransferOut")
  private BigDecimal deltaTransferOut;
  @JSONField(name = "deltaAmount")
  private BigDecimal deltaAmount;
  @JSONField(name = "deposited")
  private BigDecimal deposited;
  @JSONField(name = "withdrawn")
  private BigDecimal withdrawn;
  @JSONField(name = "transferIn")
  private BigDecimal transferIn;
  @JSONField(name = "transferOut")
  private BigDecimal transferOut;
  @JSONField(name = "amount")
  private BigDecimal amount;
  @JSONField(name = "pendingCredit")
  private BigDecimal pendingCredit;
  @JSONField(name = "pendingDebit")
  private BigDecimal pendingDebit;
  @JSONField(name = "confirmedDebit")
  private BigDecimal confirmedDebit;
  @JSONField(name = "timestamp")
  private String timestamp;
  @JSONField(name = "addr")
  private String addr;
  @JSONField(name = "script")
  private String script;
  @JSONField(name = "withdrawalLock")
  private List<String> withdrawalLock = null;
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

  public BigDecimal getPrevDeposited() {
    return prevDeposited;
  }

  public void setPrevDeposited(BigDecimal prevDeposited) {
    this.prevDeposited = prevDeposited;
  }

  public BigDecimal getPrevWithdrawn() {
    return prevWithdrawn;
  }

  public void setPrevWithdrawn(BigDecimal prevWithdrawn) {
    this.prevWithdrawn = prevWithdrawn;
  }

  public BigDecimal getPrevTransferIn() {
    return prevTransferIn;
  }

  public void setPrevTransferIn(BigDecimal prevTransferIn) {
    this.prevTransferIn = prevTransferIn;
  }

  public BigDecimal getPrevTransferOut() {
    return prevTransferOut;
  }

  public void setPrevTransferOut(BigDecimal prevTransferOut) {
    this.prevTransferOut = prevTransferOut;
  }

  public BigDecimal getPrevAmount() {
    return prevAmount;
  }

  public void setPrevAmount(BigDecimal prevAmount) {
    this.prevAmount = prevAmount;
  }

  public String getPrevTimestamp() {
    return prevTimestamp;
  }

  public void setPrevTimestamp(String prevTimestamp) {
    this.prevTimestamp = prevTimestamp;
  }

  public BigDecimal getDeltaDeposited() {
    return deltaDeposited;
  }

  public void setDeltaDeposited(BigDecimal deltaDeposited) {
    this.deltaDeposited = deltaDeposited;
  }

  public BigDecimal getDeltaWithdrawn() {
    return deltaWithdrawn;
  }

  public void setDeltaWithdrawn(BigDecimal deltaWithdrawn) {
    this.deltaWithdrawn = deltaWithdrawn;
  }

  public BigDecimal getDeltaTransferIn() {
    return deltaTransferIn;
  }

  public void setDeltaTransferIn(BigDecimal deltaTransferIn) {
    this.deltaTransferIn = deltaTransferIn;
  }

  public BigDecimal getDeltaTransferOut() {
    return deltaTransferOut;
  }

  public void setDeltaTransferOut(BigDecimal deltaTransferOut) {
    this.deltaTransferOut = deltaTransferOut;
  }

  public BigDecimal getDeltaAmount() {
    return deltaAmount;
  }

  public void setDeltaAmount(BigDecimal deltaAmount) {
    this.deltaAmount = deltaAmount;
  }

  public BigDecimal getDeposited() {
    return deposited;
  }

  public void setDeposited(BigDecimal deposited) {
    this.deposited = deposited;
  }

  public BigDecimal getWithdrawn() {
    return withdrawn;
  }

  public void setWithdrawn(BigDecimal withdrawn) {
    this.withdrawn = withdrawn;
  }

  public BigDecimal getTransferIn() {
    return transferIn;
  }

  public void setTransferIn(BigDecimal transferIn) {
    this.transferIn = transferIn;
  }

  public BigDecimal getTransferOut() {
    return transferOut;
  }

  public void setTransferOut(BigDecimal transferOut) {
    this.transferOut = transferOut;
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

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getScript() {
    return script;
  }

  public void setScript(String script) {
    this.script = script;
  }

  public List<String> getWithdrawalLock() {
    return withdrawalLock;
  }

  public void setWithdrawalLock(List<String> withdrawalLock) {
    this.withdrawalLock = withdrawalLock;
  }

  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }
}
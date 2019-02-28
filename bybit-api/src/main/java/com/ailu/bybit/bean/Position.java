package com.ailu.bybit.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class Position {


    /**
     * id : 1
     * user_id : 1
     * risk_id : 1
     * symbol : BTCUSD
     * side : None
     * size : 0
     * position_value : 0
     * entry_price : 0
     * leverage : 1
     * auto_add_margin : 0
     * position_margin : 0
     * liq_price : 999999
     * bust_price : 999999
     * occ_closing_fee : 0
     * take_profit : 0
     * stop_loss : 0
     * trailing_stop : 0
     * position_status : Normal
     * deleverage_indicator : 1
     * oc_calc_data : {'blq':'0','bmp':'0','slq':'0','smp':'0'}
     * order_margin : 0
     * wallet_balance : 0
     * unrealised_pnl : 0
     * realised_pnl : 0
     * cum_realised_pnl : 0
     * cum_commission : 0
     * cross_seq : 0
     * position_seq : 2
     * created_at : 2018-10-18T07:15:51.000Z
     * updated_at : 2018-10-20T13:43:21.000Z
     */

    @JSONField(name = "id")
    private Long id;
    @JSONField(name = "user_id")
    private Long userId;
    @JSONField(name = "risk_id")
    private Long riskId;
    @JSONField(name = "symbol")
    private String symbol;
    @JSONField(name = "side")
    private String side;
    @JSONField(name = "size")
    private BigDecimal size;
    @JSONField(name = "position_value")
    private BigDecimal positionValue;
    @JSONField(name = "entry_price")
    private BigDecimal entryPrice;
    @JSONField(name = "leverage")
    private int leverage;
    @JSONField(name = "auto_add_margin")
    private int autoAddMargin;
    @JSONField(name = "position_margin")
    private BigDecimal positionMargin;
    @JSONField(name = "liq_price")
    private BigDecimal liqPrice;
    @JSONField(name = "bust_price")
    private BigDecimal bustPrice;
    @JSONField(name = "occ_closing_fee")
    private BigDecimal occClosingFee;
    @JSONField(name = "take_profit")
    private BigDecimal takeProfit;
    @JSONField(name = "stop_loss")
    private BigDecimal stopLoss;
    @JSONField(name = "trailing_stop")
    private BigDecimal trailingStop;
    @JSONField(name = "position_status")
    private String positionStatus;
    @JSONField(name = "deleverage_indicator")
    private int deleverageIndicator;
    @JSONField(name = "oc_calc_data")
    private String ocCalcData;
    @JSONField(name = "order_margin")
    private BigDecimal orderMargin;
    @JSONField(name = "wallet_balance")
    private BigDecimal walletBalance;
    @JSONField(name = "unrealised_pnl")
    private BigDecimal unrealisedPnl;
    @JSONField(name = "realised_pnl")
    private BigDecimal realisedPnl;
    @JSONField(name = "cum_realised_pnl")
    private BigDecimal cumRealisedPnl;
    @JSONField(name = "cum_commission")
    private BigDecimal cumCommission;
    @JSONField(name = "cross_seq")
    private int crossSeq;
    @JSONField(name = "position_seq")
    private int positionSeq;
    @JSONField(name = "created_at")
    private String createdAt;
    @JSONField(name = "updated_at")
    private String updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRiskId() {
        return riskId;
    }

    public void setRiskId(Long riskId) {
        this.riskId = riskId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(BigDecimal positionValue) {
        this.positionValue = positionValue;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
    }

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
    }

    public int getAutoAddMargin() {
        return autoAddMargin;
    }

    public void setAutoAddMargin(int autoAddMargin) {
        this.autoAddMargin = autoAddMargin;
    }

    public BigDecimal getPositionMargin() {
        return positionMargin;
    }

    public void setPositionMargin(BigDecimal positionMargin) {
        this.positionMargin = positionMargin;
    }

    public BigDecimal getLiqPrice() {
        return liqPrice;
    }

    public void setLiqPrice(BigDecimal liqPrice) {
        this.liqPrice = liqPrice;
    }

    public BigDecimal getBustPrice() {
        return bustPrice;
    }

    public void setBustPrice(BigDecimal bustPrice) {
        this.bustPrice = bustPrice;
    }

    public BigDecimal getOccClosingFee() {
        return occClosingFee;
    }

    public void setOccClosingFee(BigDecimal occClosingFee) {
        this.occClosingFee = occClosingFee;
    }

    public BigDecimal getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(BigDecimal takeProfit) {
        this.takeProfit = takeProfit;
    }

    public BigDecimal getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(BigDecimal stopLoss) {
        this.stopLoss = stopLoss;
    }

    public BigDecimal getTrailingStop() {
        return trailingStop;
    }

    public void setTrailingStop(BigDecimal trailingStop) {
        this.trailingStop = trailingStop;
    }

    public String getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    public int getDeleverageIndicator() {
        return deleverageIndicator;
    }

    public void setDeleverageIndicator(int deleverageIndicator) {
        this.deleverageIndicator = deleverageIndicator;
    }

    public String getOcCalcData() {
        return ocCalcData;
    }

    public void setOcCalcData(String ocCalcData) {
        this.ocCalcData = ocCalcData;
    }

    public BigDecimal getOrderMargin() {
        return orderMargin;
    }

    public void setOrderMargin(BigDecimal orderMargin) {
        this.orderMargin = orderMargin;
    }

    public BigDecimal getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(BigDecimal walletBalance) {
        this.walletBalance = walletBalance;
    }

    public BigDecimal getUnrealisedPnl() {
        return unrealisedPnl;
    }

    public void setUnrealisedPnl(BigDecimal unrealisedPnl) {
        this.unrealisedPnl = unrealisedPnl;
    }

    public BigDecimal getRealisedPnl() {
        return realisedPnl;
    }

    public void setRealisedPnl(BigDecimal realisedPnl) {
        this.realisedPnl = realisedPnl;
    }

    public BigDecimal getCumRealisedPnl() {
        return cumRealisedPnl;
    }

    public void setCumRealisedPnl(BigDecimal cumRealisedPnl) {
        this.cumRealisedPnl = cumRealisedPnl;
    }

    public BigDecimal getCumCommission() {
        return cumCommission;
    }

    public void setCumCommission(BigDecimal cumCommission) {
        this.cumCommission = cumCommission;
    }

    public int getCrossSeq() {
        return crossSeq;
    }

    public void setCrossSeq(int crossSeq) {
        this.crossSeq = crossSeq;
    }

    public int getPositionSeq() {
        return positionSeq;
    }

    public void setPositionSeq(int positionSeq) {
        this.positionSeq = positionSeq;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}

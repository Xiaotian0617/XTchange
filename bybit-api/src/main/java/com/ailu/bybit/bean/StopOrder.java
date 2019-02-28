package com.ailu.bybit.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

public class StopOrder {

    /**
     * stop_order_id : string
     * user_id : 0
     * 户ID                     'stop_order_status' : string
     * symbol : string
     * side : string
     * order_type : string
     * price : 0
     * qty : 0
     * time_in_force : string
     * stop_order_type : string
     * base_price : 0
     * stop_px : 0
     * order_link_id : string
     * created_at : 2018-10-15T04:12:19.000Z
     * updated_at : 2018-10-15T04:12:19.000Z
     */

    @JSONField(name = "stop_order_id")
    private String stopOrderId;
    @JSONField(name = "user_id")
    private Long userId;
    @JSONField(name = "户ID                     'stop_order_status'")
    private String _$IDStopOrderStatus25; // FIXME check this code
    @JSONField(name = "symbol")
    private String symbol;
    @JSONField(name = "side")
    private String side;
    @JSONField(name = "order_type")
    private String orderType;
    @JSONField(name = "price")
    private BigDecimal price;
    @JSONField(name = "qty")
    private BigDecimal qty;
    @JSONField(name = "time_in_force")
    private String timeInForce;
    @JSONField(name = "stop_order_type")
    private String stopOrderType;
    @JSONField(name = "base_price")
    private BigDecimal basePrice;
    @JSONField(name = "stop_px")
    private BigDecimal stopPx;
    @JSONField(name = "order_link_id")
    private String orderLinkId;
    @JSONField(name = "created_at")
    private Date createdAt;
    @JSONField(name = "updated_at")
    private Date updatedAt;

    public String getStopOrderId() {
        return stopOrderId;
    }

    public void setStopOrderId(String stopOrderId) {
        this.stopOrderId = stopOrderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String get_$IDStopOrderStatus25() {
        return _$IDStopOrderStatus25;
    }

    public void set_$IDStopOrderStatus25(String _$IDStopOrderStatus25) {
        this._$IDStopOrderStatus25 = _$IDStopOrderStatus25;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getStopOrderType() {
        return stopOrderType;
    }

    public void setStopOrderType(String stopOrderType) {
        this.stopOrderType = stopOrderType;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getStopPx() {
        return stopPx;
    }

    public void setStopPx(BigDecimal stopPx) {
        this.stopPx = stopPx;
    }

    public String getOrderLinkId() {
        return orderLinkId;
    }

    public void setOrderLinkId(String orderLinkId) {
        this.orderLinkId = orderLinkId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

package com.ailu.bitmex.bean.marketdata;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * [
 * {
 * "account": 774257,
 * "symbol": "XBTUSD",
 * "currency": "XBt",
 * "underlying": "XBT",
 * "quoteCurrency": "USD",
 * "commission": 0.00075,
 * "initMarginReq": 1,
 * "maintMarginReq": 0.005,
 * "riskLimit": 20000000000,
 * "leverage": 1,
 * "crossMargin": false,
 * "deleveragePercentile": 1,
 * "rebalancedPnl": -169,
 * "prevRealisedPnl": -5002228,
 * "prevUnrealisedPnl": 0,
 * "prevClosePrice": 3664.91,
 * "openingTimestamp": "2019-01-15T09:00:00.000Z",
 * "openingQty": -16,
 * "openingCost": 444596,
 * "openingComm": 327,
 * "openOrderBuyQty": 12,
 * "openOrderBuyCost": -361112,
 * "openOrderBuyPremium": 0,
 * "openOrderSellQty": 0,
 * "openOrderSellCost": 0,
 * "openOrderSellPremium": 0,
 * "execBuyQty": 3,
 * "execBuyCost": 81926,
 * "execSellQty": 1,
 * "execSellCost": 27289,
 * "execQty": 2,
 * "execCost": -54637,
 * "execComm": 80,
 * "currentTimestamp": "2019-01-15T09:44:31.012Z",
 * "currentQty": -14,
 * "currentCost": 389959,
 * "currentComm": 407,
 * "realisedCost": 2145,
 * "unrealisedCost": 387814,
 * "grossOpenCost": 0,
 * "grossOpenPremium": 0,
 * "grossExecCost": 0,
 * "isOpen": true,
 * "markPrice": 3634.35,
 * "markValue": 385210,
 * "riskValue": 385210,
 * "homeNotional": -0.0038521,
 * "foreignNotional": 14,
 * "posState": "",
 * "posCost": 387814,
 * "posCost2": 387893,
 * "posCross": 0,
 * "posInit": 387814,
 * "posComm": 0,
 * "posLoss": 79,
 * "posMargin": 387735,
 * "posMaint": 0,
 * "posAllowance": 0,
 * "taxableMargin": 0,
 * "initMargin": 0,
 * "maintMargin": 385131,
 * "sessionMargin": 0,
 * "targetExcessMargin": 0,
 * "varMargin": 0,
 * "realisedGrossPnl": -2145,
 * "realisedTax": 0,
 * "realisedPnl": -2552,
 * "unrealisedGrossPnl": -2604,
 * "longBankrupt": 0,
 * "shortBankrupt": 0,
 * "taxBase": 0,
 * "indicativeTaxRate": 0,
 * "indicativeTax": 0,
 * "unrealisedTax": 0,
 * "unrealisedPnl": -2604,
 * "unrealisedPnlPcnt": -0.0067,
 * "unrealisedRoePcnt": -0.0067,
 * "simpleQty": null,
 * "simpleCost": null,
 * "simpleValue": null,
 * "simplePnl": null,
 * "simplePnlPcnt": null,
 * "avgCostPrice": 3610,
 * "avgEntryPrice": 3610,
 * "breakEvenPrice": 3584.5,
 * "marginCallPrice": 16666666.5,
 * "liquidationPrice": 16666666.5,
 * "bankruptPrice": 16666666.5,
 * "timestamp": "2019-01-15T09:44:31.012Z",
 * "lastPrice": 3634.35,
 * "lastValue": 385210
 * }
 * ]
 */
public class BitmexPrivateOrder {

    @JSONField(name = "ordType") String ordType;
    @JSONField(name = "price") BigDecimal price;
    @JSONField(name = "orderID") String id;
    @JSONField(name = "orderQty") BigDecimal size;
    @JSONField(name = "side") String side;
    @JSONField(name = "symbol") String symbol;
    @JSONField(name = "timestamp") Date timestamp;
    @JSONField(name = "ordStatus") String orderStatus;
    @JSONField(name = "currency") String currency;
    @JSONField(name = "settlCurrency") String settleCurrency;
    @JSONField(name = "cumQty") BigDecimal cumQty;
    @JSONField(name = "avgPx") BigDecimal avgPx;


    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSettleCurrency() {
        return settleCurrency;
    }

    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency;
    }

    public BigDecimal getCumQty() {
        return cumQty;
    }

    public void setCumQty(BigDecimal cumQty) {
        this.cumQty = cumQty;
    }

    public BigDecimal getAvgPx() {
        return avgPx;
    }

    public void setAvgPx(BigDecimal avgPx) {
        this.avgPx = avgPx;
    }
}

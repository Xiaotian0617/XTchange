package com.ailu.bybit.bean;

import com.ailu.bybit.utils.DateUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.math.BigDecimal;

/**
 * NOTE:
 * 成交记录
 * {
 *     "account": "binance/test_account",                  # 账户名
 *     "contract": "binance/ltc.usdt",                     # 合约标识
 *     "bs": "b",                                          # "b"对应买或"s"对应卖
 *     "client_oid": "binance/ltc.usdt-xxx123",            # 由用户给定或由OneToken系统生成的订单追踪ID
 *     "exchange_oid": "binance/ltc.usdt-xxx456",          # 由交易所生成的订单追踪ID
 *     "exchange_tid": "binance/ltc.usdt-xxx789",          # 由交易所生成的成交ID
 *     "dealt_amount": 1,                                  # 成交数量
 *     "dealt_price": 0,                                   # 成交价格
 *     "dealt_time": "2018-04-03T12:22:56+08:00",          # 成交时间
 *     "dealt_type": "maker",                              # 主动成交"taker"、被动成交"maker"
 *     "commission": 0.0025,                               # 成交手续费
 *     "commission_currency": "ltc",                       # 手续费币种
 *     "tags": {}                                          #
 * }
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:57
 */
@Data
public class Trans {


    /**
     * account : binance/test_account
     * contract : binance/ltc.usdt
     * bs : b
     * client_oid : binance/ltc.usdt-xxx123
     * exchange_oid : binance/ltc.usdt-xxx456
     * exchange_tid : binance/ltc.usdt-xxx789
     * dealt_amount : 1
     * dealt_price : 0
     * dealt_time : 2018-04-03T12:22:56+08:00
     * dealt_type : maker
     * commission : 0.0025
     * commission_currency : ltc
     * tags : {}
     */

    /**
     * 账户
     */
    private String account;
    /**
     * 交易标的
     */
    private String contract;
    /**
     * 买卖方向
     */
    private String bs;
    /**
     * 用户定义的订单号
     */
    private String clientOid;
    /**
     * 交易所生成的订单号
     */
    private String exchangeOid;
    /**
     * 交易所生成的成交ID
     */
    private String exchangeTid;
    /**
     * 成交数量
     */
    private BigDecimal dealtAmount;
    /**
     * 成交价格
     */
    private BigDecimal dealtPrice;
    /**
     * 成交时间
     */
    private String dealtTime;
    /**
     * maker（限价单） 或 taker （市价单）
     */
    private String dealtType;
    /**
     * 手续费
     */
    private BigDecimal commission;
    /**
     * 手续费币种
     */
    private String commissionCurrency;
    private JSONObject tags;

    public String getDealtTime() {
        return DateUtils.parse1TokenTime2ToLongStr(dealtTime);
    }
}

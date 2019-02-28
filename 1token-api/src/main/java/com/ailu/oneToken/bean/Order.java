package com.ailu.oneToken.bean;

import com.ailu.oneToken.utils.DateUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * NOTE:
 *  OneToken 订单列表
 *  {
 *     "account": "binance/test_account",              # 账户名
 *     "contract": "binance/ltc.usdt",                 # 合约标识
 *     "bs": "b",                                      # "b"对应买或"s"对应卖
 *     "client_oid": "binance/ltc.usdt-xxx123",        # 由用户给定或由OneToken系统生成的订单追踪ID
 *     "exchange_oid": "binance/ltc.usdt-xxx456",      # 由交易所生成的订单追踪ID
 *     "status": "part-deal-pending",                  # 订单状态
 *     "entrust_price": 113,                           # 委托价格
 *     "entrust_amount": 10,                           # 委托数量
 *     "entrust_time": "2018-04-03T12:21:13+08:00",    # 下单时间
 *     "average_dealt_price": 112.1,                   # 平均成交价
 *     "dealt_amount": 1,                              # 成交数量
 *     "last_dealed_amount": 0.8,                      # 最近一次成交数量
 *     "commission": 0.0025,                           # 成交手续费
 *     "last_update": "2018-04-03T12:22:56+08:00",     # 最近更新时间
 *     "canceled_time": None,                          # 撤单时间
 *     "options": {},                                  #
 *     "comment": "string",                            #
 *     "tags": {}                                      #
 * }
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:31
 */
@Data
public class Order {

    /**
     * 账号
     */
    private String account;

    /**
     * 平均成交价
     */
    private BigDecimal average_dealt_price;

    /**
     * 买卖方向
     */
    private String bs;

    /**
     * 用户定义的订单号
     */
    private String client_oid;

    /**
     * 订单附加信息
     */
    private String comment;

    /**
     * 手续费
     */
    private BigDecimal commission;

    /**
     * 文档缺失
     */
    private String contract;

    /**
     * 成交数量
     */
    private BigDecimal dealt_amount;

    /**
     * 委托数量
     */
    private BigDecimal entrust_amount;

    /**
     * 委托价格
     */
    private BigDecimal entrust_price;

    /**
     * 委托时间
     */
    private String entrust_time;

    /**
     * 交易所生成订单号
     */
    private String exchange_oid;

    /**
     * 最近一次成交数量
     */
    private BigDecimal last_dealt_amount;

    /**
     * 订单在交易所成功撤单的时间,交易所返回的数据不包含这项则为空
     */
    private String canceled_time;

    /**
     * 订单在交易所变为end状态的时间,交易所返回的数据不包含这项则为空
     */
    private String closed_time;

    /**
     * Onetoken系统检测到订单状态变为end状态的时间
     */
    private String ots_closed_time;

    /**
     * 订单最近一次在OneToken系统更新的时间
     */
    private String last_update;

    /**
     * 订单最近一次在交易所更新的时间,交易所返回的数据不包含这项则为空
     */
    private String exchange_update;

    /**
     * 文档缺失
     */
    private List<Object> options;

    /**
     * 订单状态包括
     *
     * active (激活中的订单，在交易所没有明确状态的情况下返回，代表以下任意一种)
     *
     * waiting (onetoken 系统已经收到下单请求, 并正在发送给交易所等待交易所返回)
     * pending (已经收到交易所返回，等待成交)
     * part-deal-pending (已经部分成交并继续等待中)
     * withdrawing (撤单请求已经发送给交易所并得到交易所返回，等待交易所完全把订单从交易所撮合系统中删除)
     * part-deal-withdrawing (已经部分成交并等待撤单)
     * end （已经结束的订单，在交易所没有明确状态的情况下返回，代表以下任意一种）
     *
     * dealt(订单完全成交)
     * withdrawn (订单已撤销没有成交)
     * part-deal-withdrawn(已经部分成交并且已经撤单)
     * error-order (错误订单)
     */
    private String status;

    /**
     * [ waiting, pending, part-deal-pending, withdrawing, part-deal-withdrawing, active, dealt, withdrawn, part-deal-withdrawn, error-order, end ]
     */
    private String tags;

    public String getEntrust_time() {
        return DateUtils.parse1TokenTime1ToLongStr(entrust_time);
    }

    public String getCanceled_time() {
        return DateUtils.parse1TokenTime1ToLongStr(canceled_time);
    }

    public String getClosed_time() {
        return DateUtils.parse1TokenTime1ToLongStr(closed_time);
    }

    public String getOts_closed_time() {
        return DateUtils.parse1TokenTime1ToLongStr(ots_closed_time);
    }

    public String getLast_update() {
        return DateUtils.parse1TokenTime2ToLongStr(last_update);
    }
}

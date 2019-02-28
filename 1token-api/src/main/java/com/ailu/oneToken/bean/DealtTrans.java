package com.ailu.oneToken.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * NOTE:
 *  OneToken 成交历史
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:41
 */
@Data
public class DealtTrans {

    /**
     * 账号
     */
    private String account;

    /**
     * 买卖方向
     */
    private String bs;

    /**
     * 用户定义的订单号
     */
    private String client_oid;

    /**
     * 手续费
     */
    private BigDecimal commission;

    /**
     * 手续费币种
     */
    private String commission_currency;

    /**
     * TODO 文档缺失
     */
    private String contract;

    /**
     * 成交数量
     */
    private BigDecimal dealt_amount;

    /**
     * 成交价格
     */
    private BigDecimal dealt_price;

    /**
     * 成交时间
     */
    private String dealt_time;

    /**
     * maker或taker
     */
    private String dealt_type;

    /**
     * 交易所生成的订单号
     */
    private String exchange_oid;

    /**
     * 交易所生成的成交ID
     */
    private String exchange_tid;

    /**
     * 成交明细在交易所更新的时间
     */
    private String exchange_update;

    /**
     *  waiting, pending, part-deal-pending, withdrawing, part-deal-withdrawing, active, dealt, withdrawn, part-deal-withdrawn, error-order, end
     */
    private String tags;

}

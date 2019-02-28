package com.ailu.bybit.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * NOTE:
 * 1Tokex 所支持的交易对列表
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:17
 */
@Data
public class Contracts {

    private Long id;
    private String name;
    private String currency;
    private String category;
    private String alias;
    private BigDecimal exec_price;
    private BigDecimal min_change;
    private BigDecimal first_day;
    private BigDecimal min_amount;
    private BigDecimal unit_amount;
    private BigDecimal multiplier;
    private BigDecimal last_day;
    private String symbol;
}

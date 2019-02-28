package com.ailu.bybit.bean;

import lombok.Data;

import java.util.List;

/**
 * NOTE:
 * 1Tokex 所支持的交易所列表
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/13 17:17
 */
@Data
public class Exchange {

    private String exchange;
    private String alias;
    private String type;
    private List<String> sub_markets;
    private String tag;
    private boolean ot;
}

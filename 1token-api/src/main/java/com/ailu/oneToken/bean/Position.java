package com.ailu.oneToken.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.math.BigDecimal;

/**
 * NOTE:
 * 1token position
 * "total_amount": 1.0,                      # 总数
 *       "contract": "eth",                        # 币种
 *       "market_value": 4362.166242423991,        # 市值
 *       "available": 0.97,                        # 可用数量
 *       "frozen": 0.03,                           # 冻结数量
 *       "type": "spot"                            # 类型，spot表示现货持仓
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:33
 */
@Data
public class Position {


    /**
     * contract : eth.usd.n
     * total_amount : -10.0
     * available : -10.0
     * frozen : 0.0
     * average_open_price : 84.6
     * realized_pl : 0.0
     * contract_full : eth.usd.2018-12-28
     * type : future
     * current_price : 83.9255
     * used_margin : 0.05957664833691787
     * unrealized_pl : 0.009499869811643163
     * unrealized : 0.009499869811643163
     * standard_settle_price : 84.6
     * pl : 0.0
     * available_xtc : -1.1915329667383574
     * frozen_xtc : 0
     * total_xtc_amount : -1.1915329667383574
     * market_value : -688.057385625407
     * market_value_detail : {"eth":-688.057385625407}
     * value_cny : -688.057385625407
     * unrealized_settle : 0.009499869811643163
     * unrealized_rate : 0.008036889860650117
     * realized_settle : 0.0
     * frozen_position : 0.05957664833691787
     * total_amount_long : 0
     * available_long : 0
     * average_open_price_long : 0
     * standard_settle_price_long : 0
     * unrealized_settle_long : 0
     * unrealized_long : 0
     * unrealized_long_rate : null
     * realized_settle_long : null
     * frozen_position_long : 0
     * total_amount_short : 10.0
     * available_short : 10.0
     * average_open_price_short : 84.6
     * standard_settle_price_short : 84.6
     * unrealized_settle_short : 0.009499869811643163
     * unrealized_short : 0.009499869811643163
     * unrealized_short_rate : 0.008036889860650117
     * realized_settle_short : 0.0
     * frozen_position_short : 0.05957664833691787
     * detail : {"lever_rate":20,"buy_amount":0,"buy_price_avg":0,"buy_price_cost":0,"buy_profit_real":null,"buy_available":0,"sell_amount":10,"sell_price_avg":84.6,"sell_price_cost":84.6,"sell_profit_real":0,"sell_available":10,"exchange":"okef"}
     * extra_info : {}
     * liquidation_price : 91.05346552550725
     * liquidation_price_rate : 0.08493205909416379
     */

    /**
     * 资产标的
     * 应该是币种代号  eth.usd.n  eth 次周
     */
    private String contract;
    /**
     * 总持有标的资产数量
     */
    private BigDecimal totalAmount;
    /**
     * 可用标的资产数量
     */
    private BigDecimal available;
    /**
     * 总已冻结标的资产数量
     */
    private BigDecimal frozen;
    /**
     * 平均开仓均价
     */
    private BigDecimal averageOpenPrice;
    private BigDecimal realizedPl;
    /**
     * 交割时间
     */
    private String contractFull;
    private String type;
    private BigDecimal currentPrice;
    private BigDecimal usedMargin;
    private BigDecimal unrealizedPl;
    /**
     * 未实现收益
     */
    private BigDecimal unrealized;
    /**
     * 结算基准价
     */
    private BigDecimal standardSettlePrice;
    private BigDecimal pl;
    /**
     * 可用换算后持币数量
     */
    private BigDecimal availableXtc;
    /**
     * 已冻结换算后持币数量
     */
    private BigDecimal frozenXtc;
    /**
     * 换算后持币数量
     */
    private BigDecimal totalXtcAmount;
    /**
     * 标的资产市值
     */
    private BigDecimal marketValue;
    /**
     * 标的资产市值细节
     */
    private JSONObject marketValueDetail;
    /**
     * 标的资产价值
     */
    private BigDecimal valueCny;
    /**
     * 未结算收益
     */
    private BigDecimal unrealizedSettle;
    /**
     * 未实现收益率
     */
    private BigDecimal unrealizedRate;
    /**
     * 已结算收益率
     */
    private BigDecimal realizedSettle;
    /**
     * 已冻结用于当前持仓所需的标的资产数量（杠杆交易）
     */
    private BigDecimal frozenPosition;
    /**
     * 已冻结用于当前挂单所需的标的资产数量（杠杆交易）
     */
    private BigDecimal frozenOrder;
    /**
     * 换算后持币数量
     */
    private BigDecimal totalAmountXtc;
    /**
     * 持有多仓数量
     */
    private BigDecimal totalAmountLong;
    /**
     * 可用多仓数量
     */
    private BigDecimal availableLong;
    /**
     * 多仓平均开仓均价
     */
    private BigDecimal averageOpenPriceLong;
    /**
     * 多仓结算基准价
     */
    private BigDecimal standardSettlePriceLong;
    /**
     * 多仓未结算收益
     */
    private BigDecimal unrealizedSettleLong;
    /**
     * 未实现多仓收益
     */
    private BigDecimal unrealizedLong;
    /**
     * 未实现多仓收益率
     */
    private BigDecimal unrealizedLongRate;
    private BigDecimal realizedSettleLong;
    /**
     * 已冻结多仓持仓保证金
     */
    private BigDecimal frozenPositionLong;
    /**
     * 可用空仓数量
     */
    private BigDecimal totalAmountShort;
    /**
     * 未实现空仓收益
     */
    private BigDecimal availableShort;
    /**
     * 空仓平均开仓均价
     */
    private BigDecimal averageOpenPriceShort;
    /**
     * 空仓结算基准价
     */
    private BigDecimal standardSettlePriceShort;
    /**
     * 空仓未结算收益
     */
    private BigDecimal unrealizedSettleShort;
    /**
     * 未实现空仓收益
     */
    private BigDecimal unrealizedShort;
    /**
     * 为实现空仓收益率
     */
    private BigDecimal unrealizedShortRate;
    private BigDecimal realizedSettleShort;
    /**
     * 已冻结空仓持仓保证金
     */
    private BigDecimal frozenPositionShort;
    /**
     * 交易所返回原始数据
     */
    private JSONObject detail;
    private JSONObject extraInfo;
    /**
     * 预估强平价格
     */
    private BigDecimal liquidationPrice;
    /**
     * 预估强平率
     */
    private BigDecimal liquidationPriceRate;



}

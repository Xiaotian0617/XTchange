package com.ailu.oneToken.bean;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * NOTE:
 *  账户分为3种
 *  现货
 *  {
 *   "balance": 4362.166242423991,                 # 总资产 = 现金 + 虚拟货币市值
 *   "cash": 0.0,                                  # 现金（根据人民币汇率计算）
 *   "market_value": 4362.166242423991,            # 货币市值
 *   "market_value_detail": {                      # 每个币种的市值
 *     "btc": 0.0,
 *     "usdt": 0.0,
 *     "eth": 4362.166242423991
 *   },
 *   "position": [{                                # 货币持仓，默认包含btc，usdt或法币
 *       "total_amount": 1.0,                      # 总数
 *       "contract": "eth",                        # 币种
 *       "market_value": 4362.166242423991,        # 市值
 *       "available": 0.97,                        # 可用数量
 *       "frozen": 0.03,                           # 冻结数量
 *       "type": "spot"                            # 类型，spot表示现货持仓
 *     },
 *     {
 *       "total_amount": 0.0,
 *       "contract": "usdt",
 *       "market_value": 0.0,
 *       "available": 0.0,
 *       "frozen": 0.0,
 *       "type": "spot",
 *       "value_cny": 0.0
 *     },
 *     {
 *       "total_amount": 0.0,
 *       "contract": "btc",
 *       "market_value": 0.0,
 *       "available": 0.0,
 *       "frozen": 0.0,
 *       "type": "spot"
 *     }
 *   ]
 * }
 *  杠杆交易
 *  {
 *     "balance": 589943.9724,                 # 总资产 = 现金 + 虚拟货币市值
 *     "cash": 6198.5392,                      # 现金（根据人民币汇率计算）
 *     "market_value: 583745.4332,             # 货币市值
 *     "market_value_detail: {                 # 市值详细情况
 *         eos: 583745.4332,
 *         usdt: 0
 *     },
 *     "position": [
 *         {
 *             "contract": "eos.usdt",         # "<coin>.<base>"
 *             "market_value": 583745.4332,    # 市值
 *             "amount_coin": 20071.4762,      # 总数
 *             "available_coin": 18971.4762,   # 可用数量
 *             "frozen_coin": 1100.0,          # 冻结数量
 *             "pl_coin": 0,                   # pl_coin = profit and lose (or interest) of coins
 *             "loan_coin": 0,                 # loan of coins
 *             market_value_detail: {
 *                 "eos": 583745.4332,
 *                 "usdt": 0
 *             },
 *             "value_cny": 0,                 # CNY value of the contract (if available)
 *             "type": "margin",               # position type
 *             "mv_coin": 583745.4332,         # market value of coins
 *             "amount_base": 979.0929,        # total amount of the base currency
 *             "mv_base": 0,                   # market value of the base currency, 0 for USDT
 *             "available_base": 7029.3753,    # amount of the available base currency
 *             "frozen_base": 4511.19,         # frozen amount of the base currency
 *             "pl_base": -73.4164,            # pl_base = profit and lose (or interest) of the base currency
 *             "loan_base": -10448.056,        # loan of the base currency
 *             "value_cny_base": 6198.5392     # CNY value of the base currency (if available)
 *         },
 *         ...
 *     ]
 * }
 * 期货
 * {
 *   "balance": 4361345.793589303,                 # 总资产 = 现金 + 虚拟货币市值
 *   "cash": 0.0,                                  # 现金（根据人民币汇率计算）
 *   "market_value": 8728917.770172266,            # 虚拟货币市值
 *   "market_value_detail": {                      # 每个币种的市值
 *     "btc": 8728917.770172266,
 *     "usd": 0.0
 *   },
 *   "position": [{                                # 持仓，默认包含btc，usdt或法币现货
 *     "total_amount": 74.90222428,
 *     "contract": "btc",
 *     "market_value": 4361345.793589303,
 *     "available": 74.90222428,
 *     "frozen": 0.0,
 *     "type": "spot"
 *   }, {
 *     "total_amount": 0.0,
 *     "contract": "usd",
 *     "market_value": 0.0,
 *     "available": 0.0,
 *     "frozen": 0.0,
 *     "type": "spot",
 *     "value_cny": 0.0
 *   }, {
 *     "total_amount": 6904.0,                     # 总数
 *     "contract": "btc.usd.q",                    # 合约
 *     "market_value": 4367571.976582963,          # 市值
 *     "available": 6904.0,                        # 可用数量
 *     "frozen": 0.0,                              # 冻结数量
 *     "pl": 1.64417643,                           # profit and lose
 *     "market_value_detail": {                    #
 *       "btc": 4367571.976582963
 *     },
 *     "type": "future",                           # 类型，future表示期货持仓
 *     "total_xtc_amount": 75.00915342001107,      #
 *     "available_xtc": 75.00915342001107,         #
 *     "frozen_xtc": 0.0,                          #
 *     "available_long": 6905.0,                   # 多头仓位
 *     "available_short": 1.0                      # 空头仓位
 *   }]
 * }
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:45
 */
@Data
public class Account {




    /**
     * balance : 66.23575488625748
     * cash : 0
     * market_value : -690.7402827147368
     * market_value_detail : {"eth":-690.7402827147368}
     */
    /**
     * 账户总权益
     */
    private BigDecimal balance;
    private int cash;
    /**
     * 账户总市值(法币及稳定币不计入市值内)
     */
    private BigDecimal marketValue;
    /**
     * 账户总市值明细
     */
    private JSONObject marketValueDetail;
    private List<Position> position;
    /**
     * 各资产保证金率明细
     */
    private JSONObject marginCallRatio;

}

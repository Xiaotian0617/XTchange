package com.al.bcoin;

import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * zb.com api
 * doc url: https://www.zb.com/i/developer
 * <pre>
 * 所有API方法调用在请求失败或遇到未知错误时会返回JSON错误对象。
 * 1000	调用成功
 * 1001	一般错误提示
 * 1002	内部错误
 * 1003	验证不通过
 * 1004	资金安全密码锁定
 * 1005	资金安全密码错误，请确认后重新输入。
 * 1006	实名认证等待审核或审核不通过
 * 1009	此接口维护中
 * 1010	暂不开放
 * 1012	权限不足
 * 1013	不能交易，若有疑问请联系在线客服
 * 2002	比特币账户余额不足
 * 2003	莱特币账户余额不足
 * 2005	以太币账户余额不足
 * 2006	ETC币账户余额不足
 * 2007	BTS币账户余额不足
 * 2009	账户余额不足
 * 3001	挂单没有找到
 * 3002	无效的金额
 * 3003	无效的数量
 * 3004	用户不存在
 * 3005	无效的参数
 * 3006	无效的IP或与绑定的IP不一致
 * 3007	请求时间已失效
 * 3008	交易记录没有找到
 * 4001	API接口被锁定或未启用
 * 4002	请求过于频繁
 * </pre>
 */
public class Zb {

    public interface Api {

        String WS_URL = "wss://api.zb.cn:9999/websocket";
        String REST_BASE_RUL = "http://api.zb.cn/data/v1/";

        /**
         * 市场配置信息
         * <blockquote><pre>
         * priceScale : 价格小数位数,
         * amountScale : 数量小数位数
         * </pre></blockquote>
         *
         * @return
         */
        @GET("markets")
        Call<String> markets();

        /**
         * 全币种行情
         * return <blockquote><pre>
         *     //# Response
         * {
         * 	"hpybtc":{
         * 		"vol":"19800.6",
         * 		"last":"0.00000237",
         * 		"sell":"0.000002366",
         * 		"buy":"0.00000236",
         * 		"high":"0.0000026552",
         * 		"low":"0.00000229"
         *        },
         * 	"tvqc":{
         * 		"vol":"2201510.1",
         * 		......
         * }
         * </pre></blockquote>
         */
        @GET("allTicker")
        Call<String> allTicker();


        /**
         * <pre>
         * high : 最高价
         * low : 最低价
         * buy : 买一价
         * sell : 卖一价
         * last : 最新成交价
         * vol : 成交量(最近的24小时)
         * </pre>
         *
         * @param tradePair zb_qc,bcc_zb,zb_usdt,zb_btc,btc_qc,btc_usdt et.
         * @return
         */
        @GET("ticker")
        Call<String> ticker(@Query("market") String tradePair);

        /**
         * 深度信息
         *
         * @param tradePair zb_qc,bcc_zb,zb_usdt,zb_btc
         * @param size      档位1-50，如果有合并深度，只能返回5档深度
         * @param merge     可为 null，zb_qc : 0.0001, bcc_zb : 0.01, zb_usdt : 0.0001
         * @return asks : 卖方深度,
         * bids : 买方深度,
         * timestamp : 此次深度的产生时间戳
         */
        @GET("depth")
        Call<String> depth(@Query("market") String tradePair
                , @Query("size") Integer size
                , @Query("merge") Integer merge);

        /**
         * 历史成交
         *
         * @param tradePair 交易对
         * @param since     从指定交易ID后50条数据
         * @return date : 交易时间(时间戳),
         * price : 交易价格,
         * amount : 交易数量,
         * tid : 交易生成ID,
         * type : 交易类型，buy(买)/sell(卖),
         * trade_type : 委托类型，ask(卖)/bid(买)
         */
        @GET("trades")
        Call<String> trades(@Query("market") String tradePair
                , @Query("since") String since);


        /**
         * @param tradePair zb_qc,bcc_zb,zb_usdt,zb_btc
         * @param type      1min
         *                  3min
         *                  5min
         *                  15min
         *                  30min
         *                  1day
         *                  3day
         *                  1week
         *                  1hour
         *                  2hour
         *                  4hour
         *                  6hour
         *                  12hour
         * @param size      返回数据的条数限制(默认为1000，如果返回数据多于1000条，那么只返回1000条)
         * @param since     从这个时间戳之后的
         * @return data : K线内容
         * moneyType : 买入货币
         * symbol : 卖出货币
         * data : 内容说明
         * [
         * 1417536000000, 时间戳
         * 2370.16, 开
         * 2380, 高
         * 2352, 低
         * 2367.37, 收
         * 17259.83 交易量
         * ]
         */
        @GET("kline")
        Call<String> kline(@Query("market") String tradePair,
                           @Query("type") String type,
                           @Query("size") Integer size,
                           @Query("since") Long since);


        /**
         * zb websocket接口, {@link WSListener#start()} 方法最后调用
         */
        default WSListener ws() {
            return new WSListener()
                    .url(WS_URL)
                    .parse(Zb::parse);
        }

    }

    public static WSListener.Info parse(String text) {
        return null;
    }


    public static Api ZBAPI = new Retrofit.Builder()
            .baseUrl(Api.REST_BASE_RUL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(new Retrofit2ConverterFactory())
            .build()
            .create(Api.class);
}

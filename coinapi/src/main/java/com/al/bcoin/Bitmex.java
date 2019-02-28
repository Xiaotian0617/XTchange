package com.al.bcoin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.support.retrofit.Retrofit2ConverterFactory;
import lombok.Data;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company 洛阳艾鹿网络有限公司
 * @Date 2018/7/25 15:46
 */
@Data
public class Bitmex {

    public static WSListener.Info apply(Object o) {
        JSONObject job = (JSONObject) o;
        return mapper(job);
    }

    public interface Api {

        String BASE_URL = "https://www.bitmex.com/api/v1/";
        String WS_URL = "wss://www.bitmex.com/realtime";

        String SUBSCRIBE = "{\"op\": \"subscribe\", \"args\": [\"%s\"]}";

        //"orderBookL2","orderBook10" 暂不订阅深度数据
        List<String> SUB_TYPE = Arrays.asList("trade","tradeBin1m","tradeBin1d");

        @Data
        class BitmexPair{
            private String exchange = "Bitmex";
            private String symbol;
            private String unit;
            private String onlyKey;

            public BitmexPair(String symbol, String unit) {
                this.symbol = symbol;
                this.unit = unit;
                setOnlyKey(this.exchange,symbol,unit);
            }

            public void setOnlyKey(String exchange,String symbol,String unit) {
                this.onlyKey = String.format("%s_%s_%s",exchange,symbol,unit);
            }
        }

        default WSListener ws() {
            return new WSListener()
                    .setProxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",1087)))
                    .url(WS_URL)
                    .ping("ping", 10)
                    .parse(Bitmex::paser);
        }

        Map<String,Integer> pairTypeMap = new HashMap<String,Integer>(){{
            put("F",1);
            put("G",2);
            put("H",3);
            put("J",4);
            put("K",5);
            put("M",6);
            put("N",7);
            put("Q",8);
            put("U",9);
            put("V",10);
            put("X",11);
            put("Z",12);
        }};

        List<String> pairTypeNumList = Arrays.asList("F","G","H","J","K","M","N","Q","U","V","X","Z");

        default WSListener wsAll() throws IOException {
            WSListener ws = ws();
            SUB_TYPE.forEach(str->{
                String sendText= String.format(SUBSCRIBE, str);
                System.out.println(sendText);
                ws.send(sendText);
            });
            return ws;
        }
    }

     static Map<String,Api.BitmexPair> pairsMap = new HashMap<String, Api.BitmexPair>(){{
        put("XBTUSD",new Api.BitmexPair("XBT","USD"));
        put("XBT7D_U105",new Api.BitmexPair("XBT7DU105","USD"));
        put("XBT7D_D95",new Api.BitmexPair("XBT7DD95","USD"));
        put("ETHUSD", new Bitmex.Api.BitmexPair("ETH", "USD"));
    }};

    private static String getYearSuffix(){
        LocalDate localDate = LocalDate.now();
        String year = localDate.getYear()+"";
        return year.substring(year.length()-2);
    }

    public static String getMouthCode(String symbol){
        LocalDate localDate = LocalDate.now();
        String year = String.valueOf(localDate.getYear()).substring(2);
        int num = symbol.lastIndexOf(year);
        String substring = symbol.substring(num - 1, num);
        Integer resultInteger = Api.pairTypeMap.get(substring);
        LocalDate lastDayByThisMonth = getLastDayByThisMonth(resultInteger);
        LocalDate resultDate = LocalDate.of(lastDayByThisMonth.getYear(),resultInteger,lastDayByThisMonth.getDayOfMonth());
        String fridayByDate = getFridayByThisMonth(resultDate);
        String replace = symbol.substring(0,num-1);
        return replace+fridayByDate;
    }

    /**
     * 传入本月时间
     * @return
     */
    private static LocalDate getLastDayByThisMonth(Integer month) {
        LocalDate localDate = LocalDate.now();
        LocalDate lastDay = LocalDate.of(localDate.getYear(),month,1);
        lastDay.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay;
    }

    /**
     * 传入本月时间
     * @param localDate
     * @return
     */
    private static String getFridayByThisMonth(LocalDate localDate) {
        LocalDate lastFridayForThisMouth = getLastFridayForThisMouth(localDate);
        String month = getNumberFormat(lastFridayForThisMouth.getMonth().getValue());
        String day = getNumberFormat(lastFridayForThisMouth.getDayOfMonth());
        return month+day;
    }

    private static String getNumberFormat(Integer integer){
        if (integer<10){
            return "0"+integer;
        }
        return integer+"";
    }

    private static LocalDate getLastFridayForThisMouth(LocalDate localDate) {
        LocalDate friday = localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
        return friday;
    }

    static Date LocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atTime(0, 0).atZone(ZoneId.systemDefault()).toInstant());
    }

    private static Api.BitmexPair getBitmexPair(String symbol) {
        if (pairsMap.get(symbol)!=null){
            return pairsMap.get(symbol);
        }
        String ownSymbol = editBitmexSymbol(symbol);
        return new Bitmex.Api.BitmexPair(ownSymbol,editBitmexUnit(ownSymbol,null));
    }

    private static String editBitmexSymbol(String symbol){
        return getMouthCode(symbol);
    }

    private static String editBitmexUnit(String symbol, String unit) {
        if (symbol.length()==3||symbol.contains("XBT")){
            return "USD";
        }
        if (symbol.length()>3){
            return "BTC";
        }
        return unit;
    }

    public static Bitmex.Api bitmexApi = new Retrofit.Builder()
            .baseUrl(Bitmex.Api.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(new Retrofit2ConverterFactory())
            .build()
            .create(Bitmex.Api.class);

    public static void main(String[] args) {
        try {
            bitmexApi.wsAll()
                    .message(info -> System.out.println(info)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static WSListener.Info mapper(JSONObject obj) {
        WSListener.Info<String> info = new WSListener.Info<>();
        String data = obj.getString("data");
        if ("[]".equals(data)){
            return null;
        }
        String pair = (String) JSONPath.read(data, "$[0].symbol");
        if (pair!=null&&pair.contains(".")){
            return null;
        }
        Api.BitmexPair bitmexPair = getBitmexPair(pair);
        if (bitmexPair.getUnit()==null){
            return null;
        }
        info.coin = bitmexPair.symbol;
        info.unit = bitmexPair.unit;
        info.type = obj.getString("table");
        if (info.type.equals("tradeBin1m")){
            info.kline = "min";
        }else if (info.type.equals("tradeBin1d")){
            info.kline = "day";
        }else {
            info.kline = null;
        }
        info.data = data;
        return info;
    }

    public static WSListener.Info paser(String message) {
        return Optional.of(message)
                .filter(str->str!=null&&!"".equals(str))
                .filter(str->!str.contains("Welcome"))
                .filter(str->!str.contains("Unexpected"))
                .filter(str->!str.equalsIgnoreCase("pong"))
                .filter(str->!str.contains("success"))
                .map(JSON::parse).map(Bitmex::apply)
                .orElse(null);
    }

}

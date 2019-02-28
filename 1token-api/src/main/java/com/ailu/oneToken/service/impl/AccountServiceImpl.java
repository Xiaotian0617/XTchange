package com.ailu.oneToken.service.impl;

import com.ailu.oneToken.bean.Account;
import com.ailu.oneToken.client.OneTokenClient;
import com.ailu.oneToken.enums.AccountEnum;
import com.ailu.oneToken.service.AccountService;
import com.ailu.oneToken.service.BaseService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.okex.open.api.exception.APIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ailu.oneToken.enums.AccountEnum.CATEGORY;

/**
 * NOTE:
 *
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 15:02
 */
public class AccountServiceImpl implements AccountService, BaseService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    private static final String ONE_TOKEN_SUCCESS ="success";


    private OneTokenClient oneTokenClient;

    public AccountServiceImpl(OneTokenClient oneTokenClient) {
        this.oneTokenClient = oneTokenClient;
    }

    /**
     * 获取账户信息 包含持仓
     *
     * @param exchange
     * @param accountName
     * @return
     */
    @Override
    public Account getAccount(String exchange, String accountName) {
        return strToModel(this.oneTokenClient.client.executeSync(this.oneTokenClient.api.getInfo(exchange, accountName)), Account.class);
    }


    /**
     * Generate a new account for parent account with given exchange.
     *
     * @param exchange account's exchange.
     * @param parent   parent account, must be with format exchange/account
     *                 e.g. okef/6b
     * @param account  sub account which to be generate, with a letter head
     *                 and it's length between 3 and 20
     * @throws Exception when generate error occurs.
     */
    @Override
    public boolean genNewSubAccount(String exchange, String parent,
                                    String account) throws Exception {

        JSONObject jo = new JSONObject() {{
            put("exchange", exchange);
            put("parent", parent);
            put("account", account);
            put("category", CATEGORY);
        }};
        String json = exec(this.oneTokenClient.api.genNewSubAccount(jo));
        return ONE_TOKEN_SUCCESS.equals(((Map) JSON.parse(json)).get("code"));

    }

    /**
     * Generate a new account for parent account with given exchange.
     *
     * @param accountEnum app supported account enum.
     * @param account     sub account which to be generate, with a letter head
     *                    and it's length between 3 and 20
     * @throws Exception when generate error occurs.
     * @see {@link AccountEnum}
     */
    @Override
    public boolean genNewSubAccount(AccountEnum accountEnum, String account) throws Exception {
        return genNewSubAccount(accountEnum.getExchange(), accountEnum.getOTParamAccount(), account);
    }

    /**
     * Get sub account list with specified parent account.
     *
     * @param accountEnum
     * @throws Exception
     */
    @Override
    public List<String> getSubAccountList(AccountEnum accountEnum) throws Exception {
        String json = exec(oneTokenClient.api.getSubAccountList(accountEnum.getCategory(),
                accountEnum.getOTParamAccount()));

        List<Map> accs = JSONArray.parseArray(json, Map.class);
        return accs.stream().map(o -> (String) o.get("symbol")).collect(Collectors.toList());
    }


    /**
     * Get purge sub account list with specified parent account.
     * Sub account looks like "bincoin_0"
     *
     * @param accountEnum
     * @throws Exception
     */
    @Override
    public List<String> getPurgeSubAccountList(AccountEnum accountEnum) throws Exception {
        String json = exec(oneTokenClient.api.getSubAccountList(accountEnum.getCategory(),
                accountEnum.getOTParamAccount()));
        try {
            List<Map> accs = JSONArray.parseArray(json, Map.class);
            return accs.stream().map(o -> {
                String[] syms = ((String) o.get("symbol")).split("/");
                if (syms.length == 2) {
                    return syms[1];
                } else {
                    return "";
                }
            }).filter(x -> !x.equals("")).collect(Collectors.toList());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Add asset to a sub account with specified exchange.
     *
     * @param exchange   exchange
     * @param subAccount sub account to be added asset to.
     * @param currency   currency
     * @param amount     the amount to be added asset to.
     */
    @Override
    public boolean addAsset2SubAccount(String exchange, String subAccount,
                                       String currency, BigDecimal amount) throws Exception {

        JSONObject jo = new JSONObject() {{
            put("currency", currency);
            put("amount", amount);
        }};
        String json = exec(oneTokenClient.api.addAsset2SubAccount(exchange, subAccount, jo));
        return ONE_TOKEN_SUCCESS.equals(((Map) JSON.parse(json)).get("code"));

    }

    /**
     * Generate a new tx address
     *
     * @param currency currency e.g. eth
     * @throws Exception when generate error occurs.
     */
    @Override
    public String genNewTxAddress(String currency) throws Exception {
        String json = exec(oneTokenClient.api.genCurrencyAddress(currency));
        Map map = (Map) JSON.parse(json);
        Object code = map.get("code");
        Object addr = map.get("address");
        if (ONE_TOKEN_SUCCESS.equals(code) && addr instanceof String)
            return (String)addr;
        return null;
    }

    /**
     * Get the tx address list of given currency
     *
     * @param currency currency e.g. eth
     * @throws Exception when generate error occurs.
     */
    @Override
    public List<String> getTxAddressList(String currency) throws Exception {
        String json = exec(oneTokenClient.api.getCurrencyAddressList(currency));
        Map map = (Map) JSON.parse(json);
        Object code = map.get("code");
        Object addr = map.get("address");
        if (ONE_TOKEN_SUCCESS.equals(code) &&  addr instanceof JSONArray){
            return ((JSONArray) addr).toJavaList(String.class);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Call the http service and process the exceptions.
     *
     * @param call
     * @param <T>
     * @return
     * @throws Exception
     */
    private final <T> T exec(final Call<T> call) throws Exception {
        if (oneTokenClient.client != null) {
            try {
                return oneTokenClient.client.executeSync(call);
            } catch (APIException ae) {
                log.error(ae.getMessage(), ae);
                throw new Exception(ae.getMessage());
            }
        }
        return null;
    }
}

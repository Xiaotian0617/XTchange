package com.ailu.oneToken.service;

import com.ailu.oneToken.bean.Account;
import com.ailu.oneToken.enums.AccountEnum;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;

/**
 * NOTE:
 *  1token 账户信息调用接口
 * @Version 1.0
 * @Since JDK1.8
 * @Author mr.wang
 * @Company Henan ailu
 * @Date 2018/12/15 14:31
 */
public interface AccountService extends BaseService {

    /**
     *  获取账户信息 包含持仓
     * @return
     */
    Account getAccount(@NonNull String exchange, @NonNull String accountName);


    /**
     * Generate a new account for parent account with given exchange.
     *
     * @param exchange      account's exchange.
     * @param parent        parent account, must be with format exchange/account
     *                      e.g. okef/6b
     *
     * @param account       sub account which to be generate, with a letter head
     *                      and it's length between 3 and 20
     * @throws Exception    when generate error occurs.
     *
     *
     */
    @Deprecated
    boolean genNewSubAccount(String exchange,String parent,String account) throws Exception;



    /**
     * Generate a new account for parent account with given exchange.
     * @param accountEnum   app supported account enum.
     * @param account       sub account which to be generate, with a letter head
     *                      and it's length between 3 and 20
     * @throws Exception    when generate error occurs.
     *
     * @see {@link AccountEnum}
     */
    boolean genNewSubAccount(AccountEnum accountEnum, String account) throws Exception;


    /**
     * Get sub account list with specified parent account.
     * sub account looks like "okef/bicoin_0
     * @param accountEnum
     * @throws Exception
     */
    List<String> getSubAccountList(AccountEnum accountEnum) throws Exception;

    /**
     * Get purge sub account list with specified parent account.
     * Sub account looks like "bincoin_0"
     * @param accountEnum
     * @throws Exception
     */
    List<String> getPurgeSubAccountList(AccountEnum accountEnum) throws Exception;


    /**
     * Add asset to a sub account with specified exchange.
     * @param exchange      exchange
     * @param subAccount    sub account to be added asset to.
     * @param currency      currency
     * @param amount        the amount to be added asset to.
     */
    boolean addAsset2SubAccount(String exchange, String subAccount, String currency,
                             BigDecimal amount) throws Exception;


    /**
     * Generate a new tx address
     * @param currency      currency e.g. eth
     * @throws Exception    when generate error occurs.
     *
     */
    String genNewTxAddress(String currency) throws Exception;


    /**
     * Get the tx address list of given currency
     * @param currency      currency e.g. eth
     * @throws Exception    when generate error occurs.
     *
     */
    List<String> getTxAddressList(String currency) throws Exception;

}

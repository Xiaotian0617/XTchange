package com.ailu.oneToken.enums;

/**
 * Account enum .
 * @version 1.0.1
 * @author Asin Liu
 */
public enum  AccountEnum {
    OKJIAN("okex","liujianshu"),
    BICOIN("okef","bicoin"),
    OKEFLDD("okef","liudada");

    private String exchange;
    private String account;

    public static final String CATEGORY = "apisub";


    AccountEnum(String exchange, String account) {
        this.exchange = exchange;
        this.account = account;
    }

    /**
     * For one token http call only.
     * @return
     */
    public String getOTParamAccount(){
        return this.exchange + "/" + this.account;
    }

    public String getCategory(){
        return CATEGORY;
    }


    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

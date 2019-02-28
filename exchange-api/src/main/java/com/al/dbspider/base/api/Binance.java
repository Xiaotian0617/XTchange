package com.al.dbspider.base.api;

import lombok.Data;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Binance {

    @GET("/exchange/public/product")
    Call<Products> products();



    @Data
    class Products{
        List<Symbol> data;
    }

    @Data
    class Symbol{
        String status;
        String symbol;
    }
}

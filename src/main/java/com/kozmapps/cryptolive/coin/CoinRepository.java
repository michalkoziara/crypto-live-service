package com.kozmapps.cryptolive.coin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinRepository {
    @GET("/data/blockchain/list")
    Call<CoinResponse> getCoins(@Query("api_key") String apiKey);
}

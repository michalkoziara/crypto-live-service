package com.kozmapps.cryptolive.price;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PriceRepository {
    @GET("/data/v2/histominute")
    Call<PriceResponse> getMinutePrices(@Query("api_key") String apiKey,
                                        @Query("fsym") String coinFromSymbol,
                                        @Query("tsym") String coinToSymbol,
                                        @Query("limit") int limit);

    @GET("/data/v2/histohour")
    Call<PriceResponse> getHourlyPrices(@Query("api_key") String apiKey,
                                        @Query("fsym") String coinFromSymbol,
                                        @Query("tsym") String coinToSymbol,
                                        @Query("limit") int limit);

    @GET("/data/v2/histoday")
    Call<PriceResponse> getDailyPrices(@Query("api_key") String apiKey,
                                       @Query("fsym") String coinFromSymbol,
                                       @Query("tsym") String coinToSymbol,
                                       @Query("limit") int limit);
}


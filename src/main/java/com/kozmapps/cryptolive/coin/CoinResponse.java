package com.kozmapps.cryptolive.coin;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class CoinResponse {

    @SerializedName(value = "Response")
    String response;

    @SerializedName(value = "Message")
    String message;

    @SerializedName(value = "HasWarning")
    boolean hasWarning;

    @SerializedName(value = "Type")
    int type;

    @SerializedName(value = "Data")
    Map<String, Coin> data;

    @SerializedName(value = "RateLimit")
    RateLimit rateLimit;

    @Data
    @FieldDefaults(level = PRIVATE)
    class RateLimit {
        Map<String, Integer> callsMade;
        Map<String, Integer> maxCalls;
    }
}

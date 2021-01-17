package com.kozmapps.cryptolive.price;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class PriceResponse {
    @SerializedName(value = "Response")
    String response;

    @SerializedName(value = "Message")
    String message;

    @SerializedName(value = "HasWarning")
    boolean hasWarning;

    @SerializedName(value = "Type")
    int type;

    @SerializedName(value = "Data")
    PriceData data;

    @Data
    @FieldDefaults(level = PRIVATE)
    class PriceData {

        @SerializedName(value = "Aggregated")
        boolean aggregated;

        @SerializedName(value = "TimeFrom")
        long timeFrom;

        @SerializedName(value = "TimeTo")
        long timeTo;

        @SerializedName(value = "Data")
        List<Price> data;
    }
}

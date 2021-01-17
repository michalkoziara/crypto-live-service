package com.kozmapps.cryptolive.price;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class Price {
    @SerializedName(value = "time")
    long time;

    @SerializedName(value = "high")
    double high;

    @SerializedName(value = "low")
    double low;

    @SerializedName(value = "open")
    double open;

    @SerializedName(value = "volumefrom")
    double volumeFrom;

    @SerializedName(value = "volumeto")
    double volumeTo;

    @SerializedName(value = "close")
    double close;

    @SerializedName(value = "conversionType")
    String conversionType;

    @SerializedName(value = "conversionSymbol")
    String conversionSymbol;
}

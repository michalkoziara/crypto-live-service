package com.kozmapps.cryptolive.coin;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class Coin {
    @SerializedName(value = "id")
    String id;

    @SerializedName(value = "symbol")
    String symbol;
}

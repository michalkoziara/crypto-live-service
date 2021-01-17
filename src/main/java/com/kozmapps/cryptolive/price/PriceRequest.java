package com.kozmapps.cryptolive.price;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class PriceRequest {
    String coinFromSymbol;
    String coinToSymbol;
    int limit;
}

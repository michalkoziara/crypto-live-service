package com.kozmapps.cryptolive.price;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/prices")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class PriceController {
    @NonNull
    PriceService priceService;

    @GetMapping("/minute")
    List<Price> getMinutePrices(@RequestBody PriceRequest priceRequest) {
        return priceService.getMinutePrices(
                priceRequest.getCoinFromSymbol(),
                priceRequest.getCoinToSymbol(),
                priceRequest.getLimit()
        );
    }

    @GetMapping("/hourly")
    List<Price> getHourlyPrices(@RequestBody PriceRequest priceRequest) {
        return priceService.getHourlyPrices(
                priceRequest.getCoinFromSymbol(),
                priceRequest.getCoinToSymbol(),
                priceRequest.getLimit()
        );
    }

    @GetMapping("/daily")
    List<Price> getDailyPrices(@RequestBody PriceRequest priceRequest) {
        return priceService.getDailyPrices(
                priceRequest.getCoinFromSymbol(),
                priceRequest.getCoinToSymbol(),
                priceRequest.getLimit()
        );
    }
}
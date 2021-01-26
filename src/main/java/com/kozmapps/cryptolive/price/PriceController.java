package com.kozmapps.cryptolive.price;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

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
    List<Price> getMinutePrices(
            @RequestParam String coinFromSymbol,
            @RequestParam String coinToSymbol,
            @RequestParam int limit) {
        return priceService.getMinutePrices(
                coinFromSymbol,
                coinToSymbol,
                limit
        );
    }

    @GetMapping("/hourly")
    List<Price> getHourlyPrices(
            @RequestParam String coinFromSymbol,
            @RequestParam String coinToSymbol,
            @RequestParam int limit) {
        return priceService.getHourlyPrices(
                coinFromSymbol,
                coinToSymbol,
                limit
        );
    }

    @GetMapping("/daily")
    List<Price> getDailyPrices(
            @RequestParam String coinFromSymbol,
            @RequestParam String coinToSymbol,
            @RequestParam int limit) {
        return priceService.getDailyPrices(
                coinFromSymbol,
                coinToSymbol,
                limit
        );
    }
}
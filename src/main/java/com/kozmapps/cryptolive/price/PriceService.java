package com.kozmapps.cryptolive.price;

import com.kozmapps.cryptolive.RetrofitClient;
import com.kozmapps.cryptolive.SecretConstants;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PriceService {
    PriceRepository priceRepository;

    public PriceService() {
        this.priceRepository = new RetrofitClient().getRetrofitClient().create(PriceRepository.class);
    }

    List<Price> getMinutePrices(String coinFromSymbol, String coinToSymbol, int limit) {
        List<Price> prices = new ArrayList<>();

        try {
            Response<PriceResponse> response = priceRepository
                    .getMinutePrices(
                            SecretConstants.API_KEY,
                            coinFromSymbol,
                            coinToSymbol,
                            limit)
                    .execute();
            PriceResponse priceResponse = response.body();

            if (priceResponse != null && "Success".equals(priceResponse.getResponse())) {
                prices = priceResponse.getData().getData();
            }
        } catch (IOException ioException) {
            return prices;
        }

        return prices;
    }

    List<Price> getHourlyPrices(String coinFromSymbol, String coinToSymbol, int limit) {
        List<Price> prices = new ArrayList<>();

        try {
            Response<PriceResponse> response = priceRepository
                    .getHourlyPrices(
                            SecretConstants.API_KEY,
                            coinFromSymbol,
                            coinToSymbol,
                            limit)
                    .execute();
            PriceResponse priceResponse = response.body();

            if (priceResponse != null && "Success".equals(priceResponse.getResponse())) {
                prices = priceResponse.getData().getData();
            }
        } catch (IOException ioException) {
            return prices;
        }

        return prices;
    }

    List<Price> getDailyPrices(String coinFromSymbol, String coinToSymbol, int limit) {
        List<Price> prices = new ArrayList<>();

        try {
            Response<PriceResponse> response = priceRepository
                    .getDailyPrices(
                            SecretConstants.API_KEY,
                            coinFromSymbol,
                            coinToSymbol,
                            limit)
                    .execute();
            PriceResponse priceResponse = response.body();

            if (priceResponse != null && "Success".equals(priceResponse.getResponse())) {
                prices = priceResponse.getData().getData();
            }
        } catch (IOException ioException) {
            return prices;
        }

        return prices;
    }
}

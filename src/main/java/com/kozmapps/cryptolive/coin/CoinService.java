package com.kozmapps.cryptolive.coin;

import com.kozmapps.cryptolive.RetrofitClient;
import com.kozmapps.cryptolive.SecretConstants;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class CoinService {
    CoinRepository coinRepository;

    public CoinService() {
        this.coinRepository = new RetrofitClient().getRetrofitClient().create(CoinRepository.class);
    }

    List<Coin> getCoins() {
        List<Coin> coins = new ArrayList<>();

        try {
            Response<CoinResponse> response = coinRepository.getCoins(SecretConstants.API_KEY).execute();
            CoinResponse coinResponse = response.body();

            if (coinResponse != null && "Success".equals(coinResponse.getResponse())) {
                Map<String, Coin> coinByName = coinResponse.getData();
                coinByName.forEach((String name, Coin coin) -> coins.add(coin));
            }
        } catch (IOException ioException) {
            return coins;
        }

        return coins;
    }
}

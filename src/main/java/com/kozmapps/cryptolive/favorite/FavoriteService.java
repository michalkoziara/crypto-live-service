package com.kozmapps.cryptolive.favorite;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class FavoriteService {
    @NonNull
    FavoriteRepository favoriteRepository;

    Favorite addFavorite(Favorite favorite, String username) {
        favorite.setUsername(username);
        favorite.setCompositeKey(username + favorite.getCoinFromSymbol() + favorite.getCoinToSymbol());
        return favoriteRepository.save(favorite);
    }

    Favorite updateFavorite(Favorite favorite, String username) {
        favorite.setUsername(username);

        String compositeKey = username + favorite.getCoinFromSymbol() + favorite.getCoinToSymbol();
        favorite.setCompositeKey(compositeKey);

        if (favoriteRepository.findById(compositeKey).isEmpty()) {
            return null;
        }

        return favoriteRepository.save(favorite);
    }

    List<Favorite> getFavoritesList(String username) {
        return favoriteRepository.findByUsername(username);
    }

    void removeFavorite(Favorite favorite, String username) {
        favorite.setCompositeKey(username + favorite.getCoinFromSymbol() + favorite.getCoinToSymbol());
        favoriteRepository.delete(favorite);
    }
}

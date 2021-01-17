package com.kozmapps.cryptolive.favorite;

import com.kozmapps.cryptolive.user.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/favorites")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class FavoriteController {
    @NonNull
    FavoriteService favoriteService;

    @PostMapping()
    Favorite addFavorite(@RequestBody Favorite favorite, @AuthenticationPrincipal final User user) {
        String username = user.getUsername();
        return favoriteService.addFavorite(favorite, username);
    }

    @PutMapping()
    Favorite updateFavorite(@RequestBody Favorite favorite, @AuthenticationPrincipal final User user) {
        String username = user.getUsername();
        return favoriteService.updateFavorite(favorite, username);
    }

    @GetMapping()
    List<Favorite> getFavorites(@AuthenticationPrincipal final User user) {
        String username = user.getUsername();
        return favoriteService.getFavoritesList(username);
    }

    @DeleteMapping()
    void removeFavorite(@RequestBody Favorite favorite, @AuthenticationPrincipal final User user) {
        String username = user.getUsername();
        favoriteService.removeFavorite(favorite, username);
    }
}
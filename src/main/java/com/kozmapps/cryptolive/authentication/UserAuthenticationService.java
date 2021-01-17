package com.kozmapps.cryptolive.authentication;

import com.google.common.collect.ImmutableMap;
import com.kozmapps.cryptolive.date.DateService;
import com.kozmapps.cryptolive.user.InvalidToken;
import com.kozmapps.cryptolive.user.InvalidTokenService;
import com.kozmapps.cryptolive.user.User;
import com.kozmapps.cryptolive.user.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class UserAuthenticationService {
    @NonNull
    TokenService tokens;
    @NonNull
    UserService userService;
    @NonNull
    DateService dateService;
    @NonNull
    InvalidTokenService invalidTokenService;

    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     */
    public Optional<String> login(final String username, final String password) {
        return userService
                .findByUsername(username)
                .filter(user -> Objects.equals(password, user.getPassword()))
                .map(user -> tokens.expiring(ImmutableMap.of("username", username)));
    }

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    public Optional<User> findByToken(final String token) {
        if (!invalidTokenService.verifyToken(token)) {
            return Optional.empty();
        }

        return Optional
                .of(tokens.verify(token))
                .map(map -> map.get("username"))
                .flatMap(userService::findByUsername);
    }

    /**
     * Logs out the user.
     *
     * @param token user dao key
     */
    public void logout(final String token) {
        final DateTime now = dateService.now();

        invalidTokenService.createInvalidToken(
                new InvalidToken(token, now)
        );
    }
}
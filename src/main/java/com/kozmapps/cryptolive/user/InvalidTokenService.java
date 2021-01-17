package com.kozmapps.cryptolive.user;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
final public class InvalidTokenService {
    @NonNull
    InvalidTokenRepository invalidTokenRepository;

    public InvalidToken createInvalidToken(InvalidToken invalidToken) {
        return invalidTokenRepository.insert(invalidToken);
    }

    public boolean verifyToken(String token) {
        return invalidTokenRepository.findByToken(token) == null;
    }
}

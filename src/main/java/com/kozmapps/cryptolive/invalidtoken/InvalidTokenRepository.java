package com.kozmapps.cryptolive.invalidtoken;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvalidTokenRepository extends MongoRepository<InvalidToken, String> {
    InvalidToken findByToken(String token);
}

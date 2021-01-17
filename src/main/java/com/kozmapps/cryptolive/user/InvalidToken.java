package com.kozmapps.cryptolive.user;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
public class InvalidToken {
    @Id
    @NonNull
    String token;

    @NonNull
    @Indexed(name = "expire_date_index", expireAfterSeconds = 33 * 60)
    private DateTime expireDate;
}

package com.kozmapps.cryptolive.favorite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static lombok.AccessLevel.PRIVATE;

@Document
@Data
@Builder
@FieldDefaults(level = PRIVATE)
public class Favorite {
    @JsonIgnore
    @Id
    String compositeKey;

    @JsonIgnore
    String username;

    String coinFromSymbol;

    String coinToSymbol;

    String description;
}

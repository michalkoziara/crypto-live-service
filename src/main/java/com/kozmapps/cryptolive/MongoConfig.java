package com.kozmapps.cryptolive;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString =
                new ConnectionString(
                        "mongodb://" + SecretConstants.username + ":" + SecretConstants.password + "@"
                                + SecretConstants.host + ":" + SecretConstants.port + "/" + getDatabaseName()
                );
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return SecretConstants.databaseName;
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }
}
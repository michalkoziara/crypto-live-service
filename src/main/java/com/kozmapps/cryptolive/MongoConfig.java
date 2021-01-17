package com.kozmapps.cryptolive;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    private static final String username = "admin";
    private static final String password = "password";
    private static final String host = "localhost";
    private static final int port = 27017;

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString =
                new ConnectionString(
                        "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + getDatabaseName()
                );
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected String getDatabaseName() {
        return "cryptolive";
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }
}
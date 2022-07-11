package com.wmm.tickets.infrastructure.adapters.ouput.mongdb.config;

import org.testcontainers.containers.MongoDBContainer;

public class MongoDbTestBase {

    private static MongoDBContainer database = new MongoDBContainer("mongo:5.0");

    static {
        database.start();
    }
}

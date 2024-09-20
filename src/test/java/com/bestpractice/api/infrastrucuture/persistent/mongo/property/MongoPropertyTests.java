package com.bestpractice.api.infrastrucuture.persistent.mongo.property;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MongoPropertyTests {

    @Test
    void testGetHost() {
        MongoProperty mongoProperty = new MongoProperty();
        mongoProperty.setHost("localhost");
        assertEquals("localhost", mongoProperty.getHost());
    }

    @Test
    void testGetPort() {
        MongoProperty mongoProperty = new MongoProperty();
        mongoProperty.setPort(27017);
        assertEquals(27017, mongoProperty.getPort());
    }

    @Test
    void testGetAuthDatabase() {
        MongoProperty mongoProperty = new MongoProperty();
        mongoProperty.setAuthDatabase("admin");
        assertEquals("admin", mongoProperty.getAuthDatabase());
    }

    @Test
    void testGetPlatformDatabase() {
        MongoProperty mongoProperty = new MongoProperty();
        mongoProperty.setPlatformDatabase("platform");
        assertEquals("platform", mongoProperty.getPlatformDatabase());
    }

    @Test
    void testGetUser() {
        MongoProperty mongoProperty = new MongoProperty();
        mongoProperty.setUser("user");
        assertEquals("user", mongoProperty.getUser());
    }

    @Test
    void testGetPassword() {
        MongoProperty mongoProperty = new MongoProperty();
        mongoProperty.setPassword("password");
        assertEquals("password", mongoProperty.getPassword());
    }
}

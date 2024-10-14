package com.bestpractice.api.infrastrucuture.persistent.mongo.property;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MongoPropertyTests {

    private MongoProperty mongoProperty;

    @BeforeEach
    void setUp() {
        mongoProperty = new MongoProperty();
    }

    @Test
    void testGetHost() {
        mongoProperty.setHost("localhost");
        assertEquals("localhost", mongoProperty.getHost());
    }

    @Test
    void testGetPort() {
        mongoProperty.setPort(27017);
        assertEquals(27017, mongoProperty.getPort());
    }

    @Test
    void testGetAuthDatabase() {
        mongoProperty.setAuthDatabase("admin");
        assertEquals("admin", mongoProperty.getAuthDatabase());
    }

    @Test
    void testGetPlatformDatabase() {
        mongoProperty.setPlatformDatabase("platform");
        assertEquals("platform", mongoProperty.getPlatformDatabase());
    }

    @Test
    void testGetUser() {
        mongoProperty.setUser("user");
        assertEquals("user", mongoProperty.getUser());
    }

    @Test
    void testGetPassword() {
        mongoProperty.setPassword("password");
        assertEquals("password", mongoProperty.getPassword());
    }
}

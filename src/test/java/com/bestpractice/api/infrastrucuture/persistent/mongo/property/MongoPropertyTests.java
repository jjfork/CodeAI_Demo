package com.bestpractice.api.infrastrucuture.persistent.mongo.property;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MongoPropertyTests {

    private MongoProperty mongoProperty;

    @BeforeEach
    void setUp() {
        mongoProperty = new MongoProperty();
    }

    @Test
    void testGetHost() {
        // GIVEN - 
        // WHEN - 
        String host = mongoProperty.getHost();
        // THEN - assertEquals(null, host);
    }

    @Test
    void testSetHost() {
        // GIVEN - 
        // WHEN - mongoProperty.setHost("localhost");
        // THEN - assertEquals("localhost", mongoProperty.getHost());
    }

    @Test
    void testGetPort() {
        // GIVEN - 
        // WHEN - int port = mongoProperty.getPort();
        // THEN - assertEquals(0, port);
    }

    @Test
    void testSetPort() {
        // GIVEN - 
        // WHEN - mongoProperty.setPort(27017);
        // THEN - assertEquals(27017, mongoProperty.getPort());
    }

    @Test
    void testGetAuthDatabase() {
        // GIVEN - 
        // WHEN - String authDatabase = mongoProperty.getAuthDatabase();
        // THEN - assertEquals(null, authDatabase);
    }

    @Test
    void testSetAuthDatabase() {
        // GIVEN - 
        // WHEN - mongoProperty.setAuthDatabase("admin");
        // THEN - assertEquals("admin", mongoProperty.getAuthDatabase());
    }

    @Test
    void testGetPlatformDatabase() {
        // GIVEN - 
        // WHEN - String platformDatabase = mongoProperty.getPlatformDatabase();
        // THEN - assertEquals(null, platformDatabase);
    }

    @Test
    void testSetPlatformDatabase() {
        // GIVEN - 
        // WHEN - mongoProperty.setPlatformDatabase("my_platform_db");
        // THEN - assertEquals("my_platform_db", mongoProperty.getPlatformDatabase());
    }

    @Test
    void testGetUser() {
        // GIVEN - 
        // WHEN - String user = mongoProperty.getUser();
        // THEN - assertEquals(null, user);
    }

    @Test
    void testSetUser() {
        // GIVEN - 
        // WHEN - mongoProperty.setUser("my_user");
        // THEN - assertEquals("my_user", mongoProperty.getUser());
    }

    @Test
    void testGetPassword() {
        // GIVEN - 
        // WHEN - String password = mongoProperty.getPassword();
        // THEN - assertEquals(null, password);
    }

    @Test
    void testSetPassword() {
        // GIVEN - 
        // WHEN - mongoProperty.setPassword("my_password");
        // THEN - assertEquals("my_password", mongoProperty.getPassword());
    }
}

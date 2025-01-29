package com.bestpractice.api.infrastrucuture.persistent.mongo.property;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

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
        String expectedHost = "localhost";
        // WHEN - mongoProperty.setHost(expectedHost);
        // THEN - assertEquals(expectedHost, mongoProperty.getHost());
    }

    @Test
    void testGetPort() {
        // GIVEN - 
        // WHEN -  int port = mongoProperty.getPort();
        // THEN - assertEquals(0, port);
    }

    @Test
    void testSetPort() {
        // GIVEN - 
        int expectedPort = 27017;
        // WHEN - mongoProperty.setPort(expectedPort);
        // THEN - assertEquals(expectedPort, mongoProperty.getPort());
    }

    @Test
    void testGetAuthDatabase() {
        // GIVEN - 
        // WHEN -  String authDatabase = mongoProperty.getAuthDatabase();
        // THEN - assertEquals(null, authDatabase);
    }

    @Test
    void testSetAuthDatabase() {
        // GIVEN - 
        String expectedAuthDatabase = "admin";
        // WHEN - mongoProperty.setAuthDatabase(expectedAuthDatabase);
        // THEN - assertEquals(expectedAuthDatabase, mongoProperty.getAuthDatabase());
    }

    @Test
    void testGetPlatformDatabase() {
        // GIVEN - 
        // WHEN -  String platformDatabase = mongoProperty.getPlatformDatabase();
        // THEN - assertEquals(null, platformDatabase);
    }

    @Test
    void testSetPlatformDatabase() {
        // GIVEN - 
        String expectedPlatformDatabase = "platform";
        // WHEN - mongoProperty.setPlatformDatabase(expectedPlatformDatabase);
        // THEN - assertEquals(expectedPlatformDatabase, mongoProperty.getPlatformDatabase());
    }

    @Test
    void testGetUser() {
        // GIVEN - 
        // WHEN -  String user = mongoProperty.getUser();
        // THEN - assertEquals(null, user);
    }

    @Test
    void testSetUser() {
        // GIVEN - 
        String expectedUser = "user";
        // WHEN - mongoProperty.setUser(expectedUser);
        // THEN - assertEquals(expectedUser, mongoProperty.getUser());
    }

    @Test
    void testGetPassword() {
        // GIVEN - 
        // WHEN -  String password = mongoProperty.getPassword();
        // THEN - assertEquals(null, password);
    }

    @Test
    void testSetPassword() {
        // GIVEN - 
        String expectedPassword = "password";
        // WHEN - mongoProperty.setPassword(expectedPassword);
        // THEN - assertEquals(expectedPassword, mongoProperty.getPassword());
    }
}

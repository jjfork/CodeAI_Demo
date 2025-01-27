package com.bestpractice.api.infrastrucuture.persistent.mongo.property;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MongoPropertyTests {

    private MongoProperty mongoProperty;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize a new instance of MongoProperty before each test
        mongoProperty = new MongoProperty();
    }

    @Test
    void testGetSetHost() {
        // GIVEN: A host value to set
        String expectedHost = "localhost";

        // WHEN: Setting the host using setter method
        mongoProperty.setHost(expectedHost);

        // THEN: Verify that the getter returns the correct host value
        assertEquals(expectedHost, mongoProperty.getHost(), "The host should be correctly set and retrieved");
    }

    @Test
    void testGetSetPort() {
        // GIVEN: A port number to set
        int expectedPort = 27017;

        // WHEN: Setting the port using setter method
        mongoProperty.setPort(expectedPort);

        // THEN: Verify that the getter returns the correct port value
        assertEquals(expectedPort, mongoProperty.getPort(), "The port should be correctly set and retrieved");
    }

    @Test
    void testGetSetAuthDatabase() {
        // GIVEN: An authentication database name to set
        String expectedAuthDatabase = "admin";

        // WHEN: Setting the auth database using setter method
        mongoProperty.setAuthDatabase(expectedAuthDatabase);

        // THEN: Verify that the getter returns the correct auth database value
        assertEquals(expectedAuthDatabase, mongoProperty.getAuthDatabase(), "The authentication database should be correctly set and retrieved");
    }

    @Test
    void testGetSetPlatformDatabase() {
        // GIVEN: A platform database name to set
        String expectedPlatformDatabase = "platformDB";

        // WHEN: Setting the platform database using setter method
        mongoProperty.setPlatformDatabase(expectedPlatformDatabase);

        // THEN: Verify that the getter returns the correct platform database value
        assertEquals(expectedPlatformDatabase, mongoProperty.getPlatformDatabase(), "The platform database should be correctly set and retrieved");
    }

    @Test
    void testGetSetUser() {
        // GIVEN: A user name to set
        String expectedUser = "mongoUser";

        // WHEN: Setting the user using setter method
        mongoProperty.setUser(expectedUser);

        // THEN: Verify that the getter returns the correct user value
        assertEquals(expectedUser, mongoProperty.getUser(), "The user should be correctly set and retrieved");
    }

    @Test
    void testGetSetPassword() {
        // GIVEN: A password to set
        String expectedPassword = "securePass123";

        // WHEN: Setting the password using setter method
        mongoProperty.setPassword(expectedPassword);

        // THEN: Verify that the getter returns the correct password value
        assertEquals(expectedPassword, mongoProperty.getPassword(), "The password should be correctly set and retrieved");
    }
}

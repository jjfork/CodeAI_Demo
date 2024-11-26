package com.bestpractice.api.infrastrucuture.persistent.mongo.property;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MongoPropertyTests {

    @Test
    void testDefaultValuesWithSettersAndGetters() {
        // GIVEN: A new instance of MongoProperty
        MongoProperty mongoProperty = new MongoProperty();

        String host = "localhost";
        int port = 27017;
        String authDatabase = "admin";
        String platformDatabase = "platform";
        String user = "mongoUser";
        String password = "mongoPass";

        // WHEN: Setting values using setters
        mongoProperty.setHost(host);
        mongoProperty.setPort(port);
        mongoProperty.setAuthDatabase(authDatabase);
        mongoProperty.setPlatformDatabase(platformDatabase);
        mongoProperty.setUser(user);
        mongoProperty.setPassword(password);

        // THEN: Verify that the values can be retrieved using getters
        assertEquals(host, mongoProperty.getHost());
        assertEquals(port, mongoProperty.getPort());
        assertEquals(authDatabase, mongoProperty.getAuthDatabase());
        assertEquals(platformDatabase, mongoProperty.getPlatformDatabase());
        assertEquals(user, mongoProperty.getUser());
        assertEquals(password, mongoProperty.getPassword());
    }

    @Test
    void testSettingAndGettingIndividualFields() {
        // GIVEN: A new instance of MongoProperty
        MongoProperty mongoProperty = new MongoProperty();

        // WHEN: Setting and getting each field individually
        mongoProperty.setHost("example.com");
        mongoProperty.setPort(12345);
        mongoProperty.setAuthDatabase("authDB");
        mongoProperty.setPlatformDatabase("platformDB");
        mongoProperty.setUser("testUser");
        mongoProperty.setPassword("testPass");

        // THEN: Verify each field is set and retrieved correctly
        assertEquals("example.com", mongoProperty.getHost());
        assertEquals(12345, mongoProperty.getPort());
        assertEquals("authDB", mongoProperty.getAuthDatabase());
        assertEquals("platformDB", mongoProperty.getPlatformDatabase());
        assertEquals("testUser", mongoProperty.getUser());
        assertEquals("testPass", mongoProperty.getPassword());
    }
}

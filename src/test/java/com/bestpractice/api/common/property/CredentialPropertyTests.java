package com.bestpractice.api.common.property;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CredentialPropertyTests {

    private CredentialProperty credentialProperty;

    @BeforeEach
    void setUp() {
        credentialProperty = new CredentialProperty();
    }

    // Test for getKey and setKey methods
    @Test
    void testGetSetKey() {
        // GIVEN a key value to be set
        String expectedKey = "testKey";

        // WHEN setting the key
        credentialProperty.setKey(expectedKey);

        // THEN the get method should return the same key
        assertEquals(expectedKey, credentialProperty.getKey());
    }

    // Test for getProvider and setProvider methods
    @Test
    void testGetSetProvider() {
        // GIVEN a provider value to be set
        String expectedProvider = "testProvider";

        // WHEN setting the provider
        credentialProperty.setProvider(expectedProvider);

        // THEN the get method should return the same provider
        assertEquals(expectedProvider, credentialProperty.getProvider());
    }

    // Test for getSubject and setSubject methods
    @Test
    void testGetSetSubject() {
        // GIVEN a subject value to be set
        String expectedSubject = "testSubject";

        // WHEN setting the subject
        credentialProperty.setSubject(expectedSubject);

        // THEN the get method should return the same subject
        assertEquals(expectedSubject, credentialProperty.getSubject());
    }

    // Test for getAlg and setAlg methods
    @Test
    void testGetSetAlg() {
        // GIVEN an algorithm value to be set
        String expectedAlg = "testAlg";

        // WHEN setting the algorithm
        credentialProperty.setAlg(expectedAlg);

        // THEN the get method should return the same algorithm
        assertEquals(expectedAlg, credentialProperty.getAlg());
    }

    // Test for getHmacSecret and setHmacSecret methods
    @Test
    void testGetSetHmacSecret() {
        // GIVEN an HMAC secret value to be set
        String expectedHmacSecret = "testHmacSecret";

        // WHEN setting the HMAC secret
        credentialProperty.setHmacSecret(expectedHmacSecret);

        // THEN the get method should return the same HMAC secret
        assertEquals(expectedHmacSecret, credentialProperty.getHmacSecret());
    }

    // Test for getExpiresHourStr and setExpiresHourStr methods
    @Test
    void testGetSetExpiresHourStr() {
        // GIVEN an expires hour string value to be set
        String expectedExpiresHourStr = "24";

        // WHEN setting the expires hour string
        credentialProperty.setExpiresHourStr(expectedExpiresHourStr);

        // THEN the get method should return the same expires hour string
        assertEquals(expectedExpiresHourStr, credentialProperty.getExpiresHourStr());
    }

    // Test for convertToIntExpires with valid integer string
    @Test
    void testConvertToIntExpiresValid() {
        // GIVEN a valid integer string
        String validInt = "10";

        // WHEN setting the expires hour string and converting to int
        credentialProperty.setExpiresHourStr(validInt);
        Integer result = credentialProperty.convertToIntExpires();

        // THEN the conversion should return the correct integer value
        assertEquals(10, result);
    }

    // Test for convertToIntExpires with invalid integer string
    @Test
    void testConvertToIntExpiresInvalid() {
        // GIVEN an invalid integer string
        String invalidInt = "abc";

        // WHEN setting the expires hour string and converting to int
        credentialProperty.setExpiresHourStr(invalidInt);
        Integer result = credentialProperty.convertToIntExpires();

        // THEN the conversion should return null
        assertNull(result);
    }

    // Test for convertToIntExpires with "-" indicating no expiration
    @Test
    void testConvertToIntExpiresNoExpiration() {
        // GIVEN a string indicating no expiration
        String noExpiration = "-";

        // WHEN setting the expires hour string and converting to int
        credentialProperty.setExpiresHourStr(noExpiration);
        Integer result = credentialProperty.convertToIntExpires();

        // THEN the conversion should return null
        assertNull(result);
    }
}

package com.bestpractice.api.common.property;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CredentialPropertyTests {
    private CredentialProperty credentialProperty;

    @BeforeEach
    void setUp() {
        credentialProperty = new CredentialProperty();
    }

    @Test
    void testGettersAndSetters() {
        // GIVEN - Set values for the properties
        credentialProperty.setKey("testKey");
        credentialProperty.setProvider("testProvider");
        credentialProperty.setSubject("testSubject");
        credentialProperty.setAlg("testAlg");
        credentialProperty.setHmacSecret("testHmacSecret");
        credentialProperty.setExpiresHourStr("12");

        // THEN - Assert that the getters return the expected values
        assertEquals("testKey", credentialProperty.getKey());
        assertEquals("testProvider", credentialProperty.getProvider());
        assertEquals("testSubject", credentialProperty.getSubject());
        assertEquals("testAlg", credentialProperty.getAlg());
        assertEquals("testHmacSecret", credentialProperty.getHmacSecret());
        assertEquals("12", credentialProperty.getExpiresHourStr());
    }

    @Test
    void testConvertToIntExpires() {
        // GIVEN - Set expiresHourStr to valid and invalid values
        credentialProperty.setExpiresHourStr("12");
        // THEN - Assert that the conversion returns the expected integer value
        assertEquals(12, credentialProperty.convertToIntExpires());

        credentialProperty.setExpiresHourStr("-");
        // THEN - Assert that the conversion returns null for invalid input
        assertNull(credentialProperty.convertToIntExpires());
    }
}

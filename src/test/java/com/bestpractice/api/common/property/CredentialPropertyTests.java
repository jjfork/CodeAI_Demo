package com.bestpractice.api.common.property;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredentialPropertyTests {

    private CredentialProperty credentialProperty;

    @BeforeEach
    void setUp() {
        credentialProperty = new CredentialProperty();
    }

    @Test
    void testGetKey() {
        credentialProperty.setKey("testKey");
        assertEquals("testKey", credentialProperty.getKey());
    }

    @Test
    void testSetProvider() {
        credentialProperty.setProvider("testProvider");
        assertEquals("testProvider", credentialProperty.getProvider());
    }

    @Test
    void testGetSubject() {
        credentialProperty.setSubject("testSubject");
        assertEquals("testSubject", credentialProperty.getSubject());
    }

    @Test
    void testSetAlg() {
        credentialProperty.setAlg("testAlg");
        assertEquals("testAlg", credentialProperty.getAlg());
    }

    @Test
    void testGetHmacSecret() {
        credentialProperty.setHmacSecret("testHmacSecret");
        assertEquals("testHmacSecret", credentialProperty.getHmacSecret());
    }

    @Test
    void testGetExpiresHourStr() {
        credentialProperty.setExpiresHourStr("testExpiresHourStr");
        assertEquals("testExpiresHourStr", credentialProperty.getExpiresHourStr());
    }

    @Test
    void testConvertToIntExpires() {
        credentialProperty.setExpiresHourStr("123");
        assertEquals(123, credentialProperty.convertToIntExpires());
    }

    @Test
    void testConvertToIntExpiresNegative() {
        credentialProperty.setExpiresHourStr("-");
        assertNull(credentialProperty.convertToIntExpires());
    }
}

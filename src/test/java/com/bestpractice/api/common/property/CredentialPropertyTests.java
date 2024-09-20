package com.bestpractice.api.common.property;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CredentialPropertyTests {

    @Test
    void testConvertToIntExpires() {
        CredentialProperty credentialProperty = new CredentialProperty();
        credentialProperty.setExpiresHourStr("12");
        assertEquals(12, credentialProperty.convertToIntExpires().intValue());
    }

    @Test
    void testConvertToIntExpires_Null() {
        CredentialProperty credentialProperty = new CredentialProperty();
        credentialProperty.setExpiresHourStr("-");
        assertNull(credentialProperty.convertToIntExpires());
    }

    @Test
    void testConvertToIntExpires_InvalidInput() {
        CredentialProperty credentialProperty = new CredentialProperty();
        credentialProperty.setExpiresHourStr("abc");
        assertNull(credentialProperty.convertToIntExpires());
    }
}

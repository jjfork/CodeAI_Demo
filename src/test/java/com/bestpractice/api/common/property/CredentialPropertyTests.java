package com.bestpractice.api.common.property;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CredentialPropertyTests {

    @Test
    void testConvertToIntExpiresWhenExpiresHourStrIsMinus() {
        CredentialProperty credentialProperty = new CredentialProperty();
        credentialProperty.setExpiresHourStr("-");
        assertNull(credentialProperty.convertToIntExpires());
    }

    @Test
    void testConvertToIntExpiresWhenExpiresHourStrIsNumeric() {
        CredentialProperty credentialProperty = new CredentialProperty();
        credentialProperty.setExpiresHourStr("5");
        assertEquals(5, credentialProperty.convertToIntExpires());
    }

    @Test
    void testConvertToIntExpiresWhenExpiresHourStrIsNotNumeric() {
        CredentialProperty credentialProperty = new CredentialProperty();
        credentialProperty.setExpiresHourStr("abc");
        assertNull(credentialProperty.convertToIntExpires());
    }
}

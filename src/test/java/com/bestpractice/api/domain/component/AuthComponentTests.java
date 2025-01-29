package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CredentialTests {

    private Credential credential;

    @BeforeEach
    void setUp() {
        credential = new Credential("token", "tokenType", new Date(), false);
    }

    @Test
    void testGetToken() {
        // GIVEN - A Credential object is created.
        // WHEN - The getToken method is called on the credential object.
        String token = credential.getToken();
        // THEN - The returned token should be equal to the token set during object creation.
        assertEquals("token", token);
    }

    @Test
    void testGetTokenType() {
        // GIVEN - A Credential object is created.
        // WHEN - The getTokenType method is called on the credential object.
        String tokenType = credential.getTokenType();
        // THEN - The returned tokenType should be equal to the tokenType set during object creation.
        assertEquals("tokenType", tokenType);
    }

    @Test
    void testGetExp() {
        // GIVEN - A Credential object is created.
        // WHEN - The getExp method is called on the credential object.
        Date exp = credential.getExp();
        // THEN - The returned exp should be equal to the exp set during object creation.
        assertEquals(new Date(), exp);
    }

    @Test
    void testIsRefresh() {
        // GIVEN - A Credential object is created.
        // WHEN - The isRefresh method is called on the credential object.
        boolean isRefresh = credential.isRefresh();
        // THEN - The returned isRefresh should be equal to the isRefresh set during object creation.
        assertFalse(isRefresh);
    }

    @Test
    void testInvalidCredential() {
        assertThrows(IllegalArgumentException.class, () -> new Credential(null, "tokenType", new Date(), false));
    }
}
package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CredentialTests {

    private String token = "testToken";
    private String tokenType = "testTokenType";
    private Date exp = new Date();
    private boolean isRefresh = true;
    private Credential credential;

    @BeforeEach
    void setUp() {
        credential = new Credential(token, tokenType, exp, isRefresh);
    }

    @Test
    void testGetToken() {
        // GIVEN - A Credential object is created
        // WHEN - The getToken method is called
        // THEN - The returned token matches the provided token
        assertEquals(token, credential.getToken());
    }

    @Test
    void testGetTokenType() {
        // GIVEN - A Credential object is created
        // WHEN - The getTokenType method is called
        // THEN - The returned tokenType matches the provided tokenType
        assertEquals(tokenType, credential.getTokenType());
    }

    @Test
    void testGetExp() {
        // GIVEN - A Credential object is created
        // WHEN - The getExp method is called
        // THEN - The returned exp date matches the provided exp date
        assertEquals(exp, credential.getExp());
    }

    @Test
    void testIsRefresh() {
        // GIVEN - A Credential object is created
        // WHEN - The isRefresh method is called
        // THEN - The returned boolean value matches the provided isRefresh value
        assertEquals(isRefresh, credential.isRefresh());
    }
}

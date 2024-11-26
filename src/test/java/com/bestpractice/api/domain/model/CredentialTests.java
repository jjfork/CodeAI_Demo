package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CredentialTests {

    private static final String SAMPLE_TOKEN = "sample_token";
    private static final String SAMPLE_TOKEN_TYPE = "Bearer";
    private static final Date SAMPLE_EXP = new Date();
    private static final boolean SAMPLE_IS_REFRESH = true;

    private Credential credential;

    @BeforeEach
    void setUp() {
        // GIVEN: Setting up a valid Credential object
        credential = new Credential(SAMPLE_TOKEN, SAMPLE_TOKEN_TYPE, SAMPLE_EXP, SAMPLE_IS_REFRESH);
    }

    @Test
    void testGetToken() {
        // WHEN: Retrieving the token
        String token = credential.getToken();

        // THEN: The token should match the expected value
        assertNotNull(token, "Token should not be null");
        assertEquals(SAMPLE_TOKEN, token, "Token should match the initialized value");
    }

    @Test
    void testGetTokenType() {
        // WHEN: Retrieving the token type
        String tokenType = credential.getTokenType();

        // THEN: The token type should match the expected value
        assertNotNull(tokenType, "Token type should not be null");
        assertEquals(SAMPLE_TOKEN_TYPE, tokenType, "Token type should match the initialized value");
    }

    @Test
    void testGetExp() {
        // WHEN: Retrieving the expiration date
        Date exp = credential.getExp();

        // THEN: The expiration date should match the expected value
        assertNotNull(exp, "Expiration date should not be null");
        assertEquals(SAMPLE_EXP, exp, "Expiration date should match the initialized value");
    }

    @Test
    void testIsRefresh() {
        // WHEN: Retrieving the refresh status
        boolean isRefresh = credential.isRefresh();

        // THEN: The refresh status should match the expected value
        assertEquals(SAMPLE_IS_REFRESH, isRefresh, "Refresh status should match the initialized value");
    }
}
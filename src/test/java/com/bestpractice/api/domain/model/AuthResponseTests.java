package com.bestpractice.api.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;

public class AuthResponseTests {

    private static final String SAMPLE_TOKEN_TYPE = "Bearer";
    private static final String SAMPLE_TOKEN = "sample_token";
    private static final String SAMPLE_REFRESH_TOKEN = "sample_refresh_token";
    private static final Date SAMPLE_EXPIRES_AT = new Date();

    private AuthResponse authResponse;

    @BeforeEach
    void setUp() {
        // GIVEN: Setting up a valid AuthResponse object
        authResponse = new AuthResponse(SAMPLE_TOKEN_TYPE, SAMPLE_TOKEN, SAMPLE_REFRESH_TOKEN, SAMPLE_EXPIRES_AT);
    }

    @Test
    void testGetTokenType() {
        // WHEN: Retrieving the token type
        String tokenType = authResponse.getTokenType();

        // THEN: The token type should match the expected value
        assertNotNull(tokenType, "Token type should not be null");
        assertEquals(SAMPLE_TOKEN_TYPE, tokenType, "Token type should match the initialized value");
    }

    @Test
    void testGetToken() {
        // WHEN: Retrieving the token
        String token = authResponse.getToken();

        // THEN: The token should match the expected value
        assertNotNull(token, "Token should not be null");
        assertEquals(SAMPLE_TOKEN, token, "Token should match the initialized value");
    }

    @Test
    void testGetRefreshToken() {
        // WHEN: Retrieving the refresh token
        String refreshToken = authResponse.getRefreshToken();

        // THEN: The refresh token should match the expected value
        assertNotNull(refreshToken, "Refresh token should not be null");
        assertEquals(SAMPLE_REFRESH_TOKEN, refreshToken, "Refresh token should match the initialized value");
    }

    @Test
    void testGetExpiresAt() {
        // WHEN: Retrieving the expiration date
        Date expiresAt = authResponse.getExpiresAt();

        // THEN: The expiration date should match the expected value
        assertNotNull(expiresAt, "Expiration date should not be null");
        assertEquals(SAMPLE_EXPIRES_AT, expiresAt, "Expiration date should match the initialized value");
    }


}
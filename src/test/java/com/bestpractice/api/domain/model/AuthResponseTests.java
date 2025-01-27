package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthResponseTests {

    private String tokenType;
    private String token;
    private String refreshToken;
    private Date expiresAt;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize variables with sample data for each test case.
        tokenType = "Bearer";
        token = "sampleToken12345";
        refreshToken = "refreshSampleToken67890";
        expiresAt = new Date(System.currentTimeMillis() + 3600 * 1000); // 1 hour from now
    }

    @Test
    void shouldReturnCorrectTokenType() {
        // GIVEN: Create an AuthResponse object with predefined values.
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);

        // WHEN: Retrieve the token type using getTokenType method.
        String retrievedTokenType = authResponse.getTokenType();

        // THEN: Verify that the returned token type matches the expected value.
        assertEquals("Bearer", retrievedTokenType);
    }

    @Test
    void shouldReturnCorrectToken() {
        // GIVEN: Create an AuthResponse object with predefined values.
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);

        // WHEN: Retrieve the token using getToken method.
        String retrievedToken = authResponse.getToken();

        // THEN: Verify that the returned token matches the expected value.
        assertEquals("sampleToken12345", retrievedToken);
    }

    @Test
    void shouldReturnCorrectRefreshToken() {
        // GIVEN: Create an AuthResponse object with predefined values.
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);

        // WHEN: Retrieve the refresh token using getRefreshToken method.
        String retrievedRefreshToken = authResponse.getRefreshToken();

        // THEN: Verify that the returned refresh token matches the expected value.
        assertEquals("refreshSampleToken67890", retrievedRefreshToken);
    }

    @Test
    void shouldReturnCorrectExpiresAt() {
        // GIVEN: Create an AuthResponse object with predefined values.
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);

        // WHEN: Retrieve the expiration date using getExpiresAt method.
        Date retrievedExpiresAt = authResponse.getExpiresAt();

        // THEN: Verify that the returned expiration date is not null and matches the expected value.
        assertNotNull(retrievedExpiresAt);
        assertEquals(expiresAt.getTime(), retrievedExpiresAt.getTime());
    }
}

package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthByRefreshTokenRequestTests {

    private AuthByRefreshTokenRequest authByRefreshTokenRequest;

    @BeforeEach
    void setUp() {
        authByRefreshTokenRequest = new AuthByRefreshTokenRequest();
    }

    @Test
    void givenValidRefreshToken_whenSetRefreshToken_thenGetRefreshTokenReturnsSameValue() {
        // GIVEN: A valid refresh token
        String refreshToken = "validRefreshToken123";

        // WHEN: Setting the refresh token
        authByRefreshTokenRequest.setRefreshToken(refreshToken);

        // THEN: The getRefreshToken method should return the same value
        assertEquals(refreshToken, authByRefreshTokenRequest.getRefreshToken(), "getRefreshToken should return the set refresh token");
    }

    @Test
    void givenNullRefreshToken_whenSetRefreshToken_thenGetRefreshTokenReturnsNull() {
        // GIVEN: A null refresh token
        String refreshToken = null;

        // WHEN: Setting the refresh token
        authByRefreshTokenRequest.setRefreshToken(refreshToken);

        // THEN: The getRefreshToken method should return null
        assertNull(authByRefreshTokenRequest.getRefreshToken(), "getRefreshToken should return null when refresh token is not set");
    }

    @Test
    void givenEmptyRefreshToken_whenSetRefreshToken_thenGetRefreshTokenReturnsEmptyString() {
        // GIVEN: An empty refresh token
        String refreshToken = "";

        // WHEN: Setting the refresh token
        authByRefreshTokenRequest.setRefreshToken(refreshToken);

        // THEN: The getRefreshToken method should return an empty string
        assertEquals(refreshToken, authByRefreshTokenRequest.getRefreshToken(), "getRefreshToken should return the set empty string");
    }

    @Test
    void givenValidRefreshToken_whenSetAndGet_thenValidationAnnotationsShouldAllowIt() {
        // GIVEN: A valid refresh token (manual validation is expected to respect @NotNull annotation)
        String refreshToken = "validToken";

        // WHEN: Setting the refresh token
        authByRefreshTokenRequest.setRefreshToken(refreshToken);

        // THEN: The field contains the set value
        assertEquals(refreshToken, authByRefreshTokenRequest.getRefreshToken(), "The refreshToken field should hold the set valid value");
    }

    @Test
    void givenNullRefreshToken_whenSetAndGet_thenValidationAnnotationsShouldFlagItElsewhere() {
        // GIVEN: A null refresh token
        String refreshToken = null;

        // WHEN: Setting the refresh token
        authByRefreshTokenRequest.setRefreshToken(refreshToken);

        // THEN: The field contains null, but validation occurs externally
        assertNull(authByRefreshTokenRequest.getRefreshToken(), "The refreshToken field should hold null when set");
    }
}
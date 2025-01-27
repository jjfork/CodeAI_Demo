package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthByRefreshTokenRequestTests {

    private AuthByRefreshTokenRequest authByRefreshTokenRequest;

    @BeforeEach
    void setUp() {
        authByRefreshTokenRequest = new AuthByRefreshTokenRequest();
    }

    @Test
    void getSetRefreshToken_ShouldReturnCorrectValue() {
        // GIVEN a valid refresh token string
        String expectedRefreshToken = "valid-refresh-token";

        // WHEN setting the refreshToken using setRefreshToken method
        authByRefreshTokenRequest.setRefreshToken(expectedRefreshToken);

        // THEN getting the refreshToken using getRefreshToken should return the same value
        assertEquals(expectedRefreshToken, authByRefreshTokenRequest.getRefreshToken(), "The returned refresh token should match the one that was set.");
    }

    @Test
    void getSetRefreshToken_ShouldHandleNullValue() {
        // GIVEN a null refresh token string

        // WHEN setting the refreshToken using setRefreshToken method with null value
        authByRefreshTokenRequest.setRefreshToken(null);

        // THEN getting the refreshToken using getRefreshToken should return null
        assertNull(authByRefreshTokenRequest.getRefreshToken(), "The returned refresh token should be null when a null value is set.");
    }

    @Test
    void getSetRefreshToken_ShouldHandleEmptyString() {
        // GIVEN an empty string as refresh token

        // WHEN setting the refreshToken using setRefreshToken method with an empty string
        authByRefreshTokenRequest.setRefreshToken("");

        // THEN getting the refreshToken using getRefreshToken should return an empty string
        assertEquals("", authByRefreshTokenRequest.getRefreshToken(), "The returned refresh token should be an empty string when an empty string is set.");
    }

    @Test
    void getSetRefreshToken_ShouldHandleWhitespaceString() {
        // GIVEN a whitespace-only string as refresh token

        // WHEN setting the refreshToken using setRefreshToken method with a whitespace string
        authByRefreshTokenRequest.setRefreshToken("   ");

        // THEN getting the refreshToken using getRefreshToken should return the same whitespace string
        assertEquals("   ", authByRefreshTokenRequest.getRefreshToken(), "The returned refresh token should be the same whitespace string when it is set.");
    }
}

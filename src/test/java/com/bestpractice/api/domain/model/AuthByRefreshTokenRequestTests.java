package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthByRefreshTokenRequestTests {

    private AuthByRefreshTokenRequest authByRefreshTokenRequest;

    @BeforeEach
    void setUp() {
        authByRefreshTokenRequest = new AuthByRefreshTokenRequest();
    }

    @Test
    void testGetRefreshToken() {
        // GIVEN - A new instance of AuthByRefreshTokenRequest
        // WHEN - The getRefreshToken method is called
        String refreshToken = authByRefreshTokenRequest.getRefreshToken();
        // THEN - The returned refreshToken should be null
        assertEquals(null, refreshToken);
    }

    @Test
    void testSetRefreshToken() {
        // GIVEN - A new instance of AuthByRefreshTokenRequest
        // WHEN - The setRefreshToken method is called with a value
        authByRefreshTokenRequest.setRefreshToken("testRefreshToken");
        // THEN - The refreshToken should be set to the provided value
        assertEquals("testRefreshToken", authByRefreshTokenRequest.getRefreshToken());
    }
}

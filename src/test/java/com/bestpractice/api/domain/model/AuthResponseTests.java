package com.bestpractice.api.domain.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthResponseTests {

    private String tokenType;
    private String token;
    private String refreshToken;
    private Date expiresAt;

    @BeforeEach
    void setUp() {
        tokenType = "Bearer";
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        expiresAt = new Date();
    }

    @Test
    void testGetTokenType() {
        // GIVEN
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
        // WHEN
        String actualTokenType = authResponse.getTokenType();
        // THEN
        assertEquals(tokenType, actualTokenType);
    }

    @Test
    void testGetToken() {
        // GIVEN
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
        // WHEN
        String actualToken = authResponse.getToken();
        // THEN
        assertEquals(token, actualToken);
    }

    @Test
    void testGetRefreshToken() {
        // GIVEN
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
        // WHEN
        String actualRefreshToken = authResponse.getRefreshToken();
        // THEN
        assertEquals(refreshToken, actualRefreshToken);
    }

    @Test
    void testGetExpiresAt() {
        // GIVEN
        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
        // WHEN
        Date actualExpiresAt = authResponse.getExpiresAt();
        // THEN
        assertEquals(expiresAt, actualExpiresAt);
    }
}

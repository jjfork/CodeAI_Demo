package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

class AuthResponseTests {

    @Test
    void testGetTokenType() {
        AuthResponse authResponse = new AuthResponse("type", "token", "refreshToken", new Date());
        assertEquals("type", authResponse.getTokenType());
    }

    @Test
    void testGetToken() {
        AuthResponse authResponse = new AuthResponse("type", "token", "refreshToken", new Date());
        assertEquals("token", authResponse.getToken());
    }

    @Test
    void testGetRefreshToken() {
        AuthResponse authResponse = new AuthResponse("type", "token", "refreshToken", new Date());
        assertEquals("refreshToken", authResponse.getRefreshToken());
    }

    @Test
    void testGetExpiresAt() {
        Date expiresAt = new Date();
        AuthResponse authResponse = new AuthResponse("type", "token", "refreshToken", expiresAt);
        assertEquals(expiresAt, authResponse.getExpiresAt());
    }
}

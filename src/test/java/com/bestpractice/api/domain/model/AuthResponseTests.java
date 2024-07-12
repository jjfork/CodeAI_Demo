package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

public class AuthResponseTests {

    @ExtendWith(MockitoExtension.class)
    @Test
    void testConstructor() {
        String tokenType = "Bearer";
        String token = "some-token";
        String refreshToken = "some-refresh-token";
        Date expiresAt = new Date();

        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);

        assertEquals(tokenType, authResponse.getTokenType());
        assertEquals(token, authResponse.getToken());
        assertEquals(refreshToken, authResponse.getRefreshToken());
        assertNotNull(authResponse.getExpiresAt());
    }

    @ExtendWith(MockitoExtension.class)
    @Test
    void testGetterMethods() {
        String tokenType = "Bearer";
        String token = "some-token";
        String refreshToken = "some-refresh-token";
        Date expiresAt = new Date();

        AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);

        assertEquals(tokenType, authResponse.getTokenType());
        assertEquals(token, authResponse.getToken());
        assertEquals(refreshToken, authResponse.getRefreshToken());
        assertNotNull(authResponse.getExpiresAt());
    }
}
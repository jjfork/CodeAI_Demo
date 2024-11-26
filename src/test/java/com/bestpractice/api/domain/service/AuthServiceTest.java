package com.bestpractice.api.domain.service;

import com.bestpractice.api.domain.model.AuthResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;

class AuthServiceTests {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = mock(AuthService.class);
    }

    @Test
    void testLoginWithEmailAndPassword_Success() {
        // GIVEN: Valid email and password
        String email = "test@example.com";
        String password = "securepassword";

        // Creating mock AuthResponse
        AuthResponse mockResponse = new AuthResponse("Bearer", "access-token", "refresh-token", new Date());

        when(authService.login(email, password)).thenReturn(mockResponse);

        // WHEN: login is invoked with valid email and password
        AuthResponse result = authService.login(email, password);

        // THEN: Ensure the response contains valid access and refresh tokens
        assertNotNull(result);
        assertEquals("Bearer", result.getTokenType());
        assertEquals("access-token", result.getToken());
        assertEquals("refresh-token", result.getRefreshToken());
        assertNotNull(result.getExpiresAt());  // Check if expiration date is not null
        verify(authService).login(email, password);
    }

    @Test
    void testLoginWithEmailAndPassword_Failure() {
        // GIVEN: Invalid email and password
        String email = "test@example.com";
        String password = "wrongpassword";

        when(authService.login(email, password)).thenReturn(null);

        // WHEN: login is invoked with invalid email and password
        AuthResponse result = authService.login(email, password);

        // THEN: Ensure the response is null
        assertNull(result);
        verify(authService).login(email, password);
    }

    @Test
    void testLoginWithRefreshToken_Success() {
        // GIVEN: Valid refresh token
        String refreshToken = "valid-refresh-token";

        // Creating mock AuthResponse
        AuthResponse mockResponse = new AuthResponse("Bearer", "new-access-token", "new-refresh-token", new Date());

        when(authService.login(refreshToken)).thenReturn(mockResponse);

        // WHEN: login is invoked with a valid refresh token
        AuthResponse result = authService.login(refreshToken);

        // THEN: Ensure the response contains new access and refresh tokens
        assertNotNull(result);
        assertEquals("Bearer", result.getTokenType());
        assertEquals("new-access-token", result.getToken());
        assertEquals("new-refresh-token", result.getRefreshToken());
        assertNotNull(result.getExpiresAt());  // Check if expiration date is not null
        verify(authService).login(refreshToken);
    }

    @Test
    void testLoginWithRefreshToken_Failure() {
        // GIVEN: Invalid refresh token
        String refreshToken = "invalid-refresh-token";

        when(authService.login(refreshToken)).thenReturn(null);

        // WHEN: login is invoked with an invalid refresh token
        AuthResponse result = authService.login(refreshToken);

        // THEN: Ensure the response is null
        assertNull(result);
        verify(authService).login(refreshToken);
    }
}

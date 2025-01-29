package com.bestpractice.api.app.v1;

    @Test

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
    void testLoginWithRefreshToken() {
        // GIVEN
        String refreshToken = "some_refresh_token";
        AuthResponse authResponse = new AuthResponse("Bearer", "token123", "refresh_token456", null);

        // WHEN
        when(authService.login(new AuthByRefreshTokenRequest(refreshToken))).thenReturn(authResponse);
        AuthResponse result = authController.loginWithRefreshToken(refreshToken);

        // THEN
        assertEquals(authResponse, result);
        verify(authService).login(new AuthByRefreshTokenRequest(refreshToken));
    }

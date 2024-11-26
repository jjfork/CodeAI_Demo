package com.bestpractice.api.app.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.domain.model.AuthByEmailRequest;
import com.bestpractice.api.domain.model.AuthByRefreshTokenRequest;
import com.bestpractice.api.domain.model.AuthResponse;
import com.bestpractice.api.domain.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.Date;

class AuthControllerTests {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testOptionsAuth() {
        // GIVEN: A call to the OPTIONS endpoint
        // No preconditions are necessary

        // WHEN: Calling the optionsAuth method
        ResponseEntity<Object> response = authController.optionsAuth();

        // THEN: The response headers should allow "POST, OPTIONS" and status should be OK
        assertNotNull(response, "Response should not be null");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Status code should be 200 OK");
        assertEquals("POST,OPTIONS", response.getHeaders().getFirst("Allow"), "Allow header should match");
        assertEquals("*", response.getHeaders().getFirst("Access-Control-Allow-Origin"), "CORS header should match");
    }

    @Test
    void testLoginByEmailSuccess() {
        // GIVEN: A valid AuthByEmailRequest and no BindingResult errors
        AuthByEmailRequest request = new AuthByEmailRequest();
        request.setEmail("user@example.com");
        request.setPassword("password123");

        BindingResult bdResult = mock(BindingResult.class);
        when(bdResult.hasErrors()).thenReturn(false);

        Date expiresAt = new Date();
        AuthResponse expectedResponse = new AuthResponse("Bearer", "accessToken", "refreshToken", expiresAt);
        when(authService.login(request.getEmail(), request.getPassword())).thenReturn(expectedResponse);

        // WHEN: Calling the login method with valid email credentials
        AuthResponse response = authController.login(request, bdResult);

        // THEN: The response should match the expected AuthResponse
        assertNotNull(response, "Response should not be null");
        assertEquals(expectedResponse.getTokenType(), response.getTokenType(), "Token type should match");
        assertEquals(expectedResponse.getToken(), response.getToken(), "Access token should match");
        assertEquals(expectedResponse.getRefreshToken(), response.getRefreshToken(), "Refresh token should match");
        assertEquals(expectedResponse.getExpiresAt(), response.getExpiresAt(), "ExpiresAt should match");
    }

    @Test
    void testLoginByEmailFailureBindingErrors() {
        // GIVEN: An AuthByEmailRequest with BindingResult errors
        AuthByEmailRequest request = new AuthByEmailRequest();
        request.setEmail("invalid");
        request.setPassword("");

        BindingResult bdResult = mock(BindingResult.class);
        when(bdResult.hasErrors()).thenReturn(true);
        when(bdResult.getObjectName()).thenReturn("AuthByEmailRequest");

        // WHEN: Calling the login method with invalid email credentials
        // THEN: A BadRequest exception should be thrown
        try {
            authController.login(request, bdResult);
        } catch (BadRequest ex) {
            assertEquals("AuthByEmailRequest", ex.getMessage(), "Error message should match");
        }
    }

    @Test
    void testLoginByRefreshTokenSuccess() {
        // GIVEN: A valid AuthByRefreshTokenRequest and no BindingResult errors
        AuthByRefreshTokenRequest request = new AuthByRefreshTokenRequest();
        request.setRefreshToken("validRefreshToken");

        BindingResult bdResult = mock(BindingResult.class);
        when(bdResult.hasErrors()).thenReturn(false);

        Date expiresAt = new Date();
        AuthResponse expectedResponse = new AuthResponse("Bearer", "newAccessToken", "newRefreshToken", expiresAt);
        when(authService.login(request.getRefreshToken())).thenReturn(expectedResponse);

        // WHEN: Calling the login method with a valid refresh token
        AuthResponse response = authController.login(request, bdResult);

        // THEN: The response should match the expected AuthResponse
        assertNotNull(response, "Response should not be null");
        assertEquals(expectedResponse.getTokenType(), response.getTokenType(), "Token type should match");
        assertEquals(expectedResponse.getToken(), response.getToken(), "Access token should match");
        assertEquals(expectedResponse.getRefreshToken(), response.getRefreshToken(), "Refresh token should match");
        assertEquals(expectedResponse.getExpiresAt(), response.getExpiresAt(), "ExpiresAt should match");
    }

    @Test
    void testLoginByRefreshTokenFailureBindingErrors() {
        // GIVEN: An AuthByRefreshTokenRequest with BindingResult errors
        AuthByRefreshTokenRequest request = new AuthByRefreshTokenRequest();
        request.setRefreshToken("");

        BindingResult bdResult = mock(BindingResult.class);
        when(bdResult.hasErrors()).thenReturn(true);
        when(bdResult.getObjectName()).thenReturn("AuthByRefreshTokenRequest");

        // WHEN: Calling the login method with an invalid refresh token
        // THEN: A BadRequest exception should be thrown
        try {
            authController.login(request, bdResult);
        } catch (BadRequest ex) {
            assertEquals("AuthByRefreshTokenRequest", ex.getMessage(), "Error message should match");
        }
    }
}

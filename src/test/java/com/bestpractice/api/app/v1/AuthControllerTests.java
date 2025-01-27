package com.bestpractice.api.app.v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.domain.model.AuthByEmailRequest;
import com.bestpractice.api.domain.model.AuthByRefreshTokenRequest;
import com.bestpractice.api.domain.model.AuthResponse;
import com.bestpractice.api.domain.service.AuthService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTests {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        // Reset mocks before each test to ensure independence
        reset(authService);
    }

    @Test
    public void optionsAuth_ShouldReturnAllowHeaderWithPostAndOptions() {
        // GIVEN: A request for OPTIONS method on /api/v1/auth endpoint

        // WHEN: The optionsAuth method is called
        var response = authController.optionsAuth();

        // THEN: The response should contain the correct headers and status
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("POST,OPTIONS", response.getHeaders().getFirst("Allow"));
        assertEquals("*", response.getHeaders().getFirst("Access-Control-Allow-Origin"));
    }

    @Test
    public void loginWithRefreshToken_ShouldReturnAuthResponse_WhenValidRequest() {
        // GIVEN: A valid AuthByRefreshTokenRequest and a mocked AuthService
        AuthByRefreshTokenRequest request = new AuthByRefreshTokenRequest();
        request.setRefreshToken("refreshToken123");

        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);

        AuthResponse expectedAuthResponse = new AuthResponse("Bearer", "token456", "newRefreshToken123", null);
        when(authService.login(anyString())).thenReturn(expectedAuthResponse);

        // WHEN: The login method is called with a valid request
        var response = authController.login(request, bindingResult);

        // THEN: An AuthResponse should be returned
        assertNotNull(response);
        assertEquals("Bearer", response.getTokenType());
        assertEquals("token456", response.getToken());
    }
}

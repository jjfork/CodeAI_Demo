package com.bestpractice.api.domain.service;

import com.bestpractice.api.domain.component.AuthComponent;
import com.bestpractice.api.domain.component.BCryptPasswordEncryptionComponent;
import com.bestpractice.api.domain.model.AuthResponse;
import com.bestpractice.api.domain.model.Credential;
import com.bestpractice.api.infrastrucuture.entity.User;
import com.bestpractice.api.infrastrucuture.persistent.UserPersistentRepository;
import com.bestpractice.api.common.exception.UnAuthorized;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceImplTests {

    private AuthServiceImpl authService;
    private BCryptPasswordEncryptionComponent encryptionComponent;
    private AuthComponent authComponent;
    private UserPersistentRepository userPersistentRepository;

    @BeforeEach
    void setUp() {
        encryptionComponent = mock(BCryptPasswordEncryptionComponent.class);
        authComponent = mock(AuthComponent.class);
        userPersistentRepository = mock(UserPersistentRepository.class);
        authService = new AuthServiceImpl(encryptionComponent, authComponent, userPersistentRepository);
    }

    @Test
    void testLoginWithEmailAndPassword_Success() {
        // GIVEN: Valid email and password
        String email = "test@example.com";
        String password = "securepassword";

        // Mock user and expected responses
        User mockUser = new User();
        mockUser.setId(String.valueOf(1L));
        mockUser.setEmail(email);
        mockUser.setPassword("encryptedPassword");

        when(userPersistentRepository.findByEmail(email)).thenReturn(mockUser);
        when(encryptionComponent.matchedPassword(password, mockUser.getPassword())).thenReturn(true);

        Credential mockToken = new Credential("access-token", "Bearer", new Date(), false);
        Credential mockRefreshToken = new Credential("refresh-token", "Bearer", new Date(), true);

        when(authComponent.generateJwt(String.valueOf(1L), email, false)).thenReturn(mockToken);
        when(authComponent.generateJwt(String.valueOf(1L), email, true)).thenReturn(mockRefreshToken);

        // WHEN: login is invoked with email and password
        AuthResponse result = authService.login(email, password);

        // THEN: Ensure the response contains valid access and refresh tokens
        assertNotNull(result);
        assertEquals("Bearer", result.getTokenType());
        assertEquals("access-token", result.getToken());
        assertEquals("refresh-token", result.getRefreshToken());
        assertNotNull(result.getExpiresAt());  // Check if expiration date is not null
    }

    @Test
    void testLoginWithEmailAndPassword_Failure_UserNotFound() {
        // GIVEN: Invalid email
        String email = "nonexistent@example.com";
        String password = "anyPassword";

        when(userPersistentRepository.findByEmail(email)).thenReturn(null);

        // WHEN: login is invoked with email and password
        UnAuthorized thrown = assertThrows(UnAuthorized.class, () -> {
            authService.login(email, password);
        });

        // THEN: Ensure the exception is thrown with the correct message
        assertEquals("Email or password is invalid", thrown.getMessage());
    }

    @Test
    void testLoginWithEmailAndPassword_Failure_InvalidPassword() {
        // GIVEN: Valid email but incorrect password
        String email = "test@example.com";
        String password = "wrongpassword";

        User mockUser = new User();
        mockUser.setId(String.valueOf(1L));
        mockUser.setEmail(email);
        mockUser.setPassword("encryptedPassword");

        when(userPersistentRepository.findByEmail(email)).thenReturn(mockUser);
        when(encryptionComponent.matchedPassword(password, mockUser.getPassword())).thenReturn(false);

        // WHEN: login is invoked with invalid password
        UnAuthorized thrown = assertThrows(UnAuthorized.class, () -> {
            authService.login(email, password);
        });

        // THEN: Ensure the exception is thrown with the correct message
        assertEquals("Email or password is invalid", thrown.getMessage());
    }



}

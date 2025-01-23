package com.bestpractice.api.domain.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.InternalServerError;
import com.bestpractice.api.common.exception.UnAuthorized;
import com.bestpractice.api.domain.component.BCryptPasswordEncryptionComponent;
import com.bestpractice.api.domain.model.UserRequest;
import com.bestpractice.api.domain.model.UserResponse;
import com.bestpractice.api.infrastrucuture.entity.User;
import com.bestpractice.api.infrastrucuture.persistent.UserPersistentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTests {

    @Mock
    private UserPersistentRepository userRepository;

    @Mock
    private BCryptPasswordEncryptionComponent encryptionComponent;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById_ReturnsUser() {
        // GIVEN
        String id = "testId";
        User user = new User(id, "testUsername", "testEmail", "testPassword");
        when(userRepository.findById(id)).thenReturn(user);

        // WHEN
        User returnedUser = userService.getUserById(id);

        // THEN
        assertEquals(user, returnedUser);
    }

    @Test
    void testGetUserById_ReturnsNull() {
        // GIVEN
        String id = "testId";
        when(userRepository.findById(id)).thenReturn(null);

        // WHEN
        User returnedUser = userService.getUserById(id);

        // THEN
        assertNull(returnedUser);
    }

    @Test
    void testGetAuthenticatedUser_ReturnsUser() {
        // GIVEN
        String email = "testEmail";
        String rawPassword = "testPassword";
        User user = new User("testId", "testUsername", email, "hashedPassword");
        when(userRepository.findByEmail(email)).thenReturn(user);
        when(encryptionComponent.matchedPassword(user.getPassword(), rawPassword)).thenReturn(true);

        // WHEN
        User returnedUser = userService.getAuthenticatedUser(email, rawPassword);

        // THEN
        assertEquals(user, returnedUser);
    }

    @Test
    void testGetAuthenticatedUser_ThrowsUnAuthorized_EmailNotFound() {
        // GIVEN
        String email = "testEmail";
        String rawPassword = "testPassword";
        when(userRepository.findByEmail(email)).thenReturn(null);

        // WHEN
        assertThrows(UnAuthorized.class, () -> userService.getAuthenticatedUser(email, rawPassword));
    }

    @Test
    void testGetAuthenticatedUser_ThrowsUnAuthorized_PasswordMismatch() {
        // GIVEN
        String email = "testEmail";
        String rawPassword = "testPassword";
        User user = new User("testId", "testUsername", email, "hashedPassword");
        when(userRepository.findByEmail(email)).thenReturn(user);
        when(encryptionComponent.matchedPassword(user.getPassword(), rawPassword)).thenReturn(false);

        // WHEN
        assertThrows(UnAuthorized.class, () -> userService.getAuthenticatedUser(email, rawPassword));
    }    

}
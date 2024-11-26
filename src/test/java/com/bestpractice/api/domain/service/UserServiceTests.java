package com.bestpractice.api.domain.service;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTests {

    private UserPersistentRepository mockUserRepository;
    private BCryptPasswordEncryptionComponent mockEncryptionComponent;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        mockUserRepository = mock(UserPersistentRepository.class);
        mockEncryptionComponent = mock(BCryptPasswordEncryptionComponent.class);

        // Initialize service with mocks
        userService = new UserServiceImpl(mockUserRepository, mockEncryptionComponent);
    }

    @Test
    void testGetUserById_Success() {
        // GIVEN: A user exists with the specified ID
        String userId = "123";
        User user = new User();
        user.setId(userId);
        user.setEmail("test@example.com");

        when(mockUserRepository.findById(userId)).thenReturn(user);

        // WHEN: getUserById is called
        User result = userService.getUserById(userId);

        // THEN: The correct user is returned
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("test@example.com", result.getEmail());
    }

    @Test
    void testGetUserById_UserNotFound() {
        // GIVEN: No user exists for the given ID
        String userId = "123";
        when(mockUserRepository.findById(userId)).thenReturn(null);

        // WHEN: getUserById is called
        User result = userService.getUserById(userId);

        // THEN: The result should be null
        assertNull(result);
    }

    @Test
    void testGetAuthenticatedUser_Success() {
        // GIVEN: A valid email and password for an existing user
        String email = "test@example.com";
        String rawPassword = "rawPassword";
        String hashedPassword = "hashedPassword";

        User user = new User();
        user.setId("123");
        user.setEmail(email);
        user.setPassword(hashedPassword);

        when(mockUserRepository.findByEmail(email)).thenReturn(user);
        when(mockEncryptionComponent.matchedPassword(hashedPassword, rawPassword)).thenReturn(true);

        // WHEN: getAuthenticatedUser is called
        User result = userService.getAuthenticatedUser(email, rawPassword);

        // THEN: The authenticated user is returned
        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals(email, result.getEmail());
    }

    @Test
    void testGetAuthenticatedUser_InvalidPassword() {
        // GIVEN: An incorrect password for an existing user
        String email = "test@example.com";
        String rawPassword = "wrongPassword";
        String hashedPassword = "hashedPassword";

        User user = new User();
        user.setId("123");
        user.setEmail(email);
        user.setPassword(hashedPassword);

        when(mockUserRepository.findByEmail(email)).thenReturn(user);
        when(mockEncryptionComponent.matchedPassword(hashedPassword, rawPassword)).thenReturn(false);

        // WHEN: getAuthenticatedUser is called
        assertThrows(UnAuthorized.class, () -> userService.getAuthenticatedUser(email, rawPassword));

        // THEN: UnAuthorized exception is thrown
    }

    @Test
    void testGetAuthenticatedUser_UserNotFound() {
        // GIVEN: No user exists for the given email
        String email = "test@example.com";
        when(mockUserRepository.findByEmail(email)).thenReturn(null);

        // WHEN: getAuthenticatedUser is called
        assertThrows(UnAuthorized.class, () -> userService.getAuthenticatedUser(email, "password"));

        // THEN: UnAuthorized exception is thrown
    }

    @Test
    void testGenerateUser_Success() {
        // GIVEN: A valid UserRequest object
        String userId = "123";
        UserRequest request = new UserRequest();
        request.setUsername("newuser");
        request.setEmail("newuser@example.com");
        request.setPassword("rawPassword");

        User user = new User();
        user.setId(userId);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword("hashedPassword");

        when(mockUserRepository.newId()).thenReturn(userId);
        when(mockEncryptionComponent.encodePassword(request.getPassword())).thenReturn("hashedPassword");
        when(mockUserRepository.insert(any(User.class))).thenReturn(user);

        // WHEN: generateUser is called
        UserResponse result = userService.generateUser(request);

        // THEN: The result should contain the new user's details
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("newuser", result.getUsername());
        assertEquals("newuser@example.com", result.getEmail());
    }

    @Test
    void testGenerateUser_Conflict() {
        // GIVEN: A UserRequest that causes a conflict during insertion
        UserRequest request = new UserRequest();
        request.setUsername("newuser");
        request.setEmail("newuser@example.com");
        request.setPassword("rawPassword");

        User user = new User();
        user.setId("123");
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword("hashedPassword");

        when(mockUserRepository.newId()).thenReturn("123");
        when(mockEncryptionComponent.encodePassword(request.getPassword())).thenReturn("hashedPassword");
        when(mockUserRepository.insert(any(User.class))).thenThrow(new Conflict());

        // WHEN: generateUser is called
        assertThrows(Conflict.class, () -> userService.generateUser(request));

        // THEN: Conflict exception is thrown
    }

    @Test
    void testGenerateUser_InternalServerError() {
        // GIVEN: A UserRequest that causes an unknown error during insertion
        UserRequest request = new UserRequest();
        request.setUsername("newuser");
        request.setEmail("newuser@example.com");
        request.setPassword("rawPassword");

        when(mockUserRepository.newId()).thenReturn("123");
        when(mockEncryptionComponent.encodePassword(request.getPassword())).thenReturn("hashedPassword");
        when(mockUserRepository.insert(any(User.class))).thenThrow(new RuntimeException());

        // WHEN: generateUser is called
        assertThrows(InternalServerError.class, () -> userService.generateUser(request));

        // THEN: InternalServerError exception is thrown
    }
}

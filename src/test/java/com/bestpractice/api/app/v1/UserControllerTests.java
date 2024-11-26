package com.bestpractice.api.app.v1;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.domain.model.UserRequest;
import com.bestpractice.api.domain.model.UserResponse;
import com.bestpractice.api.domain.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTests {

    @Mock
    private UserService userService;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUserSuccessfully() {
        // GIVEN: A valid UserRequest and no validation errors
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("testUser");
        userRequest.setPassword("securePassword");

        when(bindingResult.hasErrors()).thenReturn(false);

        UserResponse expectedResponse = new UserResponse("123", "testUser", "testUser@example.com");
        when(userService.generateUser(userRequest)).thenReturn(expectedResponse);

        // WHEN: The createUser method is called
        UserResponse actualResponse = userController.createUser(userRequest, bindingResult);

        // THEN: Verify the response and interactions
        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getId(), actualResponse.getId());
        assertEquals(expectedResponse.getUsername(), actualResponse.getUsername());
        assertEquals(expectedResponse.getEmail(), actualResponse.getEmail());
        verify(bindingResult, times(1)).hasErrors();
        verify(userService, times(1)).generateUser(userRequest);
    }

    @Test
    void testCreateUserThrowsBadRequestOnValidationErrors() {
        // GIVEN: A UserRequest with validation errors
        UserRequest userRequest = new UserRequest();
        when(bindingResult.hasErrors()).thenReturn(true);
        when(bindingResult.getObjectName()).thenReturn("UserRequest");

        // WHEN: The createUser method is called
        Exception exception = assertThrows(BadRequest.class, () -> userController.createUser(userRequest, bindingResult));

        // THEN: Verify exception message and interactions
        assertEquals("UserRequest", exception.getMessage());
        verify(bindingResult, times(1)).hasErrors();
        verifyNoInteractions(userService);
    }

    @Test
    void testCreateUserHandlesServiceException() {
        // GIVEN: A valid UserRequest but the service throws an exception
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("testUser");
        userRequest.setPassword("securePassword");

        when(bindingResult.hasErrors()).thenReturn(false);

        when(userService.generateUser(userRequest)).thenThrow(new RuntimeException("Unexpected error"));

        // WHEN: The createUser method is called
        Exception exception = assertThrows(RuntimeException.class, () -> userController.createUser(userRequest, bindingResult));

        // THEN: Verify exception message and interactions
        assertEquals("Unexpected error", exception.getMessage());
        verify(bindingResult, times(1)).hasErrors();
        verify(userService, times(1)).generateUser(userRequest);
    }
}

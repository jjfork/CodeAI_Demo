package com.bestpractice.api.app.v1;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

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
    void createUser_ValidRequest_ReturnsUserResponse() {
        // GIVEN
        UserRequest request = new UserRequest();
        request.setUsername("testUser");
        request.setEmail("test@example.com");
        request.setPassword("testPassword");
        when(userService.generateUser(request)).thenReturn(new UserResponse("id", "testUser", "test@example.com"));
        // WHEN
        UserResponse response = userController.createUser(request, bindingResult);
        // THEN
        assertEquals("id", response.getId());
        assertEquals("testUser", response.getUsername());
        assertEquals("test@example.com", response.getEmail());
        verify(userService).generateUser(request);
    }

    @Test
    void createUser_InvalidRequest_ThrowsBadRequest() {
        // GIVEN
        UserRequest request = new UserRequest();
        when(bindingResult.hasErrors()).thenReturn(true);
        // WHEN
        assertThrows(BadRequest.class, () -> userController.createUser(request, bindingResult));
        // THEN
        verify(userService, never()).generateUser(request);
    }
}

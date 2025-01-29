package com.bestpractice.api.app.v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import com.bestpractice.api.infrastrucuture.entity.User;

class UserControllerTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_ValidUser_ReturnsCreatedUser() {
        // GIVEN
        User user = new User("1", "testuser", "test@email.com", "password");
        when(userService.createUser(user)).thenReturn(user);

        // WHEN
        User createdUser = userController.createUser(user);

        // THEN
        assertEquals(user, createdUser);
    }
}
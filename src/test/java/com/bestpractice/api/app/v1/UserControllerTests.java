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
    UserRequest request = new UserRequest();
    request.setUsername("testUsername");
    request.setEmail("testEmail");
    request.setPassword("testPassword");

    when(userService.generateUser(request)).thenReturn(new UserResponse("id", "testUsername", "testEmail"));

    UserResponse response = userController.createUser(request, bindingResult);

    assertEquals("id", response.getId());
    assertEquals("testUsername", response.getUsername());
    assertEquals("testEmail", response.getEmail());
    verify(userService).generateUser(request);
  }

  @Test
  void createUser_InvalidRequest_ThrowsBadRequest() {
    UserRequest request = new UserRequest();
    request.setUsername(null);

    when(bindingResult.hasErrors()).thenReturn(true);

    assertThrows(BadRequest.class, () -> userController.createUser(request, bindingResult));
    verify(userService, never()).generateUser(request);
  }
}

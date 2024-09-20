package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserResponseTests {

  @Test
  void testUserResponse() {
    String id = "123";
    String username = "john.doe";
    String email = "john.doe@example.com";
    UserResponse userResponse = new UserResponse(id, username, email);
    assertEquals(id, userResponse.getId());
    assertEquals(username, userResponse.getUsername());
    assertEquals(email, userResponse.getEmail());
  }
} 

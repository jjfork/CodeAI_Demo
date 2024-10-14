package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserResponseTests {

  private String id;
  private String username;
  private String email;
  private UserResponse userResponse;

  @BeforeEach
  void setUp() {
    id = "123";
    username = "john.doe";
    email = "john.doe@example.com";
    userResponse = new UserResponse(id, username, email);
  }

  @Test
  void testGetId() {
    assertEquals(id, userResponse.getId());
  }

  @Test
  void testGetUsername() {
    assertEquals(username, userResponse.getUsername());
  }

  @Test
  void testGetEmail() {
    assertEquals(email, userResponse.getEmail());
  }
}

package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRequestTests {
  private UserRequest userRequest;

  @BeforeEach
  void setUp() {
    userRequest = new UserRequest();
  }

  @Test
  void testGetUsername() {
    String username = "testUsername";
    userRequest.setUsername(username);
    assertEquals(username, userRequest.getUsername());
  }

  @Test
  void testSetUsername() {
    String username = "testUsername";
    userRequest.setUsername(username);
    assertEquals(username, userRequest.getUsername());
  }

  @Test
  void testGetEmail() {
    String email = "testEmail@example.com";
    userRequest.setEmail(email);
    assertEquals(email, userRequest.getEmail());
  }

  @Test
  void testSetEmail() {
    String email = "testEmail@example.com";
    userRequest.setEmail(email);
    assertEquals(email, userRequest.getEmail());
  }

  @Test
  void testGetPassword() {
    String password = "testPassword";
    userRequest.setPassword(password);
    assertEquals(password, userRequest.getPassword());
  }

  @Test
  void testSetPassword() {
    String password = "testPassword";
    userRequest.setPassword(password);
    assertEquals(password, userRequest.getPassword());
  }

  @Test
  void testConvert() {
    String id = "testId";
    String encodePw = "encodedPassword";
    com.bestpractice.api.infrastrucuture.entity.User user = userRequest.convert(id, encodePw);
    assertEquals(id, user.getId());
    assertEquals(userRequest.getUsername(), user.getUsername());
    assertEquals(userRequest.getEmail(), user.getEmail());
    assertEquals(encodePw, user.getPassword());
  }
}

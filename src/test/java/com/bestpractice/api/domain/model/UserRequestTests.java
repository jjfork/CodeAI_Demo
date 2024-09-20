package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRequestTests {

  @Test
  void testConvert() {
    UserRequest userRequest = new UserRequest();
    userRequest.setUsername("testUsername");
    userRequest.setEmail("testEmail@example.com");
    userRequest.setPassword("testPassword");
    String id = "testId";
    String encodePw = "encodedPassword";
    com.bestpractice.api.infrastrucuture.entity.User user = userRequest.convert(id, encodePw);
    assertEquals("testUsername", user.getUsername());
    assertEquals("testEmail@example.com", user.getEmail());
    assertEquals("encodedPassword", user.getPassword());
    assertEquals(id, user.getId());
  }
}

package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthByEmailRequestTests {
  private AuthByEmailRequest authByEmailRequest;

  @BeforeEach
  void setUp() {
    authByEmailRequest = new AuthByEmailRequest();
  }

  @Test
  void testGetEmail() {
    // GIVEN - An instance of AuthByEmailRequest is created.
    // WHEN - The getEmail method is called on the instance.
    String email = authByEmailRequest.getEmail();
    // THEN - The returned email should be null.
    assertNull(email);
  }

  @Test
  void testSetEmail() {
    // GIVEN - An instance of AuthByEmailRequest is created.
    // WHEN - The setEmail method is called with a valid email address.
    authByEmailRequest.setEmail("test@example.com");
    // THEN - The returned email should be "test@example.com".
    assertEquals("test@example.com", authByEmailRequest.getEmail());
  }

  @Test
  void testGetPassword() {
    // GIVEN - An instance of AuthByEmailRequest is created.
    // WHEN - The getPassword method is called on the instance.
    String password = authByEmailRequest.getPassword();
    // THEN - The returned password should be null.
    assertNull(password);
  }

  @Test
  void testSetPassword() {
    // GIVEN - An instance of AuthByEmailRequest is created.
    // WHEN - The setPassword method is called with a valid password.
    authByEmailRequest.setPassword("securePassword");
    // THEN - The returned password should be "securePassword".
    assertEquals("securePassword", authByEmailRequest.getPassword());
  }
}

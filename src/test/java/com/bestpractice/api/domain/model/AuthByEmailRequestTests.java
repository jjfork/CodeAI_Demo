package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthByEmailRequestTests {

  private AuthByEmailRequest authByEmailRequest;

  @BeforeEach
  void setUp() {
    authByEmailRequest = new AuthByEmailRequest();
  }

  @Test
  void testGetEmail() {
    String email = "test@example.com";
    authByEmailRequest.setEmail(email);
    assertEquals(email, authByEmailRequest.getEmail());
  }

  @Test
  void testSetEmail() {
    String email = "test@example.com";
    authByEmailRequest.setEmail(email);
    assertEquals(email, authByEmailRequest.getEmail());
  }

  @Test
  void testGetPassword() {
    String password = "password123";
    authByEmailRequest.setPassword(password);
    assertEquals(password, authByEmailRequest.getPassword());
  }

  @Test
  void testSetPassword() {
    String password = "password123";
    authByEmailRequest.setPassword(password);
    assertEquals(password, authByEmailRequest.getPassword());
  }
}

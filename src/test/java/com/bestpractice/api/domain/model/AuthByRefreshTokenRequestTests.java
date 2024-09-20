package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthByRefreshTokenRequestTests {

  @Test
  void testGetRefreshToken() {
    AuthByRefreshTokenRequest request = new AuthByRefreshTokenRequest();
    request.setRefreshToken("someRefreshToken");
    assertEquals("someRefreshToken", request.getRefreshToken());
  }

  @Test
  void testSetRefreshToken() {
    AuthByRefreshTokenRequest request = new AuthByRefreshTokenRequest();
    request.setRefreshToken("someRefreshToken");
    assertEquals("someRefreshToken", request.getRefreshToken());
  }
} 

package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthResponseTests {

  @Test
  void testGetTokenType() {
    String tokenType = "Bearer";
    String token = "someToken";
    String refreshToken = "someRefreshToken";
    java.util.Date expiresAt = new java.util.Date();
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(tokenType, authResponse.getTokenType());
  }

  @Test
  void testGetToken() {
    String tokenType = "Bearer";
    String token = "someToken";
    String refreshToken = "someRefreshToken";
    java.util.Date expiresAt = new java.util.Date();
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(token, authResponse.getToken());
  }

  @Test
  void testGetRefreshToken() {
    String tokenType = "Bearer";
    String token = "someToken";
    String refreshToken = "someRefreshToken";
    java.util.Date expiresAt = new java.util.Date();
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(refreshToken, authResponse.getRefreshToken());
  }

  @Test
  void testGetExpiresAt() {
    String tokenType = "Bearer";
    String token = "someToken";
    String refreshToken = "someRefreshToken";
    java.util.Date expiresAt = new java.util.Date();
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(expiresAt, authResponse.getExpiresAt());
  }
}

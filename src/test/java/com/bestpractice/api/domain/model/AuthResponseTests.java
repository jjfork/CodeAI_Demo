package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AuthResponseTests {

  private String tokenType;
  private String token;
  private String refreshToken;
  private Date expiresAt;

  @BeforeEach
  void setUp() {
    tokenType = "Bearer";
    token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
    refreshToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
    expiresAt = new Date();
  }

  @Test
  void testGetTokenType() {
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(tokenType, authResponse.getTokenType());
  }

  @Test
  void testGetToken() {
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(token, authResponse.getToken());
  }

  @Test
  void testGetRefreshToken() {
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(refreshToken, authResponse.getRefreshToken());
  }

  @Test
  void testGetExpiresAt() {
    AuthResponse authResponse = new AuthResponse(tokenType, token, refreshToken, expiresAt);
    assertEquals(expiresAt, authResponse.getExpiresAt());
  }

}

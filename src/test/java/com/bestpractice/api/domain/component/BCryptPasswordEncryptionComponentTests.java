package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BCryptPasswordEncryptionComponentTests {

  @Autowired
  private BCryptPasswordEncryptionComponent encryptionComponent;

  @BeforeEach
  void setUp() {
  }

  @Test
  void encodePassword_GivenRawPassword_ReturnsEncodedPassword() {
    // GIVEN
    String rawPassword = "password123";
    // WHEN
    String encodedPassword = encryptionComponent.encodePassword(rawPassword); 
    // THEN
    assertNotNull(encodedPassword);
  }

  @Test
  void matchedPassword_GivenCorrectRawAndPassword_ReturnsTrue() {
    // GIVEN
    String rawPassword = "password123";
    String encodedPassword = encryptionComponent.encodePassword(rawPassword); 
    // WHEN
    boolean match = encryptionComponent.matches(rawPassword, encodedPassword);
    // THEN
    assertTrue(match);
  }

  @Test
  void matchedPassword_GivenIncorrectRawAndPassword_ReturnsFalse() {
    // GIVEN
    String rawPassword = "wrongpassword";
    String encodedPassword = encryptionComponent.encodePassword("password123"); 
    // WHEN
    boolean match = encryptionComponent.matches(rawPassword, encodedPassword);
    // THEN
    assertFalse(match);
  }

}
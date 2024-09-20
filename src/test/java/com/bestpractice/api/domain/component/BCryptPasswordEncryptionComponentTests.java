package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class BCryptPasswordEncryptionComponentTests {

  @InjectMocks
  private BCryptPasswordEncryptionComponent bCryptPasswordEncryptionComponent;

  @Test
  void testEncodePassword() {
    String rawPassword = "password";
    String encodedPassword = bCryptPasswordEncryptionComponent.encodePassword(rawPassword);
    assertTrue(encodedPassword.length() > 10);
  }

  @Test
  void testMatchedPassword() {
    String rawPassword = "password";
    String encodedPassword = bCryptPasswordEncryptionComponent.encodePassword(rawPassword);
    assertTrue(bCryptPasswordEncryptionComponent.matchedPassword(rawPassword, encodedPassword));
    assertFalse(bCryptPasswordEncryptionComponent.matchedPassword(rawPassword + "1", encodedPassword));
  }
}

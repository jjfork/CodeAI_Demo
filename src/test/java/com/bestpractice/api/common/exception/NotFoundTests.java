package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundTests {

  @BeforeEach
  void setUp() {
  }

  @Test
  void testNotFound() {
    // GIVEN - 
    // WHEN - 
    NotFound exception = new NotFound();
    // THEN - 
    assertNotNull(exception);
  }

  @Test
  void testNotFoundWithMessage() {
    // GIVEN - 
    String message = "Resource not found";
    // WHEN - 
    NotFound exception = new NotFound(message);
    // THEN - 
    assertEquals(message, exception.getMessage());
  }

  @Test
  void testNotFoundWithCause() {
    // GIVEN - 
    Throwable cause = new RuntimeException();
    // WHEN - 
    NotFound exception = new NotFound(cause);
    // THEN - 
    assertSame(cause, exception.getCause());
  }

  @Test
  void testNotFoundWithMessageAndCause() {
    // GIVEN - 
    String message = "Resource not found";
    Throwable cause = new RuntimeException();
    // WHEN - 
    NotFound exception = new NotFound(message, cause);
    // THEN - 
    assertEquals(message, exception.getMessage());
    assertSame(cause, exception.getCause());
  }
}

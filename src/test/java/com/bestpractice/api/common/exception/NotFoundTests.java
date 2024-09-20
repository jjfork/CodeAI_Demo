package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotFoundTests {

  @Test
  void testNotFound() {
    NotFound exception = new NotFound();
    assertNotNull(exception);
  }

  @Test
  void testNotFoundMessage() {
    String message = "Resource not found";
    NotFound exception = new NotFound(message);
    assertEquals(message, exception.getMessage());
  }

  @Test
  void testNotFoundCause() {
    Throwable cause = new RuntimeException();
    NotFound exception = new NotFound(cause);
    assertSame(cause, exception.getCause());
  }

  @Test
  void testNotFoundMessageAndCause() {
    String message = "Resource not found";
    Throwable cause = new RuntimeException();
    NotFound exception = new NotFound(message, cause);
    assertEquals(message, exception.getMessage());
    assertSame(cause, exception.getCause());
  }
} 

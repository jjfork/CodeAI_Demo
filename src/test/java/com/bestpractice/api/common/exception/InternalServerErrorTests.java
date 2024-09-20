package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InternalServerErrorTests {

  @Test
  void testInternalServerError() {
    InternalServerError exception = new InternalServerError();
    assertNotNull(exception);
  }

  @Test
  void testInternalServerErrorString() {
    String message = "Test message";
    InternalServerError exception = new InternalServerError(message);
    assertEquals(message, exception.getMessage());
  }

  @Test
  void testInternalServerErrorThrowable() {
    Throwable cause = new RuntimeException();
    InternalServerError exception = new InternalServerError(cause);
    assertSame(cause, exception.getCause());
  }

  @Test
  void testInternalServerErrorStringThrowable() {
    String message = "Test message";
    Throwable cause = new RuntimeException();
    InternalServerError exception = new InternalServerError(message, cause);
    assertEquals(message, exception.getMessage());
    assertSame(cause, exception.getCause());
  }
} 

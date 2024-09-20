package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequestTimeoutTests {

  @Test
  void testRequestTimeout() {
    RequestTimeout exception = new RequestTimeout();
    assertNotNull(exception);
  }

  @Test
  void testRequestTimeoutWithMessage() {
    String message = "Request timed out";
    RequestTimeout exception = new RequestTimeout(message);
    assertEquals(message, exception.getMessage());
  }

  @Test
  void testRequestTimeoutWithCause() {
    Throwable cause = new RuntimeException();
    RequestTimeout exception = new RequestTimeout(cause);
    assertSame(cause, exception.getCause());
  }

  @Test
  void testRequestTimeoutWithMessageAndCause() {
    String message = "Request timed out";
    Throwable cause = new RuntimeException();
    RequestTimeout exception = new RequestTimeout(message, cause);
    assertEquals(message, exception.getMessage());
    assertSame(cause, exception.getCause());
  }
} 

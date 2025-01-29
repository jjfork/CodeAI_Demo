package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testNotFound() {
        // GIVEN - No arguments provided
        NotFound exception = new NotFound();
        // WHEN - Exception is created
        // THEN - Default message should be null
        assertNull(exception.getMessage());
    }

    @Test
    void testNotFoundWithMessage() {
        // GIVEN - Message provided
        String message = "Resource not found";
        NotFound exception = new NotFound(message);
        // WHEN - Exception is created
        // THEN - Provided message should be present
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testNotFoundWithCause() {
        // GIVEN - Throwable cause provided
        Throwable cause = new RuntimeException("Internal error");
        NotFound exception = new NotFound(cause);
        // WHEN - Exception is created
        // THEN - Cause should be present
        assertSame(cause, exception.getCause());
    }

    @Test
    void testNotFoundWithMessageAndCause() {
        // GIVEN - Message and Throwable cause provided
        String message = "Resource not found";
        Throwable cause = new RuntimeException("Internal error");
        NotFound exception = new NotFound(message, cause);
        // WHEN - Exception is created
        // THEN - Both message and cause should be present
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
}

package com.bestpractice.api.common.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

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
        NotFound exception = new NotFound();
        // WHEN - 
        // THEN - assertNotNull(exception.getMessage());
    }

    @Test
    void testNotFoundWithMessage() {
        // GIVEN - 
        String message = "Resource not found";
        NotFound exception = new NotFound(message);
        // WHEN - 
        // THEN - assertEquals(message, exception.getMessage());
    }

    @Test
    void testNotFoundWithCause() {
        // GIVEN - 
        Throwable cause = new RuntimeException();
        NotFound exception = new NotFound(cause);
        // WHEN - 
        // THEN - assertEquals(cause, exception.getCause());
    }

    @Test
    void testNotFoundWithMessageAndCause() {
        // GIVEN - 
        String message = "Resource not found";
        Throwable cause = new RuntimeException();
        NotFound exception = new NotFound(message, cause);
        // WHEN - 
        // THEN - assertEquals(message, exception.getMessage());
        // THEN - assertEquals(cause, exception.getCause());
    }
}

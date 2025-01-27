package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BadRequestTests {

    @BeforeEach
    void setUp() {
        // Reset any state before each test if necessary
    }

    @Test
    void shouldCreateExceptionWithoutMessage() {
        // GIVEN: No message or cause for the exception
        // WHEN: Creating a new BadRequest instance without parameters
        BadRequest exception = new BadRequest();
        // THEN: The exception should be an instance of RuntimeException and have no message
        assertNotNull(exception);
        assertTrue(exception instanceof RuntimeException);
        assertNull(exception.getMessage());
    }

    @Test
    void shouldCreateExceptionWithMessage() {
        // GIVEN: A specific error message for the exception
        String errorMessage = "Invalid input provided";
        // WHEN: Creating a new BadRequest instance with a message
        BadRequest exception = new BadRequest(errorMessage);
        // THEN: The exception should contain the specified message
        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void shouldCreateExceptionWithCause() {
        // GIVEN: A cause for the exception
        Throwable cause = new IllegalArgumentException("Invalid argument");
        // WHEN: Creating a new BadRequest instance with a cause
        BadRequest exception = new BadRequest(cause);
        // THEN: The exception should have the specified cause
        assertNotNull(exception);
        assertEquals(cause, exception.getCause());
    }

    @Test
    void shouldCreateExceptionWithMessageAndCause() {
        // GIVEN: A specific error message and a cause for the exception
        String errorMessage = "Invalid input provided";
        Throwable cause = new IllegalArgumentException("Invalid argument");
        // WHEN: Creating a new BadRequest instance with both a message and a cause
        BadRequest exception = new BadRequest(errorMessage, cause);
        // THEN: The exception should contain the specified message and cause
        assertNotNull(exception);
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}

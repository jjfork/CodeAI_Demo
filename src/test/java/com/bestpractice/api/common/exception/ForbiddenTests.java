package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForbiddenTests {

    @BeforeEach
    void setUp() {
        // Reset any state before each test if necessary
    }

    @Test
    void shouldCreateForbiddenExceptionWithoutMessage() {
        // GIVEN: No specific message or cause for the exception
        // WHEN: Creating a new instance of Forbidden without parameters
        Forbidden forbidden = new Forbidden();
        // THEN: The exception should be an instance of RuntimeException and Forbidden
        assertNotNull(forbidden, "The exception should not be null");
        assertTrue(forbidden instanceof RuntimeException, "Should be an instance of RuntimeException");
        assertTrue(forbidden instanceof Forbidden, "Should be an instance of Forbidden");
    }

    @Test
    void shouldCreateForbiddenExceptionWithMessage() {
        // GIVEN: A specific message for the exception
        String message = "Access Denied";
        // WHEN: Creating a new instance of Forbidden with a message
        Forbidden forbidden = new Forbidden(message);
        // THEN: The exception's message should match the provided message
        assertEquals(message, forbidden.getMessage(), "The exception message should match the given message");
    }

    @Test
    void shouldCreateForbiddenExceptionWithCause() {
        // GIVEN: A cause for the exception
        Throwable cause = new RuntimeException("Root Cause");
        // WHEN: Creating a new instance of Forbidden with a cause
        Forbidden forbidden = new Forbidden(cause);
        // THEN: The exception's cause should match the provided cause
        assertEquals(cause, forbidden.getCause(), "The exception cause should match the given cause");
    }

    @Test
    void shouldCreateForbiddenExceptionWithMessageAndCause() {
        // GIVEN: A specific message and a cause for the exception
        String message = "Access Denied";
        Throwable cause = new RuntimeException("Root Cause");
        // WHEN: Creating a new instance of Forbidden with both a message and a cause
        Forbidden forbidden = new Forbidden(message, cause);
        // THEN: The exception's message should match the provided message and its cause should match the given cause
        assertEquals(message, forbidden.getMessage(), "The exception message should match the given message");
        assertEquals(cause, forbidden.getCause(), "The exception cause should match the given cause");
    }
}

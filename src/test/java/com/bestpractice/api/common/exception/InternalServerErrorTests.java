package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InternalServerErrorTests {

    @BeforeEach
    void setUp() {
        // Reset any state before each test if necessary.
    }

    @Test
    void shouldCreateInternalServerErrorWithoutMessage() {
        // GIVEN: No message or cause provided for the exception.
        
        // WHEN: Creating an instance of InternalServerError without parameters.
        InternalServerError error = new InternalServerError();
        
        // THEN: The exception should be created successfully and have no specific message (i.e., null).
        assertNotNull(error);
        assertNull(error.getMessage());
    }

    @Test
    void shouldCreateInternalServerErrorWithMessage() {
        // GIVEN: A specific message for the exception.
        String expectedMessage = "An internal server error occurred.";
        
        // WHEN: Creating an instance of InternalServerError with a message.
        InternalServerError error = new InternalServerError(expectedMessage);
        
        // THEN: The exception should contain the provided message.
        assertNotNull(error);
        assertEquals(expectedMessage, error.getMessage());
    }

    @Test
    void shouldCreateInternalServerErrorWithCause() {
        // GIVEN: A cause for the exception.
        Throwable cause = new RuntimeException("Root cause");
        
        // WHEN: Creating an instance of InternalServerError with a cause.
        InternalServerError error = new InternalServerError(cause);
        
        // THEN: The exception should have the provided cause.
        assertNotNull(error);
        assertEquals(cause, error.getCause());
    }

    @Test
    void shouldCreateInternalServerErrorWithMessageAndCause() {
        // GIVEN: A specific message and a cause for the exception.
        String expectedMessage = "An internal server error occurred.";
        Throwable cause = new RuntimeException("Root cause");
        
        // WHEN: Creating an instance of InternalServerError with both a message and a cause.
        InternalServerError error = new InternalServerError(expectedMessage, cause);
        
        // THEN: The exception should contain the provided message and have the specified cause.
        assertNotNull(error);
        assertEquals(expectedMessage, error.getMessage());
        assertEquals(cause, error.getCause());
    }
}

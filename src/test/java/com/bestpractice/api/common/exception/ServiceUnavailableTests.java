package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceUnavailableTests {

    @BeforeEach
    void setUp() {
        // Reset any state before each test if necessary
    }

    @Test
    void shouldCreateServiceUnavailableWithoutMessage() {
        // GIVEN no message or cause
        // WHEN creating a new instance of ServiceUnavailable without parameters
        ServiceUnavailable exception = new ServiceUnavailable();
        
        // THEN the exception should be an instance of RuntimeException and have no message
        assertTrue(exception instanceof RuntimeException);
        assertNull(exception.getMessage());
    }

    @Test
    void shouldCreateServiceUnavailableWithMessage() {
        // GIVEN a specific message
        String message = "Service is unavailable";
        
        // WHEN creating a new instance with the message
        ServiceUnavailable exception = new ServiceUnavailable(message);
        
        // THEN the exception should have the provided message and be an instance of RuntimeException
        assertEquals(message, exception.getMessage());
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    void shouldCreateServiceUnavailableWithCause() {
        // GIVEN a cause for the exception
        Throwable cause = new RuntimeException("Underlying issue");
        
        // WHEN creating a new instance with the cause
        ServiceUnavailable exception = new ServiceUnavailable(cause);
        
        // THEN the exception should have the provided cause and be an instance of RuntimeException
        assertEquals(cause, exception.getCause());
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    void shouldCreateServiceUnavailableWithMessageAndCause() {
        // GIVEN a message and a cause for the exception
        String message = "Service is unavailable";
        Throwable cause = new RuntimeException("Underlying issue");
        
        // WHEN creating a new instance with both message and cause
        ServiceUnavailable exception = new ServiceUnavailable(message, cause);
        
        // THEN the exception should have the provided message and cause and be an instance of RuntimeException
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertTrue(exception instanceof RuntimeException);
    }
}

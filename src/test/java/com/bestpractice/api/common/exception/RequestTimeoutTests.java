package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequestTimeoutTests {

    @BeforeEach
    void setUp() {
        // Reset any state before each test if necessary.
    }

    @Test
    void testDefaultConstructor() {
        // GIVEN a new instance of RequestTimeout using the default constructor
        RequestTimeout exception = new RequestTimeout();

        // WHEN we check its message
        String message = exception.getMessage();

        // THEN it should have null as the default message
        assertNull(message);
    }

    @Test
    void testConstructorWithMessage() {
        // GIVEN a specific error message
        String errorMessage = "Custom timeout message";

        // WHEN we create an instance with this message
        RequestTimeout exception = new RequestTimeout(errorMessage);

        // THEN the message should match what was provided
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        // GIVEN a cause for the exception
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN we create an instance with this cause
        RequestTimeout exception = new RequestTimeout(cause);

        // THEN the cause should be correctly set
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        // GIVEN a specific error message and a cause
        String errorMessage = "Custom timeout with cause";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN we create an instance with both the message and the cause
        RequestTimeout exception = new RequestTimeout(errorMessage, cause);

        // THEN the message should match what was provided
        assertEquals(errorMessage, exception.getMessage());

        // AND the cause should be correctly set
        assertEquals(cause, exception.getCause());
    }
}

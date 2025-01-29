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
    }

    @Test
    void testConstructor() {
        // GIVEN - 
        // WHEN -  InternalServerError instance is created without arguments
        InternalServerError exception = new InternalServerError();
        // THEN - Exception message should be null
        assertNull(exception.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        // GIVEN - 
        String message = "Test Error Message";
        // WHEN -  InternalServerError instance is created with a message
        InternalServerError exception = new InternalServerError(message);
        // THEN - Exception message should be the provided message
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        // GIVEN - 
        Throwable cause = new RuntimeException("Test Cause");
        // WHEN -  InternalServerError instance is created with a cause
        InternalServerError exception = new InternalServerError(cause);
        // THEN - Exception cause should be the provided cause
        assertSame(cause, exception.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        // GIVEN - 
        String message = "Test Error Message";
        Throwable cause = new RuntimeException("Test Cause");
        // WHEN -  InternalServerError instance is created with a message and cause
        InternalServerError exception = new InternalServerError(message, cause);
        // THEN - Exception message should be the provided message and cause should be the provided cause
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
}

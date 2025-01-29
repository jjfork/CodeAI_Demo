package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnAuthorizedTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConstructor() {
        // GIVEN - 
        // WHEN -  UnAuthorized instance is created without arguments
        UnAuthorized unauthorized = new UnAuthorized();
        // THEN - The exception message should be null
        assertNull(unauthorized.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        // GIVEN - A message string
        String message = "Unauthorized access";
        // WHEN - An UnAuthorized instance is created with the message
        UnAuthorized unauthorized = new UnAuthorized(message);
        // THEN - The exception message should be the provided message
        assertEquals(message, unauthorized.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        // GIVEN - A Throwable cause
        Throwable cause = new RuntimeException("Some other error");
        // WHEN - An UnAuthorized instance is created with the cause
        UnAuthorized unauthorized = new UnAuthorized(cause);
        // THEN - The exception's cause should be the provided cause
        assertSame(cause, unauthorized.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        // GIVEN - A message string and a Throwable cause
        String message = "Unauthorized access";
        Throwable cause = new RuntimeException("Some other error");
        // WHEN - An UnAuthorized instance is created with the message and cause
        UnAuthorized unauthorized = new UnAuthorized(message, cause);
        // THEN - The exception message should be the provided message and the cause should be the provided cause
        assertEquals(message, unauthorized.getMessage());
        assertSame(cause, unauthorized.getCause());
    }

}

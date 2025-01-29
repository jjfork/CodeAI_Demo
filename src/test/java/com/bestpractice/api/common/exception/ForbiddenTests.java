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
    }

    @Test
    void testForbidden() {
        // GIVEN - No arguments provided
        Forbidden forbidden = new Forbidden();
        // THEN - Default message should be "Forbidden"
        assertEquals("Forbidden", forbidden.getMessage());
    }

    @Test
    void testForbiddenWithMessage() {
        // GIVEN - Message provided
        String message = "Access denied";
        Forbidden forbidden = new Forbidden(message);
        // THEN - Provided message should be present
        assertEquals(message, forbidden.getMessage());
    }

    @Test
    void testForbiddenWithCause() {
        // GIVEN - Throwable cause provided
        Throwable cause = new RuntimeException("Internal error");
        Forbidden forbidden = new Forbidden(cause);
        // THEN - Cause should be present
        assertNotNull(forbidden.getCause());
        assertEquals(cause, forbidden.getCause());
    }

    @Test
    void testForbiddenWithMessageAndCause() {
        // GIVEN - Message and Throwable cause provided
        String message = "Resource not found";
        Throwable cause = new IllegalArgumentException("Invalid input");
        Forbidden forbidden = new Forbidden(message, cause);
        // THEN - Both message and cause should be present
        assertEquals(message, forbidden.getMessage());
        assertNotNull(forbidden.getCause());
        assertEquals(cause, forbidden.getCause());
    }
}
package com.bestpractice.api.common.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testForbidden() {
        // GIVEN - 
        // WHEN - 
        Forbidden forbidden = new Forbidden();
        // THEN - 
        assertNotNull(forbidden);
    }

    @Test
    void testForbiddenString() {
        // GIVEN - 
        String message = "Forbidden message";
        // WHEN - 
        Forbidden forbidden = new Forbidden(message);
        // THEN - 
        assertEquals(message, forbidden.getMessage());
    }

    @Test
    void testForbiddenThrowable() {
        // GIVEN - 
        Throwable cause = new RuntimeException();
        // WHEN - 
        Forbidden forbidden = new Forbidden(cause);
        // THEN - 
        assertEquals(cause, forbidden.getCause());
    }

    @Test
    void testForbiddenStringThrowable() {
        // GIVEN - 
        String message = "Forbidden message";
        Throwable cause = new RuntimeException();
        // WHEN - 
        Forbidden forbidden = new Forbidden(message, cause);
        // THEN - 
        assertEquals(message, forbidden.getMessage());
        assertEquals(cause, forbidden.getCause());
    }
}

package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

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
        // WHEN - 
        NotFound notFound = new NotFound();
        // THEN - 
        assertNotNull(notFound);
    }

    @Test
    void testNotFoundString() {
        // GIVEN - 
        String message = "Resource not found";
        // WHEN - 
        NotFound notFound = new NotFound(message);
        // THEN - 
        assertEquals(message, notFound.getMessage());
    }

    @Test
    void testNotFoundThrowable() {
        // GIVEN - 
        Throwable cause = new RuntimeException();
        // WHEN - 
        NotFound notFound = new NotFound(cause);
        // THEN - 
        assertEquals(cause, notFound.getCause());
    }

    @Test
    void testNotFoundStringThrowable() {
        // GIVEN - 
        String message = "Resource not found";
        Throwable cause = new RuntimeException();
        // WHEN - 
        NotFound notFound = new NotFound(message, cause);
        // THEN - 
        assertEquals(message, notFound.getMessage());
        assertEquals(cause, notFound.getCause());
    }
}

package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConflictTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConflict() {
        // GIVEN - 
        // WHEN - 
        Conflict conflict = new Conflict();
        // THEN - 
        assertNotNull(conflict);
    }

    @Test
    void testConflictString() {
        // GIVEN - 
        String message = "Test Conflict Message";
        // WHEN - 
        Conflict conflict = new Conflict(message);
        // THEN - 
        assertEquals(message, conflict.getMessage());
    }

    @Test
    void testConflictThrowable() {
        // GIVEN - 
        Throwable cause = new RuntimeException("Test Cause");
        // WHEN - 
        Conflict conflict = new Conflict(cause);
        // THEN - 
        assertEquals(cause, conflict.getCause());
    }

    @Test
    void testConflictStringThrowable() {
        // GIVEN - 
        String message = "Test Conflict Message";
        Throwable cause = new RuntimeException("Test Cause");
        // WHEN - 
        Conflict conflict = new Conflict(message, cause);
        // THEN - 
        assertEquals(message, conflict.getMessage());
        assertEquals(cause, conflict.getCause());
    }
}

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
        Conflict conflict = new Conflict();
        assertNotNull(conflict);
    }

    @Test
    void testConflictString() {
        String message = "Test Conflict Message";
        Conflict conflict = new Conflict(message);
        assertEquals(message, conflict.getMessage());
    }

    @Test
    void testConflictThrowable() {
        Throwable cause = new RuntimeException();
        Conflict conflict = new Conflict(cause);
        assertSame(cause, conflict.getCause());
    }

    @Test
    void testConflictStringThrowable() {
        String message = "Test Conflict Message";
        Throwable cause = new RuntimeException();
        Conflict conflict = new Conflict(message, cause);
        assertEquals(message, conflict.getMessage());
        assertSame(cause, conflict.getCause());
    }
}

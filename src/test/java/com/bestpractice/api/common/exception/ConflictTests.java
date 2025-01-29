package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

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
        // THEN - assertNotNull(conflict);
    }

    @Test
    void testConflictString() {
        // GIVEN - String msg = "This is a conflict message";
        // WHEN - Conflict conflict = new Conflict(msg);
        // THEN - assertEquals("This is a conflict message", conflict.getMessage());
    }

    @Test
    void testConflictThrowable() {
        // GIVEN - Throwable cause = new RuntimeException();
        // WHEN - Conflict conflict = new Conflict(cause);
        // THEN - assertNotNull(conflict.getCause());
    }

    @Test
    void testConflictStringThrowable() {
        // GIVEN - String msg = "This is a conflict message";
        //         Throwable cause = new RuntimeException();
        // WHEN - Conflict conflict = new Conflict(msg, cause);
        // THEN - assertEquals("This is a conflict message", conflict.getMessage());
        //         assertNotNull(conflict.getCause());
    }
}

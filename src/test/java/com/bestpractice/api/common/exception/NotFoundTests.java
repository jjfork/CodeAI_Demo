package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
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
        NotFound notFound = new NotFound();
        assertNotNull(notFound);
    }

    @Test
    void testNotFoundString() {
        NotFound notFound = new NotFound("Test Message");
        assertEquals("Test Message", notFound.getMessage());
    }

    @Test
    void testNotFoundThrowable() {
        Throwable cause = new RuntimeException();
        NotFound notFound = new NotFound(cause);
        assertEquals(cause, notFound.getCause());
    }

    @Test
    void testNotFoundStringThrowable() {
        NotFound notFound = new NotFound("Test Message", new RuntimeException());
        assertEquals("Test Message", notFound.getMessage());
        assertNotNull(notFound.getCause());
    }
}

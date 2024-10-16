package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadRequestTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testBadRequest() {
        BadRequest exception = new BadRequest();
        assertNotNull(exception);
    }

    @Test
    void testBadRequestString() {
        String message = "Bad Request";
        BadRequest exception = new BadRequest(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testBadRequestThrowable() {
        Throwable cause = new RuntimeException();
        BadRequest exception = new BadRequest(cause);
        assertSame(cause, exception.getCause());
    }

    @Test
    void testBadRequestStringThrowable() {
        String message = "Bad Request";
        Throwable cause = new RuntimeException();
        BadRequest exception = new BadRequest(message, cause);
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
} 

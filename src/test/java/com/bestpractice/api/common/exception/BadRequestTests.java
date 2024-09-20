package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BadRequestTests {

    @Test
    void testBadRequest() {
        BadRequest exception = new BadRequest();
        assertNotNull(exception);
    }

    @Test
    void testBadRequestString() {
        String message = "Test message";
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
        String message = "Test message";
        Throwable cause = new RuntimeException();
        BadRequest exception = new BadRequest(message, cause);
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
} 

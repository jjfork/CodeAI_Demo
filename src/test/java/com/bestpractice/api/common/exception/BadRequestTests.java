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
        BadRequest badRequest = new BadRequest();
        assertNotNull(badRequest);
    }

    @Test
    void testBadRequestString() {
        String message = "Test Message";
        BadRequest badRequest = new BadRequest(message);
        assertEquals(message, badRequest.getMessage());
    }

    @Test
    void testBadRequestThrowable() {
        Throwable cause = new RuntimeException();
        BadRequest badRequest = new BadRequest(cause);
        assertSame(cause, badRequest.getCause());
    }

    @Test
    void testBadRequestStringThrowable() {
        String message = "Test Message";
        Throwable cause = new RuntimeException();
        BadRequest badRequest = new BadRequest(message, cause);
        assertEquals(message, badRequest.getMessage());
        assertSame(cause, badRequest.getCause());
    }
}

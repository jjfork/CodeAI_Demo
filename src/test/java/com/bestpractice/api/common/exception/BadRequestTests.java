package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
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
        // GIVEN - 
        // WHEN - 
        BadRequest badRequest = new BadRequest();
        // THEN - 
        assertNotNull(badRequest);
    }

    @Test
    void testBadRequestString() {
        // GIVEN - 
        String message = "Bad Request";
        // WHEN - 
        BadRequest badRequest = new BadRequest(message);
        // THEN - 
        assertEquals(message, badRequest.getMessage());
    }

    @Test
    void testBadRequestThrowable() {
        // GIVEN - 
        Throwable cause = new RuntimeException();
        // WHEN - 
        BadRequest badRequest = new BadRequest(cause);
        // THEN - 
        assertEquals(cause, badRequest.getCause());
    }

    @Test
    void testBadRequestStringThrowable() {
        // GIVEN - 
        String message = "Bad Request";
        Throwable cause = new RuntimeException();
        // WHEN - 
        BadRequest badRequest = new BadRequest(message, cause);
        // THEN - 
        assertEquals(message, badRequest.getMessage());
        assertEquals(cause, badRequest.getCause());
    }
}

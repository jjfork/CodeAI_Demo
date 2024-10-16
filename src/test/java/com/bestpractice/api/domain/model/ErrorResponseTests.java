package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorResponseTests {

    private ErrorResponse errorResponse;

    @BeforeEach
    void setUp() {
        errorResponse = new ErrorResponse();
    }

    @Test
    void testGetStatus() {
        // GIVEN - An ErrorResponse object
        // WHEN - getStatus() is called
        // THEN - The returned status is 0 (default)
        assertEquals(0, errorResponse.getStatus());
    }

    @Test
    void testSetStatus() {
        // GIVEN - An ErrorResponse object
        // WHEN - setStatus(500) is called
        // THEN - The status is set to 500
        errorResponse.setStatus(500);
        assertEquals(500, errorResponse.getStatus());
    }

    @Test
    void testGetError() {
        // GIVEN - An ErrorResponse object
        // WHEN - getError() is called
        // THEN - The returned error is null (default)
        assertNull(errorResponse.getError());
    }

    @Test
    void testSetError() {
        // GIVEN - An ErrorResponse object
        // WHEN - setError("Internal Server Error") is called
        // THEN - The error is set to "Internal Server Error"
        errorResponse.setError("Internal Server Error");
        assertEquals("Internal Server Error", errorResponse.getError());
    }

    @Test
    void testGetMessage() {
        // GIVEN - An ErrorResponse object
        // WHEN - getMessage() is called
        // THEN - The returned message is null (default)
        assertNull(errorResponse.getMessage());
    }

    @Test
    void testSetMessage() {
        // GIVEN - An ErrorResponse object
        // WHEN - setMessage("Something went wrong") is called
        // THEN - The message is set to "Something went wrong"
        errorResponse.setMessage("Something went wrong");
        assertEquals("Something went wrong", errorResponse.getMessage());
    }
}

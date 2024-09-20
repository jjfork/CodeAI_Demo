package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTests {

    @Test
    void testGetStatus() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(500);
        assertEquals(500, errorResponse.getStatus());
    }

    @Test
    void testSetStatus() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(404);
        assertEquals(404, errorResponse.getStatus());
    }

    @Test
    void testGetError() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError("Resource not found");
        assertEquals("Resource not found", errorResponse.getError());
    }

    @Test
    void testSetError() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError("Invalid input");
        assertEquals("Invalid input", errorResponse.getError());
    }

    @Test
    void testGetMessage() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Please check your input");
        assertEquals("Please check your input", errorResponse.getMessage());
    }

    @Test
    void testSetMessage() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Operation failed");
        assertEquals("Operation failed", errorResponse.getMessage());
    }
} 

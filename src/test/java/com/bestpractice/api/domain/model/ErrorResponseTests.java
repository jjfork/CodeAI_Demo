package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseTests {
    private ErrorResponse errorResponse;

    @BeforeEach
    void setUp() {
        errorResponse = new ErrorResponse();
    }

    @Test
    void testGetStatus() {
        int status = 500;
        errorResponse.setStatus(status);
        assertEquals(status, errorResponse.getStatus());
    }

    @Test
    void testGetError() {
        String error = "Internal Server Error";
        errorResponse.setError(error);
        assertEquals(error, errorResponse.getError());
    }

    @Test
    void testGetMessage() {
        String message = "Something went wrong";
        errorResponse.setMessage(message);
        assertEquals(message, errorResponse.getMessage());
    }

    @Test
    void testSetStatus() {
        int status = 404;
        errorResponse.setStatus(status);
        assertEquals(status, errorResponse.getStatus());
    }

    @Test
    void testSetError() {
        String error = "Invalid Input";
        errorResponse.setError(error);
        assertEquals(error, errorResponse.getError());
    }

    @Test
    void testSetMessage() {
        String message = "Please check your input";
        errorResponse.setMessage(message);
        assertEquals(message, errorResponse.getMessage());
    }
}

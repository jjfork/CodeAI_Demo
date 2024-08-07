package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ErrorResponseTests {

    @Test
    void getStatus() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(404);
        assertEquals(404, errorResponse.getStatus());
    }

    @Test
    void getError() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError("Not Found");
        assertEquals("Not Found", errorResponse.getError());
    }

    @Test
    void getMessage() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Resource not found");
        assertEquals("Resource not found", errorResponse.getMessage());
    }
}

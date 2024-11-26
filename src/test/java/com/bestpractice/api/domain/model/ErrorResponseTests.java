package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseTests {

    private static final int SAMPLE_STATUS = 404;
    private static final String SAMPLE_ERROR = "Not Found";
    private static final String SAMPLE_MESSAGE = "The requested resource was not found";

    private ErrorResponse errorResponse;

    @BeforeEach
    void setUp() {
        // GIVEN: Setting up a valid ErrorResponse object
        errorResponse = new ErrorResponse();
    }

    @Test
    void testSetAndGetStatus() {
        // GIVEN: A valid status code
        int status = SAMPLE_STATUS;

        // WHEN: Setting the status
        errorResponse.setStatus(status);

        // THEN: The retrieved status should match the set value
        assertEquals(SAMPLE_STATUS, errorResponse.getStatus(), "Status should match the set value");
    }

    @Test
    void testSetAndGetError() {
        // GIVEN: A valid error message
        String error = SAMPLE_ERROR;

        // WHEN: Setting the error
        errorResponse.setError(error);

        // THEN: The retrieved error should match the set value
        assertEquals(SAMPLE_ERROR, errorResponse.getError(), "Error should match the set value");
    }

    @Test
    void testSetAndGetMessage() {
        // GIVEN: A valid message
        String message = SAMPLE_MESSAGE;

        // WHEN: Setting the message
        errorResponse.setMessage(message);

        // THEN: The retrieved message should match the set value
        assertEquals(SAMPLE_MESSAGE, errorResponse.getMessage(), "Message should match the set value");
    }
}
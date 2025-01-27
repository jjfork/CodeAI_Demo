package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTests {

    private ErrorResponse errorResponse;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize a new instance of ErrorResponse before each test
        errorResponse = new ErrorResponse();
    }

    @Test
    void getStatus_returnsCorrectStatus() {
        // GIVEN: Set the status to 404
        int expectedStatus = 404;
        errorResponse.setStatus(expectedStatus);

        // WHEN: Retrieve the status using getStatus method
        int actualStatus = errorResponse.getStatus();

        // THEN: Verify that the retrieved status matches the set value
        assertEquals(expectedStatus, actualStatus);
    }

    @Test
    void setStatus_setsCorrectStatus() {
        // GIVEN: Prepare a new status value to be set
        int newStatus = 500;

        // WHEN: Set the status using setStatus method
        errorResponse.setStatus(newStatus);

        // THEN: Verify that the status has been updated correctly
        assertEquals(newStatus, errorResponse.getStatus());
    }

    @Test
    void getError_returnsCorrectError() {
        // GIVEN: Set an error message "Not Found"
        String expectedError = "Not Found";
        errorResponse.setError(expectedError);

        // WHEN: Retrieve the error using getError method
        String actualError = errorResponse.getError();

        // THEN: Verify that the retrieved error matches the set value
        assertEquals(expectedError, actualError);
    }

    @Test
    void setError_setsCorrectError() {
        // GIVEN: Prepare a new error message to be set
        String newError = "Internal Server Error";

        // WHEN: Set the error using setError method
        errorResponse.setError(newError);

        // THEN: Verify that the error has been updated correctly
        assertEquals(newError, errorResponse.getError());
    }

    @Test
    void getMessage_returnsCorrectMessage() {
        // GIVEN: Set a message "Resource not available"
        String expectedMessage = "Resource not available";
        errorResponse.setMessage(expectedMessage);

        // WHEN: Retrieve the message using getMessage method
        String actualMessage = errorResponse.getMessage();

        // THEN: Verify that the retrieved message matches the set value
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void setMessage_setsCorrectMessage() {
        // GIVEN: Prepare a new message to be set
        String newMessage = "Service unavailable";

        // WHEN: Set the message using setMessage method
        errorResponse.setMessage(newMessage);

        // THEN: Verify that the message has been updated correctly
        assertEquals(newMessage, errorResponse.getMessage());
    }
}

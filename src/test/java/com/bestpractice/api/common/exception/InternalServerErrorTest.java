package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InternalServerErrorTests {

    private InternalServerError internalServerError;

    @BeforeEach
    void setUp() {
        // Resetting state before each test
        internalServerError = null;
    }

    @Test
    void givenNoArguments_whenInternalServerErrorIsInstantiated_thenVerifyNoMessageOrCause() {
        // GIVEN: No arguments are provided
        // WHEN: An InternalServerError exception is instantiated
        internalServerError = new InternalServerError();

        // THEN: The message and cause should be null
        assertNull(internalServerError.getMessage(), "Message should be null for default constructor");
        assertNull(internalServerError.getCause(), "Cause should be null for default constructor");
    }

    @Test
    void givenMessage_whenInternalServerErrorIsInstantiated_thenVerifyMessageIsSet() {
        // GIVEN: A message is provided
        String message = "Internal server error occurred";

        // WHEN: An InternalServerError exception is instantiated with a message
        internalServerError = new InternalServerError(message);

        // THEN: The message should match the provided value, and cause should be null
        assertEquals(message, internalServerError.getMessage(), "Message should match the provided value");
        assertNull(internalServerError.getCause(), "Cause should be null when only message is provided");
    }



    @Test
    void givenMessageAndCause_whenInternalServerErrorIsInstantiated_thenVerifyMessageAndCauseAreSet() {
        // GIVEN: Both a message and a cause are provided
        String message = "Internal server error occurred";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN: An InternalServerError exception is instantiated with both a message and a cause
        internalServerError = new InternalServerError(message, cause);

        // THEN: Both the message and cause should match the provided values
        assertEquals(message, internalServerError.getMessage(), "Message should match the provided value");
        assertEquals(cause, internalServerError.getCause(), "Cause should match the provided value");
    }
}
package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RequestTimeoutTests {

    private RequestTimeout requestTimeout;

    @BeforeEach
    void setUp() {
        // Resetting state before each test
        requestTimeout = null;
    }

    @Test
    void givenNoArguments_whenRequestTimeoutIsInstantiated_thenVerifyNoMessageOrCause() {
        // GIVEN: No arguments are provided
        // WHEN: A RequestTimeout exception is instantiated
        requestTimeout = new RequestTimeout();

        // THEN: The message and cause should be null
        assertNull(requestTimeout.getMessage(), "Message should be null for default constructor");
        assertNull(requestTimeout.getCause(), "Cause should be null for default constructor");
    }

    @Test
    void givenMessage_whenRequestTimeoutIsInstantiated_thenVerifyMessageIsSet() {
        // GIVEN: A message is provided
        String message = "Request timed out";

        // WHEN: A RequestTimeout exception is instantiated with a message
        requestTimeout = new RequestTimeout(message);

        // THEN: The message should match the provided value, and cause should be null
        assertEquals(message, requestTimeout.getMessage(), "Message should match the provided value");
        assertNull(requestTimeout.getCause(), "Cause should be null when only message is provided");
    }



    @Test
    void givenMessageAndCause_whenRequestTimeoutIsInstantiated_thenVerifyMessageAndCauseAreSet() {
        // GIVEN: Both a message and a cause are provided
        String message = "Request timed out";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN: A RequestTimeout exception is instantiated with both a message and a cause
        requestTimeout = new RequestTimeout(message, cause);

        // THEN: Both the message and cause should match the provided values
        assertEquals(message, requestTimeout.getMessage(), "Message should match the provided value");
        assertEquals(cause, requestTimeout.getCause(), "Cause should match the provided value");
    }
}
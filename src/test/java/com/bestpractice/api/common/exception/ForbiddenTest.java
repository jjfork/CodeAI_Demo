package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ForbiddenTests {

    private Forbidden forbidden;

    @BeforeEach
    void setUp() {
        // Resetting state before each test
        forbidden = null;
    }

    @Test
    void givenNoArguments_whenForbiddenIsInstantiated_thenVerifyNoMessageOrCause() {
        // GIVEN: No arguments are provided
        // WHEN: A Forbidden exception is instantiated
        forbidden = new Forbidden();

        // THEN: The message and cause should be null
        assertNull(forbidden.getMessage(), "Message should be null for default constructor");
        assertNull(forbidden.getCause(), "Cause should be null for default constructor");
    }

    @Test
    void givenMessage_whenForbiddenIsInstantiated_thenVerifyMessageIsSet() {
        // GIVEN: A message is provided
        String message = "Access denied";

        // WHEN: A Forbidden exception is instantiated with a message
        forbidden = new Forbidden(message);

        // THEN: The message should match the provided value, and cause should be null
        assertEquals(message, forbidden.getMessage(), "Message should match the provided value");
        assertNull(forbidden.getCause(), "Cause should be null when only message is provided");
    }



    @Test
    void givenMessageAndCause_whenForbiddenIsInstantiated_thenVerifyMessageAndCauseAreSet() {
        // GIVEN: Both a message and a cause are provided
        String message = "Access denied";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN: A Forbidden exception is instantiated with both a message and a cause
        forbidden = new Forbidden(message, cause);

        // THEN: Both the message and cause should match the provided values
        assertEquals(message, forbidden.getMessage(), "Message should match the provided value");
        assertEquals(cause, forbidden.getCause(), "Cause should match the provided value");
    }
}
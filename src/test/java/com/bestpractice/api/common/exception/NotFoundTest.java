package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NotFoundTests {

    private NotFound notFound;

    @BeforeEach
    void setUp() {
        // Resetting state before each test
        notFound = null;
    }

    @Test
    void givenNoArguments_whenNotFoundIsInstantiated_thenVerifyNoMessageOrCause() {
        // GIVEN: No arguments are provided
        // WHEN: A NotFound exception is instantiated
        notFound = new NotFound();

        // THEN: The message and cause should be null
        assertNull(notFound.getMessage(), "Message should be null for default constructor");
        assertNull(notFound.getCause(), "Cause should be null for default constructor");
    }

    @Test
    void givenMessage_whenNotFoundIsInstantiated_thenVerifyMessageIsSet() {
        // GIVEN: A message is provided
        String message = "Resource not found";

        // WHEN: A NotFound exception is instantiated with a message
        notFound = new NotFound(message);

        // THEN: The message should match the provided value, and cause should be null
        assertEquals(message, notFound.getMessage(), "Message should match the provided value");
        assertNull(notFound.getCause(), "Cause should be null when only message is provided");
    }



    @Test
    void givenMessageAndCause_whenNotFoundIsInstantiated_thenVerifyMessageAndCauseAreSet() {
        // GIVEN: Both a message and a cause are provided
        String message = "Resource not found";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN: A NotFound exception is instantiated with both a message and a cause
        notFound = new NotFound(message, cause);

        // THEN: Both the message and cause should match the provided values
        assertEquals(message, notFound.getMessage(), "Message should match the provided value");
        assertEquals(cause, notFound.getCause(), "Cause should match the provided value");
    }
}
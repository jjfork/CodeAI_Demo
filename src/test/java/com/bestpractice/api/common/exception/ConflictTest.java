package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ConflictTests {

    private Conflict conflict;

    @BeforeEach
    void setUp() {
        // Resetting state before each test
        conflict = null;
    }

    @Test
    void givenNoArguments_whenConflictIsInstantiated_thenVerifyNoMessageOrCause() {
        // GIVEN: No arguments are provided
        // WHEN: A Conflict exception is instantiated
        conflict = new Conflict();

        // THEN: The message and cause should be null
        assertNull(conflict.getMessage(), "Message should be null for default constructor");
        assertNull(conflict.getCause(), "Cause should be null for default constructor");
    }

    @Test
    void givenMessage_whenConflictIsInstantiated_thenVerifyMessageIsSet() {
        // GIVEN: A message is provided
        String message = "Conflict occurred";

        // WHEN: A Conflict exception is instantiated with a message
        conflict = new Conflict(message);

        // THEN: The message should match the provided value, and cause should be null
        assertEquals(message, conflict.getMessage(), "Message should match the provided value");
        assertNull(conflict.getCause(), "Cause should be null when only message is provided");
    }



    @Test
    void givenMessageAndCause_whenConflictIsInstantiated_thenVerifyMessageAndCauseAreSet() {
        // GIVEN: Both a message and a cause are provided
        String message = "Conflict occurred";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN: A Conflict exception is instantiated with both a message and a cause
        conflict = new Conflict(message, cause);

        // THEN: Both the message and cause should match the provided values
        assertEquals(message, conflict.getMessage(), "Message should match the provided value");
        assertEquals(cause, conflict.getCause(), "Cause should match the provided value");
    }
}
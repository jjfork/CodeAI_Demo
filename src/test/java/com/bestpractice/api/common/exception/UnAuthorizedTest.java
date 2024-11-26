package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnAuthorizedTests {

    private UnAuthorized unAuthorized;

    @BeforeEach
    void setUp() {
        // Resetting state before each test
        unAuthorized = null;
    }

    @Test
    void givenNoArguments_whenUnAuthorizedIsInstantiated_thenVerifyNoMessageOrCause() {
        // GIVEN: No arguments are provided
        // WHEN: An UnAuthorized exception is instantiated
        unAuthorized = new UnAuthorized();

        // THEN: The message and cause should be null
        assertNull(unAuthorized.getMessage(), "Message should be null for default constructor");
        assertNull(unAuthorized.getCause(), "Cause should be null for default constructor");
    }

    @Test
    void givenMessage_whenUnAuthorizedIsInstantiated_thenVerifyMessageIsSet() {
        // GIVEN: A message is provided
        String message = "Unauthorized access";

        // WHEN: An UnAuthorized exception is instantiated with a message
        unAuthorized = new UnAuthorized(message);

        // THEN: The message should match the provided value, and cause should be null
        assertEquals(message, unAuthorized.getMessage(), "Message should match the provided value");
        assertNull(unAuthorized.getCause(), "Cause should be null when only message is provided");
    }


    @Test
    void givenMessageAndCause_whenUnAuthorizedIsInstantiated_thenVerifyMessageAndCauseAreSet() {
        // GIVEN: Both a message and a cause are provided
        String message = "Unauthorized access";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN: An UnAuthorized exception is instantiated with both a message and a cause
        unAuthorized = new UnAuthorized(message, cause);

        // THEN: Both the message and cause should match the provided values
        assertEquals(message, unAuthorized.getMessage(), "Message should match the provided value");
        assertEquals(cause, unAuthorized.getCause(), "Cause should match the provided value");
    }
}
package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ServiceUnavailableTests {

    private ServiceUnavailable serviceUnavailable;

    @BeforeEach
    void setUp() {
        // Resetting state before each test
        serviceUnavailable = null;
    }

    @Test
    void givenNoArguments_whenServiceUnavailableIsInstantiated_thenVerifyNoMessageOrCause() {
        // GIVEN: No arguments are provided
        // WHEN: A ServiceUnavailable exception is instantiated
        serviceUnavailable = new ServiceUnavailable();

        // THEN: The message and cause should be null
        assertNull(serviceUnavailable.getMessage(), "Message should be null for default constructor");
        assertNull(serviceUnavailable.getCause(), "Cause should be null for default constructor");
    }

    @Test
    void givenMessage_whenServiceUnavailableIsInstantiated_thenVerifyMessageIsSet() {
        // GIVEN: A message is provided
        String message = "Service is unavailable";

        // WHEN: A ServiceUnavailable exception is instantiated with a message
        serviceUnavailable = new ServiceUnavailable(message);

        // THEN: The message should match the provided value, and cause should be null
        assertEquals(message, serviceUnavailable.getMessage(), "Message should match the provided value");
        assertNull(serviceUnavailable.getCause(), "Cause should be null when only message is provided");
    }



    @Test
    void givenMessageAndCause_whenServiceUnavailableIsInstantiated_thenVerifyMessageAndCauseAreSet() {
        // GIVEN: Both a message and a cause are provided
        String message = "Service is unavailable";
        Throwable cause = new RuntimeException("Underlying issue");

        // WHEN: A ServiceUnavailable exception is instantiated with both a message and a cause
        serviceUnavailable = new ServiceUnavailable(message, cause);

        // THEN: Both the message and cause should match the provided values
        assertEquals(message, serviceUnavailable.getMessage(), "Message should match the provided value");
        assertEquals(cause, serviceUnavailable.getCause(), "Cause should match the provided value");
    }
}
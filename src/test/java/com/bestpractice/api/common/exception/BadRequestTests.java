package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BadRequestTests {

    private BadRequest badRequest;

    @BeforeEach
    void setUp() {
        // Reset state or initialize objects if needed
        badRequest = null;
    }

    @Test
    void givenNoArguments_whenConstructed_thenExceptionHasNoMessageOrCause() {
        // GIVEN: No arguments for construction

        // WHEN: A BadRequest exception is created
        badRequest = new BadRequest();

        // THEN: The exception should have no message or cause
        assertNull(badRequest.getMessage());
        assertNull(badRequest.getCause());
    }

    @Test
    void givenMessage_whenConstructed_thenExceptionContainsMessage() {
        // GIVEN: A specific error message
        String errorMessage = "Bad request occurred";

        // WHEN: A BadRequest exception is created with the message
        badRequest = new BadRequest(errorMessage);

        // THEN: The exception's message should match the provided message
        assertEquals(errorMessage, badRequest.getMessage());
        assertNull(badRequest.getCause());
    }

    @Test
    void givenCause_whenConstructed_thenExceptionContainsCause() {
        // GIVEN: A specific cause (another exception)
        Throwable cause = new IllegalArgumentException("Invalid argument");

        // WHEN: A BadRequest exception is created with the cause
        badRequest = new BadRequest(cause);

        // THEN: The exception's cause should match the provided cause
        assertEquals(cause, badRequest.getCause());
        assertNotNull(badRequest.getMessage()); // Ensures there's a default message derived from the cause
    }

    @Test
    void givenMessageAndCause_whenConstructed_thenExceptionContainsBoth() {
        // GIVEN: A specific error message and cause
        String errorMessage = "Bad request with cause";
        Throwable cause = new NullPointerException("Null value found");

        // WHEN: A BadRequest exception is created with both message and cause
        badRequest = new BadRequest(errorMessage, cause);

        // THEN: The exception should contain both the provided message and cause
        assertEquals(errorMessage, badRequest.getMessage());
        assertEquals(cause, badRequest.getCause());
    }
}
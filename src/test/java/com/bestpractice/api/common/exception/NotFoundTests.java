package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotFoundTests {

    @BeforeEach
    void setUp() {
        // Reset any state before each test if necessary
    }

    @Test
    void shouldCreateEmptyNotFoundException() {
        // GIVEN: A scenario where we need to create a NotFound exception without any message or cause.
        
        // WHEN: Creating an instance of NotFound using the default constructor.
        NotFound notFound = new NotFound();
        
        // THEN: The exception should be created successfully and have no specific message or cause.
        assertNotNull(notFound);
    }

    @Test
    void shouldCreateNotFoundWithMessage() {
        // GIVEN: A scenario where we need to create a NotFound exception with a specific message.
        String expectedMessage = "Resource not found";
        
        // WHEN: Creating an instance of NotFound using the constructor that takes a message.
        NotFound notFound = new NotFound(expectedMessage);
        
        // THEN: The exception should contain the specified message.
        assertEquals(expectedMessage, notFound.getMessage());
    }

    @Test
    void shouldCreateNotFoundWithCause() {
        // GIVEN: A scenario where we need to create a NotFound exception with a specific cause.
        Throwable expectedCause = new RuntimeException("Underlying issue");
        
        // WHEN: Creating an instance of NotFound using the constructor that takes a cause.
        NotFound notFound = new NotFound(expectedCause);
        
        // THEN: The exception should have the specified cause.
        assertEquals(expectedCause, notFound.getCause());
    }

    @Test
    void shouldCreateNotFoundWithMessageAndCause() {
        // GIVEN: A scenario where we need to create a NotFound exception with both a message and a cause.
        String expectedMessage = "Resource not found";
        Throwable expectedCause = new RuntimeException("Underlying issue");
        
        // WHEN: Creating an instance of NotFound using the constructor that takes both a message and a cause.
        NotFound notFound = new NotFound(expectedMessage, expectedCause);
        
        // THEN: The exception should contain the specified message and cause.
        assertEquals(expectedMessage, notFound.getMessage());
        assertEquals(expectedCause, notFound.getCause());
    }
}

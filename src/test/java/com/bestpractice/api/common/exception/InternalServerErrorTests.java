package com.bestpractice.api.common.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalServerErrorTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConstructor() {
        // GIVEN
        String message = "Test message";
        Throwable cause = new RuntimeException("Test cause");

        // WHEN
        InternalServerError exception = new InternalServerError(message, cause);

        // THEN
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }

    @Test
    void testConstructorWithMessage() {
        // GIVEN
        String message = "Test message";

        // WHEN
        InternalServerError exception = new InternalServerError(message);

        // THEN
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        // GIVEN
        Throwable cause = new RuntimeException("Test cause");

        // WHEN
        InternalServerError exception = new InternalServerError(cause);

        // THEN
        assertSame(cause, exception.getCause());
    }
}

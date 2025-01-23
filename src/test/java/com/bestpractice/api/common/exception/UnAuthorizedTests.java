package com.bestpractice.api.common.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnAuthorizedTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testConstructor() {
        // GIVEN
        UnAuthorized unauthorized = new UnAuthorized();
        // WHEN
        // THEN
        assertNotNull(unauthorized);
    }

    @Test
    void testConstructorWithMessage() {
        // GIVEN
        String message = "Unauthorized access";
        UnAuthorized unauthorized = new UnAuthorized(message);
        // WHEN
        // THEN
        assertEquals(message, unauthorized.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        // GIVEN
        Throwable cause = new RuntimeException("Some error");
        UnAuthorized unauthorized = new UnAuthorized(cause);
        // WHEN
        // THEN
        assertEquals(cause, unauthorized.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        // GIVEN
        String message = "Unauthorized access";
        Throwable cause = new RuntimeException("Some error");
        UnAuthorized unauthorized = new UnAuthorized(message, cause);
        // WHEN
        // THEN
        assertEquals(message, unauthorized.getMessage());
        assertEquals(cause, unauthorized.getCause());
    }
}

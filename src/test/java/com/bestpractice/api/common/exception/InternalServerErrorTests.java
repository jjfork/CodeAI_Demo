package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InternalServerErrorTests {

    @Test
    void testDefaultConstructor() {
        InternalServerError internalServerError = new InternalServerError();
        assertNotNull(internalServerError);
    }

    @Test
    void testConstructorWithMessage() {
        String errorMessage = "Error Message";
        InternalServerError internalServerError = new InternalServerError(errorMessage);
        assertNotNull(internalServerError);
        assertEquals(errorMessage, internalServerError.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Cause");
        InternalServerError internalServerError = new InternalServerError(cause);
        assertNotNull(internalServerError);
        assertEquals(cause, internalServerError.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String errorMessage = "Error Message";
        Throwable cause = new RuntimeException("Cause");
        InternalServerError internalServerError = new InternalServerError(errorMessage, cause);
        assertNotNull(internalServerError);
        assertEquals(errorMessage, internalServerError.getMessage());
        assertEquals(cause, internalServerError.getCause());
    }
}

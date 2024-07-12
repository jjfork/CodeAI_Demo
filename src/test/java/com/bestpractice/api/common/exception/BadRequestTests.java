package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BadRequestTests {

    @Test
    void testDefaultConstructor() {
        BadRequest exception = new BadRequest();
        assertThrows(BadRequest.class, () -> {
            throw exception;
        });
    }

    @Test
    void testMessageConstructor() {
        String message = "Invalid request";
        BadRequest exception = new BadRequest(message);
        assertThrows(BadRequest.class, () -> {
            throw exception;
        });
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new Exception("Some error");
        BadRequest exception = new BadRequest(cause);
        assertThrows(BadRequest.class, () -> {
            throw exception;
        });
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testMessageAndCauseConstructor() {
        String message = "Invalid request";
        Throwable cause = new Exception("Some error");
        BadRequest exception = new BadRequest(message, cause);
        assertThrows(BadRequest.class, () -> {
            throw exception;
        });
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}

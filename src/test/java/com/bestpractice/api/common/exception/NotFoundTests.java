package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NotFoundTests {

    @Test
    void testDefaultConstructor() {
        assertThrows(NotFound.class, () -> { throw new NotFound(); });
    }

    @Test
    void testMessageConstructor() {
        String message = "test message";
        assertThrows(NotFound.class, () -> { throw new NotFound(message); });
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new Exception();
        assertThrows(NotFound.class, () -> { throw new NotFound(cause); });
    }

    @Test
    void testMessageAndCauseConstructor() {
        String message = "test message";
        Throwable cause = new Exception();
        assertThrows(NotFound.class, () -> { throw new NotFound(message, cause); });
    }
}
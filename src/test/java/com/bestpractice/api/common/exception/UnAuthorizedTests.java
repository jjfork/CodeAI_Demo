package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnAuthorizedTests {

    @Test
    void testDefaultConstructor() {
        assertThrows(UnAuthorized.class, () -> { throw new UnAuthorized(); });
    }

    @Test
    void testMessageConstructor() {
        String message = "test message";
        assertThrows(UnAuthorized.class, () -> { throw new UnAuthorized(message); });
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new Exception();
        assertThrows(UnAuthorized.class, () -> { throw new UnAuthorized(cause); });
    }

    @Test
    void testMessageAndCauseConstructor() {
        String message = "test message";
        Throwable cause = new Exception();
        assertThrows(UnAuthorized.class, () -> { throw new UnAuthorized(message, cause); });
    }
}
package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnAuthorizedTests {

    @Test
    void testDefaultConstructor() {
        UnAuthorized unAuthorized = new UnAuthorized();
        assertNotNull(unAuthorized);
    }

    @Test
    void testMessageConstructor() {
        String message = "Unauthorized access";
        UnAuthorized unAuthorized = new UnAuthorized(message);
        assertEquals(message, unAuthorized.getMessage());
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new RuntimeException("Cause");
        UnAuthorized unAuthorized = new UnAuthorized(cause);
        assertEquals(cause, unAuthorized.getCause());
    }

    @Test
    void testMessageAndCauseConstructor() {
        String message = "Unauthorized access";
        Throwable cause = new RuntimeException("Cause");
        UnAuthorized unAuthorized = new UnAuthorized(message, cause);
        assertEquals(message, unAuthorized.getMessage());
        assertEquals(cause, unAuthorized.getCause());
    }
}

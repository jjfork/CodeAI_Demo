package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ForbiddenTests {

    @Test
    void testForbidden() {
        Forbidden exception = new Forbidden();
        assertThrows(Forbidden.class, () -> {
            throw exception;
        });
    }

    @Test
    void testForbiddenWithMessage() {
        String message = "Custom message";
        Forbidden exception = new Forbidden(message);
        assertThrows(Forbidden.class, () -> {
            throw exception;
        }, message);
    }

    @Test
    void testForbiddenWithCause() {
        Throwable cause = new Exception("Cause");
        Forbidden exception = new Forbidden(cause);
        assertThrows(Forbidden.class, () -> {
            throw exception;
        });
    }

    @Test
    void testForbiddenWithMessageAndCause() {
        String message = "Custom message";
        Throwable cause = new Exception("Cause");
        Forbidden exception = new Forbidden(message, cause);
        assertThrows(Forbidden.class, () -> {
            throw exception;
        }, message);
    }
}

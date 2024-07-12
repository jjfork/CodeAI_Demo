package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForbiddenTests {

    @Test
    void testConstructorNoArgs() {
        Forbidden forbidden = new Forbidden();
        assertNotNull(forbidden);
    }

    @Test
    void testConstructorWithMessage() {
        Forbidden forbidden = new Forbidden("Access Forbidden");
        assertEquals("Access Forbidden", forbidden.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Cause of Forbidden");
        Forbidden forbidden = new Forbidden(cause);
        assertEquals(cause, forbidden.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        Throwable cause = new RuntimeException("Cause of Forbidden");
        Forbidden forbidden = new Forbidden("Access Forbidden", cause);
        assertEquals("Access Forbidden", forbidden.getMessage());
        assertEquals(cause, forbidden.getCause());
    }
}

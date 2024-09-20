package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnAuthorizedTests {

    @Test
    void testUnAuthorized() {
        UnAuthorized unauthorized = new UnAuthorized();
        assertNotNull(unauthorized);
    }

    @Test
    void testUnAuthorizedString() {
        String message = "Unauthorized Access";
        UnAuthorized unauthorized = new UnAuthorized(message);
        assertEquals(message, unauthorized.getMessage());
    }

    @Test
    void testUnAuthorizedThrowable() {
        Throwable cause = new RuntimeException();
        UnAuthorized unauthorized = new UnAuthorized(cause);
        assertSame(cause, unauthorized.getCause());
    }

    @Test
    void testUnAuthorizedStringThrowable() {
        String message = "Unauthorized Access";
        Throwable cause = new RuntimeException();
        UnAuthorized unauthorized = new UnAuthorized(message, cause);
        assertEquals(message, unauthorized.getMessage());
        assertSame(cause, unauthorized.getCause());
    }
} 

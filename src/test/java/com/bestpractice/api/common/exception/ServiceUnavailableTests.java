package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceUnavailableTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testServiceUnavailable() {
        // GIVEN - 
        // WHEN - 
        ServiceUnavailable exception = new ServiceUnavailable();
        // THEN - 
        assertNotNull(exception);
    }

    @Test
    void testServiceUnavailableString() {
        // GIVEN - 
        String message = "Test Message";
        // WHEN - 
        ServiceUnavailable exception = new ServiceUnavailable(message);
        // THEN - 
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testServiceUnavailableThrowable() {
        // GIVEN - 
        Throwable cause = new RuntimeException();
        // WHEN - 
        ServiceUnavailable exception = new ServiceUnavailable(cause);
        // THEN - 
        assertSame(cause, exception.getCause());
    }

    @Test
    void testServiceUnavailableStringThrowable() {
        // GIVEN - 
        String message = "Test Message";
        Throwable cause = new RuntimeException();
        // WHEN - 
        ServiceUnavailable exception = new ServiceUnavailable(message, cause);
        // THEN - 
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
}

package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceUnavailableTests {

    @Test
    void testServiceUnavailable() {
        ServiceUnavailable exception = new ServiceUnavailable();
        assertNotNull(exception);
    }

    @Test
    void testServiceUnavailableString() {
        String message = "Test Message";
        ServiceUnavailable exception = new ServiceUnavailable(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testServiceUnavailableThrowable() {
        Throwable cause = new RuntimeException();
        ServiceUnavailable exception = new ServiceUnavailable(cause);
        assertSame(cause, exception.getCause());
    }

    @Test
    void testServiceUnavailableStringThrowable() {
        String message = "Test Message";
        Throwable cause = new RuntimeException();
        ServiceUnavailable exception = new ServiceUnavailable(message, cause);
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
} 

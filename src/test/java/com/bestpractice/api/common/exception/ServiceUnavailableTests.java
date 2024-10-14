package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
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
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable();
        assertNotNull(serviceUnavailable);
    }

    @Test
    void testServiceUnavailableString() {
        String message = "Test Message";
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable(message);
        assertEquals(message, serviceUnavailable.getMessage());
    }

    @Test
    void testServiceUnavailableThrowable() {
        Throwable cause = new RuntimeException();
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable(cause);
        assertSame(cause, serviceUnavailable.getCause());
    }

    @Test
    void testServiceUnavailableStringThrowable() {
        String message = "Test Message";
        Throwable cause = new RuntimeException();
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable(message, cause);
        assertEquals(message, serviceUnavailable.getMessage());
        assertSame(cause, serviceUnavailable.getCause());
    }
}

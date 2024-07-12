package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceUnavailableTests {

    @Test
    void testDefaultConstructor() {
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable();
        assertNotNull(serviceUnavailable);
    }

    @Test
    void testMessageConstructor() {
        String message = "Service Unavailable";
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable(message);
        assertEquals(message, serviceUnavailable.getMessage());
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new RuntimeException("Test Cause");
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable(cause);
        assertEquals(cause, serviceUnavailable.getCause());
    }

    @Test
    void testMessageAndCauseConstructor() {
        String message = "Service Unavailable";
        Throwable cause = new RuntimeException("Test Cause");
        ServiceUnavailable serviceUnavailable = new ServiceUnavailable(message, cause);
        assertEquals(message, serviceUnavailable.getMessage());
        assertEquals(cause, serviceUnavailable.getCause());
    }
}

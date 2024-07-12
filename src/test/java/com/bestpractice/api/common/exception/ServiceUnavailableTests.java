package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceUnavailableTests {

    @Test
    void testDefaultConstructor() {
        ServiceUnavailable exception = new ServiceUnavailable();
        assertThrows(ServiceUnavailable.class, () -> {
            throw exception;
        });
    }

    @Test
    void testMessageConstructor() {
        String message = "Service unavailable";
        ServiceUnavailable exception = new ServiceUnavailable(message);
        assertThrows(ServiceUnavailable.class, () -> {
            throw exception;
        });
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new Exception("Some error");
        ServiceUnavailable exception = new ServiceUnavailable(cause);
        assertThrows(ServiceUnavailable.class, () -> {
            throw exception;
        });
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testMessageAndCauseConstructor() {
        String message = "Service unavailable";
        Throwable cause = new Exception("Some error");
        ServiceUnavailable exception = new ServiceUnavailable(message, cause);
        assertThrows(ServiceUnavailable.class, () -> {
            throw exception;
        });
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}

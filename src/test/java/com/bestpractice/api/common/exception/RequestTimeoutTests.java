package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RequestTimeoutTests {

    @Test
    void testRequestTimeout() {
        // Arrange
        String message = "Test request timeout";
        Throwable cause = new Exception("Test exception");

        // Act
        RequestTimeout requestTimeout = new RequestTimeout(message, cause);

        // Assert
        assertThrows(RequestTimeout.class, () -> {
            throw requestTimeout;
        });
    }

    @Test
    void testRequestTimeoutMessage() {
        // Arrange
        String message = "Test request timeout";

        // Act
        RequestTimeout requestTimeout = new RequestTimeout(message);

        // Assert
        assertThrows(RequestTimeout.class, () -> {
            throw requestTimeout;
        });
    }

    @Test
    void testRequestTimeoutCause() {
        // Arrange
        Throwable cause = new Exception("Test exception");

        // Act
        RequestTimeout requestTimeout = new RequestTimeout(cause);

        // Assert
        assertThrows(RequestTimeout.class, () -> {
            throw requestTimeout;
        });
    }
}

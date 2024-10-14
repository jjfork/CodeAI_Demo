package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTimeoutTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testRequestTimeout() {
        RequestTimeout exception = new RequestTimeout();
        assertNotNull(exception);
    }

    @Test
    void testRequestTimeoutString() {
        String message = "Request timed out";
        RequestTimeout exception = new RequestTimeout(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testRequestTimeoutThrowable() {
        Throwable cause = new RuntimeException();
        RequestTimeout exception = new RequestTimeout(cause);
        assertSame(cause, exception.getCause());
    }

    @Test
    void testRequestTimeoutStringThrowable() {
        String message = "Request timed out";
        Throwable cause = new RuntimeException();
        RequestTimeout exception = new RequestTimeout(message, cause);
        assertEquals(message, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
}

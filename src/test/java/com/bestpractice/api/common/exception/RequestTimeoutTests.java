package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestTimeoutTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testRequestTimeout() {
        // GIVEN - 
        // WHEN -  
        RequestTimeout exception = new RequestTimeout();
        // THEN - assertNotNull(exception);
    }

    @Test
    void testRequestTimeoutWithMessage() {
        // GIVEN - 
        String message = "Request timed out";
        // WHEN -  
        RequestTimeout exception = new RequestTimeout(message);
        // THEN - assertEquals(message, exception.getMessage());
    }

    @Test
    void testRequestTimeoutWithCause() {
        // GIVEN - 
        Throwable cause = new RuntimeException();
        // WHEN -  
        RequestTimeout exception = new RequestTimeout(cause);
        // THEN - assertEquals(cause, exception.getCause());
    }

    @Test
    void testRequestTimeoutWithMessageAndCause() {
        // GIVEN - 
        String message = "Request timed out";
        Throwable cause = new RuntimeException();
        // WHEN -  
        RequestTimeout exception = new RequestTimeout(message, cause);
        // THEN - assertEquals(message, exception.getMessage());
        // AND assertEquals(cause, exception.getCause());
    }
}

package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InternalServerErrorTests {

    @Test
    void testConstructorWithoutArgs() {
        InternalServerError exception = new InternalServerError();
        assertThrows(InternalServerError.class, () -> {
            throw exception;
        });
    }

    @Test
    void testConstructorWithMsg() {
        String msg = "Test message";
        InternalServerError exception = new InternalServerError(msg);
        assertThrows(InternalServerError.class, () -> {
            throw exception;
        });
        assertEquals(msg, exception.getMessage());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new Exception("Test cause");
        InternalServerError exception = new InternalServerError(cause);
        assertThrows(InternalServerError.class, () -> {
            throw exception;
        });
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithMsgAndCause() {
        String msg = "Test message";
        Throwable cause = new Exception("Test cause");
        InternalServerError exception = new InternalServerError(msg, cause);
        assertThrows(InternalServerError.class, () -> {
            throw exception;
        });
        assertEquals(msg, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}

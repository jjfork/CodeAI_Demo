package com.bestpractice.api.common.exception;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadRequestTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testBadRequest() {
        // GIVEN - 
        BadRequest exception = new BadRequest();
        // WHEN - 
        // THEN - assertThat(exception.getMessage(), isNull());
    }

    @Test
    void testBadRequestString() {
        // GIVEN - String message = "Bad Request";
        BadRequest exception = new BadRequest("Bad Request");
        // WHEN - 
        // THEN - assertThat(exception.getMessage(), is("Bad Request"));
    }

    @Test
    void testBadRequestThrowable() {
        // GIVEN - Throwable cause = new RuntimeException();
        BadRequest exception = new BadRequest(new RuntimeException());
        // WHEN - 
        // THEN - assertThat(exception.getCause(), is(cause));
    }

    @Test
    void testBadRequestStringThrowable() {
        // GIVEN - String message = "Bad Request";
        // GIVEN - Throwable cause = new RuntimeException();
        BadRequest exception = new BadRequest("Bad Request", new RuntimeException());
        // WHEN - 
        // THEN - assertThat(exception.getMessage(), is("Bad Request"));
        // THEN - assertThat(exception.getCause(), is(cause));
    }
}

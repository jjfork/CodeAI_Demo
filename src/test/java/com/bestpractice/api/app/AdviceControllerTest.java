package com.bestpractice.api.app;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.Forbidden;
import com.bestpractice.api.common.exception.NotFound;
import com.bestpractice.api.common.exception.UnAuthorized;
import com.bestpractice.api.domain.model.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.NoHandlerFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AdviceControllerTests {

    private AdviceController adviceController;

    @BeforeEach
    void setUp() {
        adviceController = new AdviceController();
    }

    @Test
    void testBadRequest() {
        // GIVEN: A BadRequest exception is thrown

        // WHEN: The badRequest handler is called
        ErrorResponse response = adviceController.badRequest();

        // THEN: Verify the response
        assertNotNull(response);
        assertEquals(400, response.getStatus());
        assertEquals("Bad request", response.getError());
        assertEquals("Bad request parameter", response.getMessage());
    }

    @Test
    void testUnAuthorized() {
        // GIVEN: An UnAuthorized exception is thrown

        // WHEN: The unAuthorized handler is called
        ErrorResponse response = adviceController.unAuthorized();

        // THEN: Verify the response
        assertNotNull(response);
        assertEquals(401, response.getStatus());
        assertEquals("Unauthorized", response.getError());
        assertEquals("Incorrect authentication info", response.getMessage());
    }

    @Test
    void testForbidden() {
        // GIVEN: A Forbidden exception is thrown

        // WHEN: The forbidden handler is called
        ErrorResponse response = adviceController.forbidden();

        // THEN: Verify the response
        assertNotNull(response);
        assertEquals(403, response.getStatus());
        assertEquals("Forbidden", response.getError());
        assertEquals("Not allowed", response.getMessage());
    }

    @Test
    void testNotFound01() {
        // GIVEN: A NoHandlerFoundException is thrown

        // WHEN: The notFound01 handler is called
        ErrorResponse response = adviceController.notFound01();

        // THEN: Verify the response
        assertNotNull(response);
        assertEquals(404, response.getStatus());
        assertEquals("Not found", response.getError());
        assertEquals("Not found path", response.getMessage());
    }

    @Test
    void testNotFound02() {
        // GIVEN: A NotFound exception is thrown

        // WHEN: The notFound02 handler is called
        ErrorResponse response = adviceController.notFound02();

        // THEN: Verify the response
        assertNotNull(response);
        assertEquals(404, response.getStatus());
        assertEquals("Not found", response.getError());
        assertEquals("Not found path", response.getMessage());
    }

    @Test
    void testConflict() {
        // GIVEN: A Conflict exception is thrown

        // WHEN: The conflict handler is called
        ErrorResponse response = adviceController.conflict();

        // THEN: Verify the response
        assertNotNull(response);
        assertEquals(409, response.getStatus());
        assertEquals("Conflict", response.getError());
        assertEquals("Already exist data", response.getMessage());
    }

    @Test
    void testServerError() {
        // GIVEN: A generic Exception is thrown
        Exception exception = new Exception("Unexpected error");

        // WHEN: The serverError handler is called
        ErrorResponse response = adviceController.serverError(exception);

        // THEN: Verify the response
        assertNotNull(response);
        assertEquals(500, response.getStatus());
        assertEquals("Internal server error", response.getError());
        assertEquals("Internal server error", response.getMessage());
    }
}

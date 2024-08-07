package com.bestpractice.api.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.Forbidden;
import com.bestpractice.api.common.exception.NotFound;
import com.bestpractice.api.common.exception.UnAuthorized;
import com.bestpractice.api.domain.model.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AdviceControllerTests {

    @Test
    public void testBadRequest() {
        BadRequest badRequest = new BadRequest();
        ErrorResponse response = new AdviceController().badRequest();
        // ASSERTION
    }

    @Test
    public void testUnAuthorized() {
        UnAuthorized unAuthorized = new UnAuthorized();
        ErrorResponse response = new AdviceController().unAuthorized();
        // ASSERTION
    }

    @Test
    public void testForbidden() {
        Forbidden forbidden = new Forbidden();
        ErrorResponse response = new AdviceController().forbidden();
        // ASSERTION
    }

    @Test
    public void testNotFound01() {
        NotFound notFound = new NotFound();
        ErrorResponse response = new AdviceController().notFound01();
        // ASSERTION
    }

    @Test
    public void testNotFound02() {
        NotFound notFound = new NotFound();
        ErrorResponse response = new AdviceController().notFound02();
        // ASSERTION
    }

    @Test
    public void testConflict() {
        Conflict conflict = new Conflict();
        ErrorResponse response = new AdviceController().conflict();
        // ASSERTION
    }

    @Test
    public void testServerError() {
        Exception exception = new Exception();
        ErrorResponse response = new AdviceController().serverError(exception);
        // ASSERTION
    }
}

package com.bestpractice.api.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.Forbidden;
import com.bestpractice.api.common.exception.NotFound;
import com.bestpractice.api.common.exception.UnAuthorized;
import com.bestpractice.api.domain.model.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class AdviceControllerTests {

    @Test
    public void testBadRequest() {
        // UNKNOWN
        // ASSERTION
    }

    @Test
    public void testUnAuthorized() {
        // UNKNOWN
        // ASSERTION
    }

    @Test
    public void testForbidden() {
        // UNKNOWN
        // ASSERTION
    }

    @Test
    public void testNotFound01() {
        // UNKNOWN
        // ASSERTION
    }

    @Test
    public void testNotFound02() {
        // UNKNOWN
        // ASSERTION
    }

    @Test
    public void testConflict() {
        // UNKNOWN
        // ASSERTION
    }

    @Test
    public void testServerError() {
        // UNKNOWN
        // ASSERTION
    }
}

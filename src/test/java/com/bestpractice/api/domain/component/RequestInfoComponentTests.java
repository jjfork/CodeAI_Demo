package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequestInfoComponentTests {

    private RequestInfoComponent requestInfoComponent;

    @BeforeEach
    void setUp() {
        requestInfoComponent = new RequestInfoComponent();
    }

    @Test
    void testGetUserIdAndSetUserId() {
        // GIVEN a userId to set
        String userId = "user123";

        // WHEN setting the userId
        requestInfoComponent.setUserId(userId);

        // THEN the retrieved userId should match the one that was set
        assertEquals(userId, requestInfoComponent.getUserId());
    }

    @Test
    void testGetUserEmailAndSetUserEmail() {
        // GIVEN a userEmail to set
        String userEmail = "user@example.com";

        // WHEN setting the userEmail
        requestInfoComponent.setUserEmail(userEmail);

        // THEN the retrieved userEmail should match the one that was set
        assertEquals(userEmail, requestInfoComponent.getUserEmail());
    }

    @Test
    void testIsRefreshTokenAndSetRefreshToken() {
        // GIVEN a boolean value for refreshToken
        boolean isRefreshToken = true;

        // WHEN setting the refreshToken status
        requestInfoComponent.setRefreshToken(isRefreshToken);

        // THEN the retrieved refreshToken status should match the one that was set
        assertTrue(requestInfoComponent.isRefreshToken());
    }

    @Test
    void testGetPathAndSetPath() {
        // GIVEN a path to set
        String path = "/api/resource";

        // WHEN setting the path
        requestInfoComponent.setPath(path);

        // THEN the retrieved path should match the one that was set
        assertEquals(path, requestInfoComponent.getPath());
    }

    @Test
    void testGetHttpMethodAndSetHttpMethod() {
        // GIVEN an http method to set
        String httpMethod = "GET";

        // WHEN setting the http method
        requestInfoComponent.setHttpMethod(httpMethod);

        // THEN the retrieved http method should match the one that was set
        assertEquals(httpMethod, requestInfoComponent.getHttpMethod());
    }

    @Test
    void testGetRequestIdAndSetRequestId() {
        // GIVEN a requestId to set
        String requestId = "req-12345";

        // WHEN setting the requestId
        requestInfoComponent.setRequestId(requestId);

        // THEN the retrieved requestId should match the one that was set
        assertEquals(requestId, requestInfoComponent.getRequestId());
    }
}

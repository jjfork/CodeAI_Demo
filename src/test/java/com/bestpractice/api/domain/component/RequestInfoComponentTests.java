package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestInfoComponentTests {

    private RequestInfoComponent requestInfoComponent;

    @BeforeEach
    void setUp() {
        requestInfoComponent = new RequestInfoComponent();
    }

    @Test
    void testGetUserId() {
        String userId = "testUserId";
        requestInfoComponent.setUserId(userId);
        assertEquals(userId, requestInfoComponent.getUserId());
    }

    @Test
    void testSetUserId() {
        String userId = "testUserId";
        requestInfoComponent.setUserId(userId);
        assertEquals(userId, requestInfoComponent.getUserId());
    }

    @Test
    void testGetUserEmail() {
        String userEmail = "testUserEmail";
        requestInfoComponent.setUserEmail(userEmail);
        assertEquals(userEmail, requestInfoComponent.getUserEmail());
    }

    @Test
    void testSetUserEmail() {
        String userEmail = "testUserEmail";
        requestInfoComponent.setUserEmail(userEmail);
        assertEquals(userEmail, requestInfoComponent.getUserEmail());
    }

    @Test
    void testGetRefreshToken() {
        boolean isRefreshToken = true;
        requestInfoComponent.setRefreshToken(isRefreshToken);
        assertEquals(isRefreshToken, requestInfoComponent.isRefreshToken());
    }

    @Test
    void testSetRefreshToken() {
        boolean isRefreshToken = true;
        requestInfoComponent.setRefreshToken(isRefreshToken);
        assertEquals(isRefreshToken, requestInfoComponent.isRefreshToken());
    }

    @Test
    void testGetPath() {
        String path = "testPath";
        requestInfoComponent.setPath(path);
        assertEquals(path, requestInfoComponent.getPath());
    }

    @Test
    void testSetPath() {
        String path = "testPath";
        requestInfoComponent.setPath(path);
        assertEquals(path, requestInfoComponent.getPath());
    }

    @Test
    void testGetHttpMethod() {
        String httpMethod = "testHttpMethod";
        requestInfoComponent.setHttpMethod(httpMethod);
        assertEquals(httpMethod, requestInfoComponent.getHttpMethod());
    }

    @Test
    void testSetHttpMethod() {
        String httpMethod = "testHttpMethod";
        requestInfoComponent.setHttpMethod(httpMethod);
        assertEquals(httpMethod, requestInfoComponent.getHttpMethod());
    }

    @Test
    void testGetRequestId() {
        String requestId = "testRequestId";
        requestInfoComponent.setRequestId(requestId);
        assertEquals(requestId, requestInfoComponent.getRequestId());
    }

    @Test
    void testSetRequestId() {
        String requestId = "testRequestId";
        requestInfoComponent.setRequestId(requestId);
        assertEquals(requestId, requestInfoComponent.getRequestId());
    }
}

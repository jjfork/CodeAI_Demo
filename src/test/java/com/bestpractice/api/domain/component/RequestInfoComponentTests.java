package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

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
    // GIVEN - 
    String userId = "testUserId";
    // WHEN - setUserId is called with the userId
    requestInfoComponent.setUserId(userId);
    // THEN - getUserId returns the expected userId
    assertEquals(userId, requestInfoComponent.getUserId());
  }

  @Test
  void testSetUserId() {
    // GIVEN - 
    String userId = "testUserId";
    // WHEN - setUserId is called with the userId
    requestInfoComponent.setUserId(userId);
    // THEN - getUserId returns the expected userId
    assertEquals(userId, requestInfoComponent.getUserId());
  }

  @Test
  void testGetHttpMethod() {
    // GIVEN - 
    String httpMethod = "GET";
    // WHEN - setHttpMethod is called with the httpMethod
    requestInfoComponent.setHttpMethod(httpMethod);
    // THEN - getHttpMethod returns the expected httpMethod
    assertEquals(httpMethod, requestInfoComponent.getHttpMethod());
  }

  @Test
  void testSetHttpMethod() {
    // GIVEN - 
    String httpMethod = "GET";
    // WHEN - setHttpMethod is called with the httpMethod
    requestInfoComponent.setHttpMethod(httpMethod);
    // THEN - getHttpMethod returns the expected httpMethod
    assertEquals(httpMethod, requestInfoComponent.getHttpMethod());
  }

  @Test
  void testGetRequestId() {
    // GIVEN - 
    String requestId = "testRequestId";
    // WHEN - setRequestId is called with the requestId
    requestInfoComponent.setRequestId(requestId);
    // THEN - getRequestId returns the expected requestId
    assertEquals(requestId, requestInfoComponent.getRequestId());
  }

  @Test
  void testSetRequestId() {
    // GIVEN - 
    String requestId = "testRequestId";
    // WHEN - setRequestId is called with the requestId
    requestInfoComponent.setRequestId(requestId);
    // THEN - getRequestId returns the expected requestId
    assertEquals(requestId, requestInfoComponent.getRequestId());
  }

  @Test
  void testGetPath() {
    // GIVEN - 
    String path = "/testPath";
    // WHEN - setPath is called with the path
    requestInfoComponent.setPath(path);
    // THEN - getPath returns the expected path
    assertEquals(path, requestInfoComponent.getPath());
  }

  @Test
  void testSetPath() {
    // GIVEN - 
    String path = "/testPath";
    // WHEN - setPath is called with the path
    requestInfoComponent.setPath(path);
    // THEN - getPath returns the expected path
    assertEquals(path, requestInfoComponent.getPath());
  }

}

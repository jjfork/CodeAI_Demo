package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RequestInfoComponentTests {

  @Test
  void testGetUserId() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setUserId("testUserId");
    assertEquals("testUserId", requestInfoComponent.getUserId());
  }

  @Test
  void testSetUserId() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setUserId("testUserId");
    assertEquals("testUserId", requestInfoComponent.getUserId());
  }

  @Test
  void testGetUserEmail() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setUserEmail("testUserEmail");
    assertEquals("testUserEmail", requestInfoComponent.getUserEmail());
  }

  @Test
  void testSetUserEmail() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setUserEmail("testUserEmail");
    assertEquals("testUserEmail", requestInfoComponent.getUserEmail());
  }

  @Test
  void testGetRefreshToken() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setRefreshToken(true);
    assertTrue(requestInfoComponent.isRefreshToken());
  }

  @Test
  void testSetRefreshToken() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setRefreshToken(true);
    assertTrue(requestInfoComponent.isRefreshToken());
  }

  @Test
  void testGetPath() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setPath("testPath");
    assertEquals("testPath", requestInfoComponent.getPath());
  }

  @Test
  void testSetPath() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setPath("testPath");
    assertEquals("testPath", requestInfoComponent.getPath());
  }

  @Test
  void testGetHttpMethod() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setHttpMethod("testHttpMethod");
    assertEquals("testHttpMethod", requestInfoComponent.getHttpMethod());
  }

  @Test
  void testSetHttpMethod() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setHttpMethod("testHttpMethod");
    assertEquals("testHttpMethod", requestInfoComponent.getHttpMethod());
  }

  @Test
  void testGetRequestId() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setRequestId("testRequestId");
    assertEquals("testRequestId", requestInfoComponent.getRequestId());
  }

  @Test
  void testSetRequestId() {
    RequestInfoComponent requestInfoComponent = new RequestInfoComponent();
    requestInfoComponent.setRequestId("testRequestId");
    assertEquals("testRequestId", requestInfoComponent.getRequestId());
  }
} 

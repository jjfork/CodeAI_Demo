package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoResponseTests {

  private String id;
  private String title;
  private String description;
  private InfoResponse infoResponse;

  @BeforeEach
  void setUp() {
    id = "testId";
    title = "testTitle";
    description = "testDescription";
    infoResponse = new InfoResponse(id, title, description);
  }

  @Test
  void testGetId() {
    assertEquals(id, infoResponse.getId());
  }

  @Test
  void testGetTitle() {
    assertEquals(title, infoResponse.getTitle());
  }

  @Test
  void testGetDescription() {
    assertEquals(description, infoResponse.getDescription());
  }
}

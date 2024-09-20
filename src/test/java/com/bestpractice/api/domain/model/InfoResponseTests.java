package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InfoResponseTests {

  @Test
  void testGetId() {
    InfoResponse infoResponse = new InfoResponse("id1", "title1", "description1");
    assertEquals("id1", infoResponse.getId());
  }

  @Test
  void testGetTitle() {
    InfoResponse infoResponse = new InfoResponse("id1", "title1", "description1");
    assertEquals("title1", infoResponse.getTitle());
  }

  @Test
  void testGetDescription() {
    InfoResponse infoResponse = new InfoResponse("id1", "title1", "description1");
    assertEquals("description1", infoResponse.getDescription());
  }
} 

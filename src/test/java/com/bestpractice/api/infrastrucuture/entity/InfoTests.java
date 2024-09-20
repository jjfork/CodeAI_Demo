package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InfoTests {

    @Test
    void testGetId() {
        Info info = new Info();
        info.setId("testId");
        assertEquals("testId", info.getId());
    }

    @Test
    void testSetId() {
        Info info = new Info();
        info.setId("testId");
        assertEquals("testId", info.getId());
    }

    @Test
    void testGetTitle() {
        Info info = new Info();
        info.setTitle("testTitle");
        assertEquals("testTitle", info.getTitle());
    }

    @Test
    void testSetTitle() {
        Info info = new Info();
        info.setTitle("testTitle");
        assertEquals("testTitle", info.getTitle());
    }

    @Test
    void testGetDescription() {
        Info info = new Info();
        info.setDescription("testDescription");
        assertEquals("testDescription", info.getDescription());
    }

    @Test
    void testSetDescription() {
        Info info = new Info();
        info.setDescription("testDescription");
        assertEquals("testDescription", info.getDescription());
    }
}

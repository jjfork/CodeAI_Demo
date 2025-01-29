package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class InfoTests {

    private Info info;

    @BeforeEach
    void setUp() {
        info = new Info();
    }

    @Test
    void testGetId() {
        // GIVEN - An instance of Info
        // WHEN - getId() is called
        String id = info.getId();
        // THEN - The returned ID should be null
        assertNull(id);
    }

    @Test
    void testSetId() {
        // GIVEN - An instance of Info
        // WHEN - setId("testId") is called
        info.setId("testId");
        // THEN - The ID should be set to "testId"
        assertEquals("testId", info.getId());
    }

    @Test
    void testGetTitle() {
        // GIVEN - An instance of Info
        // WHEN - getTitle() is called
        String title = info.getTitle();
        // THEN - The returned title should be null
        assertNull(title);
    }

    @Test
    void testSetTitle() {
        // GIVEN - An instance of Info
        // WHEN - setTitle("testTitle") is called
        info.setTitle("testTitle");
        // THEN - The title should be set to "testTitle"
        assertEquals("testTitle", info.getTitle());
    }

    @Test
    void testGetDescription() {
        // GIVEN - An instance of Info
        // WHEN - getDescription() is called
        String description = info.getDescription();
        // THEN - The returned description should be null
        assertNull(description);
    }

    @Test
    void testSetDescription() {
        // GIVEN - An instance of Info
        // WHEN - setDescription("testDescription") is called
        info.setDescription("testDescription");
        // THEN - The description should be set to "testDescription"
        assertEquals("testDescription", info.getDescription());
    }

}
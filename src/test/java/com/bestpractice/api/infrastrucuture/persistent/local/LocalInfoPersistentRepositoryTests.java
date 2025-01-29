package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InfoTests {

    private Info info;

    @BeforeEach
    void setUp() {
        info = new Info();
        info.setId("testId");
        info.setTitle("testTitle");
        info.setDescription("testDescription");
    }

    @Test
    void testGetters() {
        // GIVEN an Info object with set values
        // WHEN getting the id, title, and description
        // THEN the returned values should match the set values
        assertEquals("testId", info.getId());
        assertEquals("testTitle", info.getTitle());
        assertEquals("testDescription", info.getDescription());
    }

    @Test
    void testSetters() {
        // GIVEN an Info object
        // WHEN setting new values for id, title, and description
        // THEN the returned values should match the new set values
        info.setId("newTestId");
        info.setTitle("newTestTitle");
        info.setDescription("newTestDescription");
        assertEquals("newTestId", info.getId());
        assertEquals("newTestTitle", info.getTitle());
        assertEquals("newTestDescription", info.getDescription());
    }
}
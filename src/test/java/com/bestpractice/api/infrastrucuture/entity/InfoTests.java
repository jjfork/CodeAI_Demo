package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoTests {
    private Info info;

    @BeforeEach
    void setUp() {
        info = new Info();
    }

    @Test
    void testGetId() {
        info.setId("testId");
        assertEquals("testId", info.getId());
    }

    @Test
    void testGetTitle() {
        info.setTitle("testTitle");
        assertEquals("testTitle", info.getTitle());
    }

    @Test
    void testGetDescription() {
        info.setDescription("testDescription");
        assertEquals("testDescription", info.getDescription());
    }
}

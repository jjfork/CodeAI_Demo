package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

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
    void testGettersAndSetters() {
        // GIVEN
        String id = "testId";
        String title = "testTitle";
        String description = "testDescription";

        // WHEN
        info.setId(id);
        info.setTitle(title);
        info.setDescription(description);

        // THEN
        assertEquals(id, info.getId());
        assertEquals(title, info.getTitle());
        assertEquals(description, info.getDescription());
    }
}

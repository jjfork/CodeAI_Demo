package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        // GIVEN - An InfoResponse object is created
        // WHEN - The getId method is called
        // THEN - The returned id should match the provided id
        assertEquals(id, infoResponse.getId());
    }

    @Test
    void testGetTitle() {
        // GIVEN - An InfoResponse object is created
        // WHEN - The getTitle method is called
        // THEN - The returned title should match the provided title
        assertEquals(title, infoResponse.getTitle());
    }

    @Test
    void testGetDescription() {
        // GIVEN - An InfoResponse object is created
        // WHEN - The getDescription method is called
        // THEN - The returned description should match the provided description
        assertEquals(description, infoResponse.getDescription());
    }
}

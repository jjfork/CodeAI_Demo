package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfoTests {

    private Info info;

    @BeforeEach
    void setUp() {
        // GIVEN: A new instance of Info
        info = new Info();
    }

    @Test
    void testGetAndSetId() {
        // GIVEN: An ID value
        String id = "12345";

        // WHEN: setId is called
        info.setId(id);

        // THEN: getId returns the correct value
        assertEquals(id, info.getId());
    }

    @Test
    void testGetAndSetTitle() {
        // GIVEN: A title value
        String title = "Sample Title";

        // WHEN: setTitle is called
        info.setTitle(title);

        // THEN: getTitle returns the correct value
        assertEquals(title, info.getTitle());
    }

    @Test
    void testGetAndSetDescription() {
        // GIVEN: A description value
        String description = "Sample Description";

        // WHEN: setDescription is called
        info.setDescription(description);

        // THEN: getDescription returns the correct value
        assertEquals(description, info.getDescription());
    }

    @Test
    void testDefaultValues() {
        // GIVEN: A newly instantiated Info object

        // THEN: Default values should be null
        assertNull(info.getId());
        assertNull(info.getTitle());
        assertNull(info.getDescription());
    }

    @Test
    void testSetTitleWithNull() {
        // GIVEN: A null title value
        String title = null;

        // WHEN: setTitle is called with null
        info.setTitle(title);

        // THEN: getTitle should return null
        assertNull(info.getTitle());
    }

    @Test
    void testSetDescriptionWithNull() {
        // GIVEN: A null description value
        String description = null;

        // WHEN: setDescription is called with null
        info.setDescription(description);

        // THEN: getDescription should return null
        assertNull(info.getDescription());
    }
}

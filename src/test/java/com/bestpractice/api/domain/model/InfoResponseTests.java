package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InfoResponseTests {

    private String id;
    private String title;
    private String description;
    private InfoResponse infoResponse;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize variables for creating an InfoResponse object.
        id = "12345";
        title = "Sample Title";
        description = "This is a sample description.";
        
        // WHEN: Create a new instance of InfoResponse with the initialized values.
        infoResponse = new InfoResponse(id, title, description);
    }

    @Test
    void getId_ShouldReturnCorrectId() {
        // GIVEN: An InfoResponse object has been created with a specific id.

        // WHEN: The getId method is called on the InfoResponse object.

        // THEN: The returned id should match the one provided during construction.
        assertEquals(id, infoResponse.getId());
    }

    @Test
    void getTitle_ShouldReturnCorrectTitle() {
        // GIVEN: An InfoResponse object has been created with a specific title.

        // WHEN: The getTitle method is called on the InfoResponse object.

        // THEN: The returned title should match the one provided during construction.
        assertEquals(title, infoResponse.getTitle());
    }

    @Test
    void getDescription_ShouldReturnCorrectDescription() {
        // GIVEN: An InfoResponse object has been created with a specific description.

        // WHEN: The getDescription method is called on the InfoResponse object.

        // THEN: The returned description should match the one provided during construction.
        assertEquals(description, infoResponse.getDescription());
    }
}

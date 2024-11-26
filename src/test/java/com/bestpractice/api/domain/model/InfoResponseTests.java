package com.bestpractice.api.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class InfoResponseTests {

    private static final String SAMPLE_ID = "12345";
    private static final String SAMPLE_TITLE = "Sample Title";
    private static final String SAMPLE_DESCRIPTION = "Sample Description";

    @Test
    void testConstructorAndGetters() {
        // GIVEN: Valid parameters for InfoResponse
        String id = SAMPLE_ID;
        String title = SAMPLE_TITLE;
        String description = SAMPLE_DESCRIPTION;

        // WHEN: Creating an InfoResponse object
        InfoResponse infoResponse = new InfoResponse(id, title, description);

        // THEN: The InfoResponse fields should match the input values
        assertNotNull(infoResponse, "InfoResponse object should not be null");
        assertEquals(SAMPLE_ID, infoResponse.getId(), "ID should match the initialized value");
        assertEquals(SAMPLE_TITLE, infoResponse.getTitle(), "Title should match the initialized value");
        assertEquals(SAMPLE_DESCRIPTION, infoResponse.getDescription(), "Description should match the initialized value");
    }
}
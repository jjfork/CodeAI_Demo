package com.bestpractice.api.domain.model;

import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InfoRequestTests {

    private static final String SAMPLE_TITLE = "Sample Title";
    private static final String SAMPLE_DESCRIPTION = "Sample Description";
    private static final String SAMPLE_ID = "12345";

    private InfoRequest infoRequest;

    @BeforeEach
    void setUp() {
        // GIVEN: Setting up a valid InfoRequest object
        infoRequest = new InfoRequest();
    }

    @Test
    void testSetAndGetTitle() {
        // GIVEN: A valid title
        String title = SAMPLE_TITLE;

        // WHEN: Setting the title
        infoRequest.setTitle(title);

        // THEN: The retrieved title should match the set value
        assertEquals(SAMPLE_TITLE, infoRequest.getTitle(), "Title should match the set value");
    }

    @Test
    void testSetAndGetDescription() {
        // GIVEN: A valid description
        String description = SAMPLE_DESCRIPTION;

        // WHEN: Setting the description
        infoRequest.setDescription(description);

        // THEN: The retrieved description should match the set value
        assertEquals(SAMPLE_DESCRIPTION, infoRequest.getDescription(), "Description should match the set value");
    }

    @Test
    void testConvert() {
        // GIVEN: A valid InfoRequest object with title and description set
        infoRequest.setTitle(SAMPLE_TITLE);
        infoRequest.setDescription(SAMPLE_DESCRIPTION);

        // WHEN: Converting to an Info object with a specified ID
        Info info = infoRequest.convert(SAMPLE_ID);

        // THEN: The converted Info object should contain the expected values
        assertNotNull(info, "Converted Info object should not be null");
        assertEquals(SAMPLE_ID, info.getId(), "Info ID should match the specified value");
        assertEquals(SAMPLE_TITLE, info.getTitle(), "Info title should match the InfoRequest title");
        assertEquals(SAMPLE_DESCRIPTION, info.getDescription(), "Info description should match the InfoRequest description");
    }
}
package com.bestpractice.api.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserResponseTests {

    private static final String SAMPLE_ID = "user123";
    private static final String SAMPLE_USERNAME = "sampleUser";
    private static final String SAMPLE_EMAIL = "sample@example.com";

    @Test
    void testConstructorAndGetters() {
        // GIVEN: A valid set of parameters for creating a UserResponse object
        String id = SAMPLE_ID;
        String username = SAMPLE_USERNAME;
        String email = SAMPLE_EMAIL;

        // WHEN: Creating a UserResponse object
        UserResponse userResponse = new UserResponse(id, username, email);

        // THEN: All fields should match the provided input
        assertNotNull(userResponse, "UserResponse object should not be null");
        assertEquals(SAMPLE_ID, userResponse.getId(), "ID should match the provided value");
        assertEquals(SAMPLE_USERNAME, userResponse.getUsername(), "Username should match the provided value");
        assertEquals(SAMPLE_EMAIL, userResponse.getEmail(), "Email should match the provided value");
    }

    @Test
    void testGetId() {
        // GIVEN: A UserResponse object with a valid ID
        UserResponse userResponse = new UserResponse(SAMPLE_ID, SAMPLE_USERNAME, SAMPLE_EMAIL);

        // WHEN: Retrieving the ID
        String id = userResponse.getId();

        // THEN: The ID should match the expected value
        assertEquals(SAMPLE_ID, id, "Retrieved ID should match the expected value");
    }

    @Test
    void testGetUsername() {
        // GIVEN: A UserResponse object with a valid username
        UserResponse userResponse = new UserResponse(SAMPLE_ID, SAMPLE_USERNAME, SAMPLE_EMAIL);

        // WHEN: Retrieving the username
        String username = userResponse.getUsername();

        // THEN: The username should match the expected value
        assertEquals(SAMPLE_USERNAME, username, "Retrieved username should match the expected value");
    }

    @Test
    void testGetEmail() {
        // GIVEN: A UserResponse object with a valid email
        UserResponse userResponse = new UserResponse(SAMPLE_ID, SAMPLE_USERNAME, SAMPLE_EMAIL);

        // WHEN: Retrieving the email
        String email = userResponse.getEmail();

        // THEN: The email should match the expected value
        assertEquals(SAMPLE_EMAIL, email, "Retrieved email should match the expected value");
    }
}
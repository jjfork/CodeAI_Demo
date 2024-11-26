package com.bestpractice.api.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.bestpractice.api.infrastrucuture.entity.User;

import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;

public class UserRequestTests {


    private static final String SAMPLE_USERNAME = "sampleUser";
    private static final String SAMPLE_EMAIL = "sample@example.com";
    private static final String SAMPLE_PASSWORD = "password123";
    private static final String SAMPLE_ID = "user123";
    private static final String SAMPLE_ENCODED_PASSWORD = "encodedPassword123";

    private UserRequest userRequest;

    @BeforeEach
    void setUp() {
        // GIVEN: Setting up a valid UserRequest object
        userRequest = new UserRequest();
    }

    @Test
    void testSetAndGetUsername() {
        // GIVEN: A valid username
        String username = SAMPLE_USERNAME;

        // WHEN: Setting the username
        userRequest.setUsername(username);

        // THEN: The retrieved username should match the set value
        assertEquals(SAMPLE_USERNAME, userRequest.getUsername(), "Username should match the set value");
    }

    @Test
    void testSetAndGetEmail() {
        // GIVEN: A valid email address
        String email = SAMPLE_EMAIL;

        // WHEN: Setting the email
        userRequest.setEmail(email);

        // THEN: The retrieved email should match the set value
        assertEquals(SAMPLE_EMAIL, userRequest.getEmail(), "Email should match the set value");
    }

    @Test
    void testSetAndGetPassword() {
        // GIVEN: A valid password
        String password = SAMPLE_PASSWORD;

        // WHEN: Setting the password
        userRequest.setPassword(password);

        // THEN: The retrieved password should match the set value
        assertEquals(SAMPLE_PASSWORD, userRequest.getPassword(), "Password should match the set value");
    }

    @Test
    void testConvert() {
        // GIVEN: A valid UserRequest object with all fields set
        userRequest.setUsername(SAMPLE_USERNAME);
        userRequest.setEmail(SAMPLE_EMAIL);
        userRequest.setPassword(SAMPLE_PASSWORD);

        // WHEN: Converting the UserRequest to a User object with specified ID and encoded password
        User user = userRequest.convert(SAMPLE_ID, SAMPLE_ENCODED_PASSWORD);

        // THEN: The converted User object should contain the expected values
        assertNotNull(user, "Converted User object should not be null");
        assertEquals(SAMPLE_ID, user.getId(), "User ID should match the specified value");
        assertEquals(SAMPLE_ENCODED_PASSWORD, user.getPassword(), "User password should match the encoded value");
        assertEquals(SAMPLE_EMAIL, user.getEmail(), "User email should match the UserRequest email");
        assertEquals(SAMPLE_USERNAME, user.getUsername(), "User username should match the UserRequest username");
    }
}
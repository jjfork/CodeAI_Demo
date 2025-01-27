package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserResponseTests {

    private String id;
    private String username;
    private String email;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize variables for creating a UserResponse object.
        id = "12345";
        username = "testUser";
        email = "test@example.com";

        // WHEN: Create a new instance of UserResponse with the initialized values.
        userResponse = new UserResponse(id, username, email);
    }

    @Test
    void testGetId() {
        // GIVEN: A UserResponse object has been created with an id.

        // WHEN: The getId method is called on the UserResponse object.

        // THEN: The returned value should match the id provided during construction.
        assertEquals(id, userResponse.getId());
    }

    @Test
    void testGetUsername() {
        // GIVEN: A UserResponse object has been created with a username.

        // WHEN: The getUsername method is called on the UserResponse object.

        // THEN: The returned value should match the username provided during construction.
        assertEquals(username, userResponse.getUsername());
    }

    @Test
    void testGetEmail() {
        // GIVEN: A UserResponse object has been created with an email.

        // WHEN: The getEmail method is called on the UserResponse object.

        // THEN: The returned value should match the email provided during construction.
        assertEquals(email, userResponse.getEmail());
    }
}

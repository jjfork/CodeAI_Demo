package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserResponseTests {

    private String id;
    private String username;
    private String email;
    private UserResponse userResponse;

    @BeforeEach
    void setUp() {
        id = "123";
        username = "testUser";
        email = "test@example.com";
        userResponse = new UserResponse(id, username, email);
    }

    @Test
    void testGetId() {
        // GIVEN - A UserResponse object is created
        // WHEN - The getId method is called on the UserResponse object
        String returnedId = userResponse.getId();
        // THEN - The returned ID should match the provided ID
        assertEquals(id, returnedId);
    }

    @Test
    void testGetUsername() {
        // GIVEN - A UserResponse object is created
        // WHEN - The getUsername method is called on the UserResponse object
        String returnedUsername = userResponse.getUsername();
        // THEN - The returned username should match the provided username
        assertEquals(username, returnedUsername);
    }

    @Test
    void testGetEmail() {
        // GIVEN - A UserResponse object is created
        // WHEN - The getEmail method is called on the UserResponse object
        String returnedEmail = userResponse.getEmail();
        // THEN - The returned email should match the provided email
        assertEquals(email, returnedEmail);
    }
}

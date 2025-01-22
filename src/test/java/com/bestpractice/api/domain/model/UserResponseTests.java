package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

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
        // WHEN - The getId method is called
        // THEN - The returned id should match the provided id
        assertEquals(id, userResponse.getId());
    }

    @Test
    void testGetUsername() {
        // GIVEN - A UserResponse object is created
        // WHEN - The getUsername method is called
        // THEN - The returned username should match the provided username
        assertEquals(username, userResponse.getUsername());
    }

    @Test
    void testGetEmail() {
        // GIVEN - A UserResponse object is created
        // WHEN - The getEmail method is called
        // THEN - The returned email should match the provided email
        assertEquals(email, userResponse.getEmail());
    }
}

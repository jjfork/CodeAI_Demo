package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTests {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("id1", "username1", "email1@example.com", "password123");
    }

    @Test
    void testGettersAndSetters() {
        // GIVEN - A User object is created
        // WHEN - Getters are called for each attribute
        String id = user.getId();
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        // THEN - The retrieved values match the set values
        assertEquals("id1", id);
        assertEquals("username1", username);
        assertEquals("email1@example.com", email);
        assertEquals("password123", password);

        // WHEN - Setters are called to modify attributes
        user.setId("newId");
        user.setUsername("newUsername");
        user.setEmail("newEmail@example.com");
        user.setPassword("newPassword");

        // THEN - The modified values are reflected in the object
        assertEquals("newId", user.getId());
        assertEquals("newUsername", user.getUsername());
        assertEquals("newEmail@example.com", user.getEmail());
        assertEquals("newPassword", user.getPassword());
    }
}

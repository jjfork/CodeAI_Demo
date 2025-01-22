package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("id1", "username1", "email1@example.com", "password123");
    }

    @Test
    void testGetters() {
        // GIVEN: A User object is created
        // WHEN: Getters are called for each attribute
        // THEN: The returned values match the set values
        assertEquals("id1", user.getId());
        assertEquals("username1", user.getUsername());
        assertEquals("email1@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    void testSetters() {
        // GIVEN: A User object is created
        // WHEN: Setters are called to update attributes
        // THEN: The updated values are reflected when getters are called
        user.setId("newId");
        user.setUsername("newUsername");
        user.setEmail("newEmail@example.com");
        user.setPassword("newPassword");

        assertEquals("newId", user.getId());
        assertEquals("newUsername", user.getUsername());
        assertEquals("newEmail@example.com", user.getEmail());
        assertEquals("newPassword", user.getPassword());
    }
}

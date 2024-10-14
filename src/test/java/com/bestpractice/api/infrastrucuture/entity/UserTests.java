package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("id", "username", "email", "password");
    }

    @Test
    void getId() {
        assertEquals("id", user.getId());
    }

    @Test
    void setId() {
        user.setId("newId");
        assertEquals("newId", user.getId());
    }

    @Test
    void getUsername() {
        assertEquals("username", user.getUsername());
    }

    @Test
    void setUsername() {
        user.setUsername("newUsername");
        assertEquals("newUsername", user.getUsername());
    }

    @Test
    void getEmail() {
        assertEquals("email", user.getEmail());
    }

    @Test
    void setEmail() {
        user.setEmail("newEmail");
        assertEquals("newEmail", user.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }
}

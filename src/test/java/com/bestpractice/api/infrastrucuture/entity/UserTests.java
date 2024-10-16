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
        user = new User();
    }

    @Test
    void testUserConstructor() {
        String id = "testId";
        String username = "testUsername";
        String email = "testEmail";
        String password = "testPassword";
        User user = new User(id, username, email, password);
        assertEquals(id, user.getId());
        assertEquals(username, user.getUsername());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
    }

    @Test
    void testGetters() {
        user.setId("testId");
        user.setUsername("testUsername");
        user.setEmail("testEmail");
        user.setPassword("testPassword");
        assertEquals("testId", user.getId());
        assertEquals("testUsername", user.getUsername());
        assertEquals("testEmail", user.getEmail());
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void testSetters() {
        user.setId("newTestId");
        user.setUsername("newTestUsername");
        user.setEmail("newTestEmail");
        user.setPassword("newTestPassword");
        assertEquals("newTestId", user.getId());
        assertEquals("newTestUsername", user.getUsername());
        assertEquals("newTestEmail", user.getEmail());
        assertEquals("newTestPassword", user.getPassword());
    }
}

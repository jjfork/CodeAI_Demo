package com.bestpractice.api.infrastrucuture.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

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
        // GIVEN
        String id = "testId";
        String username = "testUsername";
        String email = "testEmail";
        String password = "testPassword";

        // WHEN
        User newUser = new User(id, username, email, password);

        // THEN
        assertEquals(id, newUser.getId());
        assertEquals(username, newUser.getUsername());
        assertEquals(email, newUser.getEmail());
        assertEquals(password, newUser.getPassword());
    }

    @Test
    void testGetters() {
        // GIVEN
        user.setId("testId");
        user.setUsername("testUsername");
        user.setEmail("testEmail");
        user.setPassword("testPassword");

        // WHEN

        // THEN
        assertEquals("testId", user.getId());
        assertEquals("testUsername", user.getUsername());
        assertEquals("testEmail", user.getEmail());
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void testSetters() {
        // GIVEN
        String newId = "newTestId";
        String newUsername = "newUsername";
        String newEmail = "newEmail";
        String newPassword = "newPassword";

        // WHEN
        user.setId(newId);
        user.setUsername(newUsername);
        user.setEmail(newEmail);
        user.setPassword(newPassword);

        // THEN
        assertEquals(newId, user.getId());
        assertEquals(newUsername, user.getUsername());
        assertEquals(newEmail, user.getEmail());
        assertEquals(newPassword, user.getPassword());
    }
}

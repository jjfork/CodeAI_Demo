package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTests {

    private User user;

    @BeforeEach
    void setUp() {
        // GIVEN: A new instance of the User class
        user = new User();
    }

    @Test
    void testNoArgsConstructor() {
        // GIVEN: A User object created with the no-args constructor

        // WHEN: Checking its fields
        // THEN: All fields should be null
        assertNull(user.getId());
        assertNull(user.getUsername());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
    }

    @Test
    void testAllArgsConstructor() {
        // GIVEN: Valid values for all User fields
        String id = "1";
        String username = "testUser";
        String email = "test@example.com";
        String password = "securePassword";

        // WHEN: Creating a User object using the all-args constructor
        User userWithArgs = new User(id, username, email, password);

        // THEN: All fields should be correctly set
        assertEquals(id, userWithArgs.getId());
        assertEquals(username, userWithArgs.getUsername());
        assertEquals(email, userWithArgs.getEmail());
        assertEquals(password, userWithArgs.getPassword());
    }

    @Test
    void testSetAndGetId() {
        // GIVEN: A User object and a valid id
        String id = "123";

        // WHEN: Setting the id field
        user.setId(id);

        // THEN: getId should return the correct value
        assertEquals(id, user.getId());
    }

    @Test
    void testSetAndGetUsername() {
        // GIVEN: A User object and a valid username
        String username = "testUsername";

        // WHEN: Setting the username field
        user.setUsername(username);

        // THEN: getUsername should return the correct value
        assertEquals(username, user.getUsername());
    }

    @Test
    void testSetAndGetEmail() {
        // GIVEN: A User object and a valid email
        String email = "user@example.com";

        // WHEN: Setting the email field
        user.setEmail(email);

        // THEN: getEmail should return the correct value
        assertEquals(email, user.getEmail());
    }

    @Test
    void testSetAndGetPassword() {
        // GIVEN: A User object and a valid password
        String password = "password123";

        // WHEN: Setting the password field
        user.setPassword(password);

        // THEN: getPassword should return the correct value
        assertEquals(password, user.getPassword());
    }

    @Test
    void testInheritanceFromSharedData() {
        // GIVEN: A User object
        // WHEN: Setting createdAt using a method inherited from SharedData
        user.setCreatedAt(new java.util.Date());

        // THEN: The createdAt value should be retrievable
        assertNotNull(user.getCreatedAt());
    }
}

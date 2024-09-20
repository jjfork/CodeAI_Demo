package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTests {

    @Test
    void testUser() {
        User user = new User("id1", "username1", "email1@example.com", "password123");
        assertEquals("id1", user.getId());
        assertEquals("username1", user.getUsername());
        assertEquals("email1@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }
}

package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserResponseTests {

    @Test
    void testGetId() {
        UserResponse userResponse = new UserResponse("1", "john_doe", "john.doe@example.com");
        assertEquals("1", userResponse.getId());
    }

    @Test
    void testGetUsername() {
        UserResponse userResponse = new UserResponse("1", "john_doe", "john.doe@example.com");
        assertEquals("john_doe", userResponse.getUsername());
    }

    @Test
    void testGetEmail() {
        UserResponse userResponse = new UserResponse("1", "john_doe", "john.doe@example.com");
        assertEquals("john.doe@example.com", userResponse.getEmail());
    }
}

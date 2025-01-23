package com.bestpractice.api.domain.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRequestTests {

    private UserRequest userRequest;

    @BeforeEach
    void setUp() {
        userRequest = new UserRequest();
    }

    @Test
    void testConvert() {
        // GIVEN
        String id = "user123";
        String encodePw = "hashedPassword";
        userRequest.setUsername("testUser");
        userRequest.setEmail("test@example.com");
        // WHEN
        com.bestpractice.api.infrastrucuture.entity.User user = userRequest.convert(id, encodePw);
        // THEN
        assertEquals(id, user.getId());
        assertEquals("testUser", user.getUsername());
        assertEquals("test@example.com", user.getEmail());
        assertEquals(encodePw, user.getPassword());
    }
}

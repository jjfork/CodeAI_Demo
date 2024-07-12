package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTests {

    @ExtendWith(MockitoExtension.class)
    @Test
    void testConstructor() {
        User user = new User("id", "username", "email", "password");
        assertNotNull(user);
        assertEquals("id", user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("email", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    @ExtendWith(MockitoExtension.class)
    @Test
    void testGetterSetter() {
        User user = new User();
        user.setId("id");
        user.setUsername("username");
        user.setEmail("email");
        user.setPassword("password");

        assertEquals("id", user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("email", user.getEmail());
        assertEquals("password", user.getPassword());
    }
}

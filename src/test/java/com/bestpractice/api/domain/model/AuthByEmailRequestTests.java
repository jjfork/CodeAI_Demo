package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthByEmailRequestTests {

    private AuthByEmailRequest authByEmailRequest;

    @BeforeEach
    void setUp() {
        authByEmailRequest = new AuthByEmailRequest();
    }

    @Test
    void testGetEmail() {
        // GIVEN - An AuthByEmailRequest object
        // WHEN - The getEmail method is called
        String email = authByEmailRequest.getEmail();
        // THEN - The returned email is null
        assertEquals(null, email);
    }

    @Test
    void testSetEmail() {
        // GIVEN - An AuthByEmailRequest object
        // WHEN - The setEmail method is called with "test@example.com"
        authByEmailRequest.setEmail("test@example.com");
        // THEN - The returned email is "test@example.com"
        assertEquals("test@example.com", authByEmailRequest.getEmail());
    }

    @Test
    void testGetPassword() {
        // GIVEN - An AuthByEmailRequest object
        // WHEN - The getPassword method is called
        String password = authByEmailRequest.getPassword();
        // THEN - The returned password is null
        assertEquals(null, password);
    }

    @Test
    void testSetPassword() {
        // GIVEN - An AuthByEmailRequest object
        // WHEN - The setPassword method is called with "securePassword"
        authByEmailRequest.setPassword("securePassword");
        // THEN - The returned password is "securePassword"
        assertEquals("securePassword", authByEmailRequest.getPassword());
    }
}

package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthByEmailRequestTests {

    @Test
    void testGetEmail() {
        AuthByEmailRequest authByEmailRequest = new AuthByEmailRequest();
        authByEmailRequest.setEmail("test@example.com");
        assertEquals("test@example.com", authByEmailRequest.getEmail());
    }

    @Test
    void testSetEmail() {
        AuthByEmailRequest authByEmailRequest = new AuthByEmailRequest();
        authByEmailRequest.setEmail("test@example.com");
        assertEquals("test@example.com", authByEmailRequest.getEmail());
    }

    @Test
    void testGetPassword() {
        AuthByEmailRequest authByEmailRequest = new AuthByEmailRequest();
        authByEmailRequest.setPassword("password123");
        assertEquals("password123", authByEmailRequest.getPassword());
    }

    @Test
    void testSetPassword() {
        AuthByEmailRequest authByEmailRequest = new AuthByEmailRequest();
        authByEmailRequest.setPassword("password123");
        assertEquals("password123", authByEmailRequest.getPassword());
    }
}

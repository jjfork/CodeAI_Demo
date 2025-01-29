package com.bestpractice.api.infrastrucuture.cache.redis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RedisPropertyTests {
    private RedisProperty redisProperty;

    @BeforeEach
    void setUp() {
        redisProperty = new RedisProperty();
    }

    @Test
    void testGetHost() {
        // GIVEN - Initialize the host property
        String expectedHost = "localhost";
        redisProperty.setHost(expectedHost);
        // WHEN - Call the getHost method
        String actualHost = redisProperty.getHost();
        // THEN - Assert that the actual host matches the expected host
        assertEquals(expectedHost, actualHost);
    }

    @Test
    void testSetHost() {
        // GIVEN - Initialize a new host value
        String newHost = "127.0.0.1";
        // WHEN - Call the setHost method with the new value
        redisProperty.setHost(newHost);
        // THEN - Assert that the host property is updated to the new value
        assertEquals(newHost, redisProperty.getHost());
    }

    @Test
    void testGetPort() {
        // GIVEN - Initialize the port property
        int expectedPort = 6379;
        redisProperty.setPort(expectedPort);
        // WHEN - Call the getPort method
        int actualPort = redisProperty.getPort();
        // THEN - Assert that the actual port matches the expected port
        assertEquals(expectedPort, actualPort);
    }

    @Test
    void testSetPort() {
        // GIVEN - Initialize a new port value
        int newPort = 8080;
        // WHEN - Call the setPort method with the new value
        redisProperty.setPort(newPort);
        // THEN - Assert that the port property is updated to the new value
        assertEquals(newPort, redisProperty.getPort());
    }

    @Test
    void testGetPassword() {
        // GIVEN - Initialize the password property
        String expectedPassword = "mysecretpassword";
        redisProperty.setPassword(expectedPassword);
        // WHEN - Call the getPassword method
        String actualPassword = redisProperty.getPassword();
        // THEN - Assert that the actual password matches the expected password
        assertEquals(expectedPassword, actualPassword);
    }

    @Test
    void testSetPassword() {
        // GIVEN - Initialize a new password value
        String newPassword = "newsecretpassword";
        // WHEN - Call the setPassword method with the new value
        redisProperty.setPassword(newPassword);
        // THEN - Assert that the password property is updated to the new value
        assertEquals(newPassword, redisProperty.getPassword());
    }
}

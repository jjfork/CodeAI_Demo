package com.bestpractice.api.infrastrucuture.cache.redis;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        redisProperty.setHost("localhost");
        // WHEN - Get the host property
        String host = redisProperty.getHost();
        // THEN - Assert that the retrieved host matches the set value
        assertEquals("localhost", host);
    }

    @Test
    void testSetHost() {
        // GIVEN - Set a new host value
        redisProperty.setHost("127.0.0.1");
        // WHEN - Get the host property
        String host = redisProperty.getHost();
        // THEN - Assert that the retrieved host matches the set value
        assertEquals("127.0.0.1", host);
    }

    @Test
    void testGetPort() {
        // GIVEN - Initialize the port property
        redisProperty.setPort(6379);
        // WHEN - Get the port property
        int port = redisProperty.getPort();
        // THEN - Assert that the retrieved port matches the set value
        assertEquals(6379, port);
    }

    @Test
    void testSetPort() {
        // GIVEN - Set a new port value
        redisProperty.setPort(7000);
        // WHEN - Get the port property
        int port = redisProperty.getPort();
        // THEN - Assert that the retrieved port matches the set value
        assertEquals(7000, port);
    }

    @Test
    void testGetPassword() {
        // GIVEN - Initialize the password property
        redisProperty.setPassword("mysecretpassword");
        // WHEN - Get the password property
        String password = redisProperty.getPassword();
        // THEN - Assert that the retrieved password matches the set value
        assertEquals("mysecretpassword", password);
    }

    @Test
    void testSetPassword() {
        // GIVEN - Set a new password value
        redisProperty.setPassword("newsecretpassword");
        // WHEN - Get the password property
        String password = redisProperty.getPassword();
        // THEN - Assert that the retrieved password matches the set value
        assertEquals("newsecretpassword", password);
    }
}

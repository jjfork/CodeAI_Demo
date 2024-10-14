package com.bestpractice.api.infrastrucuture.cache.redis;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedisPropertyTests {
    private RedisProperty redisProperty;

    @BeforeEach
    void setUp() {
        redisProperty = new RedisProperty();
    }

    @Test
    void testGetHost() {
        String expectedHost = "localhost";
        redisProperty.setHost(expectedHost);
        assertEquals(expectedHost, redisProperty.getHost());
    }

    @Test
    void testSetHost() {
        String newHost = "127.0.0.1";
        redisProperty.setHost(newHost);
        assertEquals(newHost, redisProperty.getHost());
    }

    @Test
    void testGetPort() {
        int expectedPort = 6379;
        redisProperty.setPort(expectedPort);
        assertEquals(expectedPort, redisProperty.getPort());
    }

    @Test
    void testSetPort() {
        int newPort = 8080;
        redisProperty.setPort(newPort);
        assertEquals(newPort, redisProperty.getPort());
    }

    @Test
    void testGetPassword() {
        String expectedPassword = "mysecretpassword";
        redisProperty.setPassword(expectedPassword);
        assertEquals(expectedPassword, redisProperty.getPassword());
    }

    @Test
    void testSetPassword() {
        String newPassword = "newsecretpassword";
        redisProperty.setPassword(newPassword);
        assertEquals(newPassword, redisProperty.getPassword());
    }
}

package com.bestpractice.api.infrastrucuture.cache.redis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RedisPropertyTests {

    @Test
    void testGetHost() {
        RedisProperty redisProperty = new RedisProperty();
        redisProperty.setHost("localhost");
        assertEquals("localhost", redisProperty.getHost());
    }

    @Test
    void testSetHost() {
        RedisProperty redisProperty = new RedisProperty();
        redisProperty.setHost("127.0.0.1");
        assertEquals("127.0.0.1", redisProperty.getHost());
    }

    @Test
    void testGetPort() {
        RedisProperty redisProperty = new RedisProperty();
        redisProperty.setPort(6379);
        assertEquals(6379, redisProperty.getPort());
    }

    @Test
    void testSetPort() {
        RedisProperty redisProperty = new RedisProperty();
        redisProperty.setPort(7000);
        assertEquals(7000, redisProperty.getPort());
    }

    @Test
    void testGetPassword() {
        RedisProperty redisProperty = new RedisProperty();
        redisProperty.setPassword("mypassword");
        assertEquals("mypassword", redisProperty.getPassword());
    }

    @Test
    void testSetPassword() {
        RedisProperty redisProperty = new RedisProperty();
        redisProperty.setPassword("secret");
        assertEquals("secret", redisProperty.getPassword());
    }
} 

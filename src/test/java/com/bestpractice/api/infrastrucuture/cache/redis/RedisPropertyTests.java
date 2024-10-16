package com.bestpractice.api.infrastrucuture.cache.redis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Profile("cache_redis")
public class RedisPropertyTests {

    private RedisProperty redisProperty;

    @BeforeEach
    void setUp() {
        redisProperty = new RedisProperty();
    }

    @Test
    void testGetHost() {
        // GIVEN - RedisProperty object is initialized
        // WHEN - getHost() method is called
        String host = redisProperty.getHost();
        // THEN - host should be null as it's not set
        assertEquals(null, host);
    }

    @Test
    void testSetHost() {
        // GIVEN - RedisProperty object is initialized
        // WHEN - setHost("localhost") is called
        redisProperty.setHost("localhost");
        // THEN - host should be "localhost"
        assertEquals("localhost", redisProperty.getHost());
    }

    @Test
    void testGetPort() {
        // GIVEN - RedisProperty object is initialized
        // WHEN - getPort() method is called
        int port = redisProperty.getPort();
        // THEN - port should be 0 as it's not set
        assertEquals(0, port);
    }

    @Test
    void testSetPort() {
        // GIVEN - RedisProperty object is initialized
        // WHEN - setPort(6379) is called
        redisProperty.setPort(6379);
        // THEN - port should be 6379
        assertEquals(6379, redisProperty.getPort());
    }

    @Test
    void testGetPassword() {
        // GIVEN - RedisProperty object is initialized
        // WHEN - getPassword() method is called
        String password = redisProperty.getPassword();
        // THEN - password should be null as it's not set
        assertEquals(null, password);
    }

    @Test
    void testSetPassword() {
        // GIVEN - RedisProperty object is initialized
        // WHEN - setPassword("mypassword") is called
        redisProperty.setPassword("mypassword");
        // THEN - password should be "mypassword"
        assertEquals("mypassword", redisProperty.getPassword());
    }
}

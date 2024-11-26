package com.bestpractice.api.infrastrucuture.cache.redis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedisPropertyTests {

    private RedisProperty redisProperty;

    @BeforeEach
    void setUp() {
        // GIVEN: A new instance of RedisProperty
        redisProperty = new RedisProperty();
    }

    @Test
    void testGetAndSetHost() {
        // GIVEN: A host value
        String host = "127.0.0.1";

        // WHEN: setHost is called
        redisProperty.setHost(host);

        // THEN: getHost returns the correct value
        assertEquals(host, redisProperty.getHost());
    }

    @Test
    void testGetAndSetPort() {
        // GIVEN: A port value
        int port = 6379;

        // WHEN: setPort is called
        redisProperty.setPort(port);

        // THEN: getPort returns the correct value
        assertEquals(port, redisProperty.getPort());
    }

    @Test
    void testGetAndSetPassword() {
        // GIVEN: A password value
        String password = "secure_password";

        // WHEN: setPassword is called
        redisProperty.setPassword(password);

        // THEN: getPassword returns the correct value
        assertEquals(password, redisProperty.getPassword());
    }

    @Test
    void testDefaultValues() {
        // GIVEN: A newly instantiated RedisProperty

        // THEN: Default values should be null or 0
        assertNull(redisProperty.getHost());
        assertEquals(0, redisProperty.getPort());
        assertNull(redisProperty.getPassword());
    }
}

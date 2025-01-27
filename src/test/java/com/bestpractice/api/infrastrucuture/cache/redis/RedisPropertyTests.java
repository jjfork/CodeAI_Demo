package com.bestpractice.api.infrastrucuture.cache.redis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RedisPropertyTests {

    private RedisProperty redisProperty;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize a new instance of RedisProperty before each test
        redisProperty = new RedisProperty();
    }

    @Test
    void whenGetHost_thenReturnCorrectValue() {
        // GIVEN: Set the host property to a known value
        String expectedHost = "localhost";
        redisProperty.setHost(expectedHost);

        // WHEN: Retrieve the host using getHost method
        String actualHost = redisProperty.getHost();

        // THEN: Verify that the retrieved host matches the set value
        assertEquals(expectedHost, actualHost);
    }

    @Test
    void whenGetPort_thenReturnCorrectValue() {
        // GIVEN: Set the port property to a known value
        int expectedPort = 6379;
        redisProperty.setPort(expectedPort);

        // WHEN: Retrieve the port using getPort method
        int actualPort = redisProperty.getPort();

        // THEN: Verify that the retrieved port matches the set value
        assertEquals(expectedPort, actualPort);
    }

    @Test
    void whenGetPassword_thenReturnCorrectValue() {
        // GIVEN: Set the password property to a known value
        String expectedPassword = "secret";
        redisProperty.setPassword(expectedPassword);

        // WHEN: Retrieve the password using getPassword method
        String actualPassword = redisProperty.getPassword();

        // THEN: Verify that the retrieved password matches the set value
        assertEquals(expectedPassword, actualPassword);
    }

    @Test
    void whenSetAndGetHost_thenConsistent() {
        // GIVEN: A new host value to be set
        String testHost = "redis.example.com";

        // WHEN: Set and then get the host property
        redisProperty.setHost(testHost);
        String retrievedHost = redisProperty.getHost();

        // THEN: Ensure that the retrieved host is consistent with what was set
        assertEquals(testHost, retrievedHost);
    }

    @Test
    void whenSetAndGetPort_thenConsistent() {
        // GIVEN: A new port value to be set
        int testPort = 6380;

        // WHEN: Set and then get the port property
        redisProperty.setPort(testPort);
        int retrievedPort = redisProperty.getPort();

        // THEN: Ensure that the retrieved port is consistent with what was set
        assertEquals(testPort, retrievedPort);
    }

    @Test
    void whenSetAndGetPassword_thenConsistent() {
        // GIVEN: A new password value to be set
        String testPassword = "newSecret";

        // WHEN: Set and then get the password property
        redisProperty.setPassword(testPassword);
        String retrievedPassword = redisProperty.getPassword();

        // THEN: Ensure that the retrieved password is consistent with what was set
        assertEquals(testPassword, retrievedPassword);
    }
}

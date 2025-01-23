package com.bestpractice.api.infrastrucuture.persistent.cassandra.property;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static org.junit.jupiter.api.Assertions.*;

@ConfigurationProperties(prefix = "cassandra")
public class CassandraPropertyTests {

    private CassandraProperty cassandraProperty;

    @BeforeEach
    void setUp() {
        cassandraProperty = new CassandraProperty();
    }

    @Test
    void testGetHosts() {
        // GIVEN
        String[] expectedHosts = {"localhost", "127.0.0.1"};
        // WHEN
        cassandraProperty.setHosts(expectedHosts);
        // THEN
        assertArrayEquals(expectedHosts, cassandraProperty.getHosts());
    }

    @Test
    void testGetKeyspace() {
        // GIVEN
        String expectedKeyspace = "my_keyspace";
        // WHEN
        cassandraProperty.setKeyspace(expectedKeyspace);
        // THEN
        assertEquals(expectedKeyspace, cassandraProperty.getKeyspace());
    }

    @Test
    void testGetUser() {
        // GIVEN
        String expectedUser = "cassandra_user";
        // WHEN
        cassandraProperty.setUser(expectedUser);
        // THEN
        assertEquals(expectedUser, cassandraProperty.getUser());
    }

    @Test
    void testGetPassword() {
        // GIVEN
        String expectedPassword = "secure_password";
        // WHEN
        cassandraProperty.setPassword(expectedPassword);
        // THEN
        assertEquals(expectedPassword, cassandraProperty.getPassword());
    }
}

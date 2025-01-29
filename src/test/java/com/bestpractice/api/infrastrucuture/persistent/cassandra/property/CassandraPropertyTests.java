package com.bestpractice.api.infrastrucuture.persistent.cassandra.property;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CassandraPropertyTests {
    private CassandraProperty cassandraProperty;

    @BeforeEach
    void setUp() {
        cassandraProperty = new CassandraProperty();
    }

    @Test
    void testGetHosts() {
        // GIVEN - Set up the hosts array
        String[] expectedHosts = {"localhost", "127.0.0.1"};
        cassandraProperty.setHosts(expectedHosts);
        // WHEN - Get the hosts array
        String[] actualHosts = cassandraProperty.getHosts();
        // THEN - Assert that the actual hosts array matches the expected array
        assertArrayEquals(expectedHosts, actualHosts);
    }

    @Test
    void testGetKeyspace() {
        // GIVEN - Set the keyspace value
        String expectedKeyspace = "my_keyspace";
        cassandraProperty.setKeyspace(expectedKeyspace);
        // WHEN - Get the keyspace value
        String actualKeyspace = cassandraProperty.getKeyspace();
        // THEN - Assert that the actual keyspace matches the expected value
        assertEquals(expectedKeyspace, actualKeyspace);
    }

    @Test
    void testGetUser() {
        // GIVEN - Set the user value
        String expectedUser = "cassandra_user";
        cassandraProperty.setUser(expectedUser);
        // WHEN - Get the user value
        String actualUser = cassandraProperty.getUser();
        // THEN - Assert that the actual user matches the expected value
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void testGetPassword() {
        // GIVEN - Set the password value
        String expectedPassword = "secure_password";
        cassandraProperty.setPassword(expectedPassword);
        // WHEN - Get the password value
        String actualPassword = cassandraProperty.getPassword();
        // THEN - Assert that the actual password matches the expected value
        assertEquals(expectedPassword, actualPassword);
    }
}

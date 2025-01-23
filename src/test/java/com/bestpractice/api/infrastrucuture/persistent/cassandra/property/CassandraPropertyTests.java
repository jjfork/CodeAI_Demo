package com.bestpractice.api.infrastrucuture.persistent.cassandra.property;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        String[] hosts = {"localhost", "127.0.0.1"};
        cassandraProperty.setHosts(hosts);
        // WHEN - Get the hosts array
        String[] actualHosts = cassandraProperty.getHosts();
        // THEN - Assert that the hosts array is equal to the expected array
        assertArrayEquals(hosts, actualHosts);
    }

    @Test
    void testGetKeyspace() {
        // GIVEN - Set the keyspace
        String keyspace = "my_keyspace";
        cassandraProperty.setKeyspace(keyspace);
        // WHEN - Get the keyspace
        String actualKeyspace = cassandraProperty.getKeyspace();
        // THEN - Assert that the keyspace is equal to the expected keyspace
        assertEquals(keyspace, actualKeyspace);
    }

    @Test
    void testGetUser() {
        // GIVEN - Set the user
        String user = "cassandra_user";
        cassandraProperty.setUser(user);
        // WHEN - Get the user
        String actualUser = cassandraProperty.getUser();
        // THEN - Assert that the user is equal to the expected user
        assertEquals(user, actualUser);
    }

    @Test
    void testGetPassword() {
        // GIVEN - Set the password
        String password = "secure_password";
        cassandraProperty.setPassword(password);
        // WHEN - Get the password
        String actualPassword = cassandraProperty.getPassword();
        // THEN - Assert that the password is equal to the expected password
        assertEquals(password, actualPassword);
    }
}

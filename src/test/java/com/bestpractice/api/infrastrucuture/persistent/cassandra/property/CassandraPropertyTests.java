package com.bestpractice.api.infrastrucuture.persistent.cassandra.property;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CassandraPropertyTests {
    private CassandraProperty cassandraProperty;

    @BeforeEach
    void setUp() {
        cassandraProperty = new CassandraProperty();
    }

    @Test
    void testGetHosts() {
        String[] hosts = {"localhost", "127.0.0.1"};
        cassandraProperty.setHosts(hosts);
        assertEquals(hosts, cassandraProperty.getHosts());
    }

    @Test
    void testGetKeyspace() {
        String keyspace = "my_keyspace";
        cassandraProperty.setKeyspace(keyspace);
        assertEquals(keyspace, cassandraProperty.getKeyspace());
    }

    @Test
    void testGetUser() {
        String user = "cassandra_user";
        cassandraProperty.setUser(user);
        assertEquals(user, cassandraProperty.getUser());
    }

    @Test
    void testGetPassword() {
        String password = "secure_password";
        cassandraProperty.setPassword(password);
        assertEquals(password, cassandraProperty.getPassword());
    }
}

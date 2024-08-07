package com.bestpractice.api.infrastrucuture.persistent.cassandra.property;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CassandraPropertyTests {

    @Test
    void testGetHosts() {
        CassandraProperty cassandraProperty = new CassandraProperty();
        String[] hosts = {"host1", "host2"};
        cassandraProperty.setHosts(hosts);
        assertArrayEquals(hosts, cassandraProperty.getHosts());
    }

    @Test
    void testGetKeyspace() {
        CassandraProperty cassandraProperty = new CassandraProperty();
        String keyspace = "myKeyspace";
        cassandraProperty.setKeyspace(keyspace);
        assertEquals(keyspace, cassandraProperty.getKeyspace());
    }

    @Test
    void testGetUser() {
        CassandraProperty cassandraProperty = new CassandraProperty();
        String user = "myUser";
        cassandraProperty.setUser(user);
        assertEquals(user, cassandraProperty.getUser());
    }

    @Test
    void testGetPassword() {
        CassandraProperty cassandraProperty = new CassandraProperty();
        String password = "myPassword";
        cassandraProperty.setPassword(password);
        assertEquals(password, cassandraProperty.getPassword());
    }
}

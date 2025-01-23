package com.bestpractice.api.infrastrucuture.persistent.cassandra;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

class User {
    public User() {
    }
}

@ExtendWith(MockitoExtension.class)
class CassandraUserPersistentRepositoryTests {

    @InjectMocks
    private CassandraUserPersistentRepository cassandraUserPersistentRepository;

    @Test
    void testNewUser() {
        // Arrange
        User user = new User();
        // Act
        // Assert
    }
}
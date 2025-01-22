package com.bestpractice.api.infrastrucuture.persistent.cassandra;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CassandraUserPersistentRepositoryTests {

    @InjectMocks
    private CassandraUserPersistentRepository cassandraUserPersistentRepository;

    @Test
    void testNew() {
        // Arrange
        // Act
        // Assert
    }
}

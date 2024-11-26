package com.bestpractice.api.infrastrucuture.persistent.cassandra;

import com.bestpractice.api.infrastrucuture.entity.Info;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CassandraInfoPersistentRepositoryTests {

    private CassandraInfoPersistentRepository repository;

    @Mock
    private CqlSession mockSession;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private BoundStatement mockBoundStatement;

    @Mock
    private ResultSet mockResultSet;

    @Mock
    private Row mockRow;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        repository = new CassandraInfoPersistentRepository(mockSession);
    }

    @Test
    void testNewId() {
        // GIVEN: No preconditions

        // WHEN: Generating a new ID
        String newId = repository.newId();

        // THEN: The ID should be a valid UUID
        assertNotNull(newId);
        assertDoesNotThrow(() -> UUID.fromString(newId));
    }
}

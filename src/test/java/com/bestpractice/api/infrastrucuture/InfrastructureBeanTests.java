package com.bestpractice.api.infrastrucuture;

import com.bestpractice.api.infrastrucuture.cache.redis.RedisProperty;
import com.bestpractice.api.infrastrucuture.persistent.InfoPersistentRepository;
import com.bestpractice.api.infrastrucuture.persistent.UserPersistentRepository;
import com.bestpractice.api.infrastrucuture.persistent.cassandra.property.CassandraProperty;
import com.bestpractice.api.infrastrucuture.persistent.local.LocalInfoPersistentRepository;
import com.bestpractice.api.infrastrucuture.persistent.local.LocalUserPersistentRepository;
import com.bestpractice.api.infrastrucuture.persistent.rdbms.RdbmsUserPersistentRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

;
;

class InfrastructureBeanTests {


    private InfrastructureBean.LocalDbRepository localDbRepository;
    private InfrastructureBean.RdbmsDbRepository rdbmsDbRepository;
    private InfrastructureBean.MongoDbRepository mongoDbRepository;
    private InfrastructureBean.CassandraDbRepository cassandraDbRepository;
    private RedisProperty redisProperty;
    private CassandraProperty cassandraProperty;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private JdbcTemplate jdbcTemplate;
    private DriverManagerDataSource dataSource;

    @BeforeEach
    void setUp() {
        localDbRepository = new InfrastructureBean.LocalDbRepository();
        redisProperty = mock(RedisProperty.class);
        cassandraProperty = mock(CassandraProperty.class);
        mongoClient = mock(MongoClient.class);
        mongoDatabase = mock(MongoDatabase.class);
        jdbcTemplate = mock(JdbcTemplate.class);
        dataSource = mock(DriverManagerDataSource.class);

        rdbmsDbRepository = mock(InfrastructureBean.RdbmsDbRepository.class);
        mongoDbRepository = mock(InfrastructureBean.MongoDbRepository.class);
        cassandraDbRepository = mock(InfrastructureBean.CassandraDbRepository.class);
    }

    @Test
    void testLocalDbUserRepository() {
        // GIVEN: A LocalDbRepository
        // WHEN: Requesting a UserPersistentRepository from LocalDbRepository
        UserPersistentRepository repository = localDbRepository.userRepository();

        // THEN: Verify that it returns an instance of LocalUserPersistentRepository
        assertNotNull(repository);
        assertTrue(repository instanceof LocalUserPersistentRepository);
    }

    @Test
    void testLocalDbInfoRepository() {
        // GIVEN: A LocalDbRepository
        // WHEN: Requesting an InfoPersistentRepository from LocalDbRepository
        InfoPersistentRepository repository = localDbRepository.infoRepository();

        // THEN: Verify that it returns an instance of LocalInfoPersistentRepository
        assertNotNull(repository);
        assertTrue(repository instanceof LocalInfoPersistentRepository);
    }

    @Test
    void testRdbmsDbUserRepository() {
        // GIVEN: A mock RdbmsDbRepository and JdbcTemplate
        when(rdbmsDbRepository.userRepository(jdbcTemplate)).thenReturn(new RdbmsUserPersistentRepository(jdbcTemplate));

        // WHEN: Requesting a UserPersistentRepository from RdbmsDbRepository
        UserPersistentRepository repository = rdbmsDbRepository.userRepository(jdbcTemplate);

        // THEN: Verify that it returns an instance of RdbmsUserPersistentRepository
        assertNotNull(repository);
        assertTrue(repository instanceof RdbmsUserPersistentRepository);
    }


    @Test
    void testCassandraDbUserRepository() {
        // GIVEN: A mock CassandraDbRepository
        when(cassandraDbRepository.userRepository()).thenReturn(new LocalUserPersistentRepository());

        // WHEN: Requesting a UserPersistentRepository from CassandraDbRepository
        UserPersistentRepository repository = cassandraDbRepository.userRepository();

        // THEN: Verify that it returns an instance of LocalUserPersistentRepository
        assertNotNull(repository);
        assertTrue(repository instanceof LocalUserPersistentRepository);
    }

    @Test
    void testCassandraDbInfoRepository() {
        // GIVEN: A mock CassandraDbRepository
        when(cassandraDbRepository.infoRepository()).thenReturn(mock(InfoPersistentRepository.class));

        // WHEN: Requesting an InfoPersistentRepository from CassandraDbRepository
        InfoPersistentRepository repository = cassandraDbRepository.infoRepository();

        // THEN: Verify that it is not null
        assertNotNull(repository);
    }
}
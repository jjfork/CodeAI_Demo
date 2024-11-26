package com.bestpractice.api.infrastrucuture.persistent.cassandra;

import com.bestpractice.api.infrastrucuture.entity.User;
import com.bestpractice.api.infrastrucuture.persistent.UserPersistentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CassandraUserPersistentRepositoryTests {

    private CassandraUserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CassandraUserPersistentRepository();
    }

    @Test
    void testNewId() {
        // GIVEN: A CassandraUserPersistentRepository instance

        // WHEN: Calling newId()
        String result = repository.newId();

        // THEN: The returned ID should be null (current implementation)
        assertNull(result);
    }

    @Test
    void testFindByEmail() {
        // GIVEN: A CassandraUserPersistentRepository instance and an email
        String email = "test@example.com";

        // WHEN: Calling findByEmail()
        User result = repository.findByEmail(email);

        // THEN: The returned User should be null (current implementation)
        assertNull(result);
    }

    @Test
    void testFindById() {
        // GIVEN: A CassandraUserPersistentRepository instance and an ID
        String id = "123";

        // WHEN: Calling findById()
        User result = repository.findById(id);

        // THEN: The returned User should be null (current implementation)
        assertNull(result);
    }

    @Test
    void testInsert() {
        // GIVEN: A CassandraUserPersistentRepository instance and a User
        User user = new User("1", "testUser", "test@example.com", "password123");

        // WHEN: Calling insert()
        User result = repository.insert(user);

        // THEN: The returned User should be null (current implementation)
        assertNull(result);
    }

    @Test
    void testReplace() {
        // GIVEN: A CassandraUserPersistentRepository instance, an ID, and a User
        String id = "123";
        User user = new User("1", "updatedUser", "updated@example.com", "newPassword123");

        // WHEN: Calling replace()
        User result = repository.replace(id, user);

        // THEN: The returned User should be null (current implementation)
        assertNull(result);
    }

    @Test
    void testRemoveById() {
        // GIVEN: A CassandraUserPersistentRepository instance and an ID
        String id = "123";

        // WHEN: Calling removeById()
        boolean result = repository.removeById(id);

        // THEN: The returned value should be false (current implementation)
        assertFalse(result);
    }
}

package com.bestpractice.api.infrastrucuture.persistent.local;

import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocalUserPersistentRepositoryTests {

    private LocalUserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LocalUserPersistentRepository();
    }

    @Test
    void testNewId() {
        // GIVEN: A LocalUserPersistentRepository instance

        // WHEN: Generating a new ID
        String newId = repository.newId();

        // THEN: The new ID should not be null or empty
        assertNotNull(newId);
        assertFalse(newId.isEmpty());
    }

    @Test
    void testFindByEmail_ExistingEmail() {
        // GIVEN: A repository with one user
        User user = new User();
        user.setId("1");
        user.setEmail("test@example.com");
        user.setUsername("Test User");
        repository.insert(user);

        // WHEN: Searching for the user by email
        User result = repository.findByEmail("test@example.com");

        // THEN: The correct user should be returned
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("test@example.com", result.getEmail());
        assertEquals("Test User", result.getUsername());
    }

    @Test
    void testFindByEmail_NonExistingEmail() {
        // GIVEN: An empty repository

        // WHEN: Searching for a non-existing email
        User result = repository.findByEmail("nonexistent@example.com");

        // THEN: The result should be null
        assertNull(result);
    }

    @Test
    void testFindById_ExistingId() {
        // GIVEN: A repository with one user
        User user = new User();
        user.setId("1");
        user.setEmail("test@example.com");
        user.setUsername("Test User");
        repository.insert(user);

        // WHEN: Searching for the user by ID
        User result = repository.findById("1");

        // THEN: The correct user should be returned
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("test@example.com", result.getEmail());
        assertEquals("Test User", result.getUsername());
    }

    @Test
    void testFindById_NonExistingId() {
        // GIVEN: An empty repository

        // WHEN: Searching for a non-existing ID
        User result = repository.findById("1");

        // THEN: The result should be null
        assertNull(result);
    }

    @Test
    void testInsert() {
        // GIVEN: An empty repository
        User user = new User();
        user.setId("1");
        user.setEmail("test@example.com");
        user.setUsername("Test User");

        // WHEN: Inserting a user
        User inserted = repository.insert(user);

        // THEN: The inserted user should match the input
        assertNotNull(inserted);
        assertEquals("1", inserted.getId());
        assertEquals("test@example.com", inserted.getEmail());
        assertEquals("Test User", inserted.getUsername());
    }

    @Test
    void testReplace_ExistingId() {
        // GIVEN: A repository with one user
        User oldUser = new User();
        oldUser.setId("1");
        oldUser.setEmail("old@example.com");
        oldUser.setUsername("Old User");
        repository.insert(oldUser);

        User newUser = new User();
        newUser.setId("1");
        newUser.setEmail("new@example.com");
        newUser.setUsername("New User");

        // WHEN: Replacing the user with the same ID
        repository.replace("1", newUser);

        // THEN: The user should be updated
        User replaced = repository.findById("1");
        assertNotNull(replaced);
        assertEquals("new@example.com", replaced.getEmail());
        assertEquals("New User", replaced.getUsername());
    }

    @Test
    void testReplace_NonExistingId() {
        // GIVEN: An empty repository
        User newUser = new User();
        newUser.setId("1");
        newUser.setEmail("new@example.com");
        newUser.setUsername("New User");

        // WHEN: Attempting to replace a user with a non-existing ID
        Exception exception = assertThrows(RuntimeException.class, () -> repository.replace("1", newUser));

        // THEN: An exception should be thrown
        assertEquals("Data does not exist.", exception.getMessage());
    }

    @Test
    void testRemoveById_ExistingId() {
        // GIVEN: A repository with one user
        User user = new User();
        user.setId("1");
        user.setEmail("test@example.com");
        user.setUsername("Test User");
        repository.insert(user);

        // WHEN: Removing the user by ID
        boolean result = repository.removeById("1");

        // THEN: The user should be removed
        assertTrue(result);
        assertNull(repository.findById("1"));
    }

    @Test
    void testRemoveById_NonExistingId() {
        // GIVEN: An empty repository

        // WHEN: Attempting to remove a user with a non-existing ID
        boolean result = repository.removeById("1");

        // THEN: The result should be true (method does not throw an exception)
        assertTrue(result);
    }
}

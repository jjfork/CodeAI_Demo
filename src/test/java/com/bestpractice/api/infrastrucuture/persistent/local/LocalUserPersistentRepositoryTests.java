package com.bestpractice.api.infrastrucuture.persistent.local;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LocalUserPersistentRepositoryTests {

    private LocalUserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LocalUserPersistentRepository();
    }

    @Test
    void testNewId() {
        String newId = repository.newId();
        assertNotNull(newId);
        assertTrue(newId.length() > 0);
    }

    @Test
    void testFindByEmail_ExistingUser() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(user);
        User foundUser = repository.findByEmail("test@example.com");
        assertNotNull(foundUser);
        assertEquals(user.getEmail(), foundUser.getEmail());
    }

    @Test
    void testFindByEmail_NonExistingUser() {
        User foundUser = repository.findByEmail("nonexistent@example.com");
        assertNull(foundUser);
    }

    @Test
    void testFindById_ExistingUser() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(user);
        User foundUser = repository.findById(user.getId());
        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    void testFindById_NonExistingUser() {
        User foundUser = repository.findById("nonexistentId");
        assertNull(foundUser);
    }

    @Test
    void testInsert() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        User insertedUser = repository.insert(user);
        assertNotNull(insertedUser);
        assertEquals(user.getEmail(), insertedUser.getEmail());
    }

    @Test
    void testReplace() {
        User existingUser = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(existingUser);
        User updatedUser = new User(existingUser.getId(), "updatedUser", "updated@example.com", "newpassword");
        repository.replace(existingUser.getId(), updatedUser);
        User foundUser = repository.findById(existingUser.getId());
        assertEquals(updatedUser.getEmail(), foundUser.getEmail());
    }

    @Test
    void testRemoveById() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(user);
        boolean removed = repository.removeById(user.getId());
        assertTrue(removed);
        User foundUser = repository.findById(user.getId());
        assertNull(foundUser);
    }
}

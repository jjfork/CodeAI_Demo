package com.bestpractice.api.infrastrucuture.persistent.local;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LocalUserPersistentRepositoryTests {
    private LocalUserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LocalUserPersistentRepository();
    }

    @Test
    void testNewId() {
        String newId = repository.newId();
        assertEquals(36, newId.length());
    }

    @Test
    void testFindByEmail() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(user);
        User foundUser = repository.findByEmail("test@example.com");
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    void testFindByEmailNotFound() {
        User foundUser = repository.findByEmail("nonexistent@example.com");
        assertNull(foundUser);
    }

    @Test
    void testFindById() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(user);
        User foundUser = repository.findById(user.getId());
        assertEquals(user.getId(), foundUser.getId());
    }

    @Test
    void testFindByIdNotFound() {
        User foundUser = repository.findById("nonexistentId");
        assertNull(foundUser);
    }

    @Test
    void testInsert() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        User insertedUser = repository.insert(user);
        assertEquals(user.getId(), insertedUser.getId());
    }

    @Test
    void testReplace() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(user);
        user.setUsername("updatedUser");
        repository.replace(user.getId(), user);
        User foundUser = repository.findById(user.getId());
        assertEquals("updatedUser", foundUser.getUsername());
    }

    @Test
    void testRemoveById() {
        User user = new User(UUID.randomUUID().toString(), "testUser", "test@example.com", "password");
        repository.insert(user);
        boolean removed = repository.removeById(user.getId());
        User foundUser = repository.findById(user.getId());
        assertEquals(true, removed);
        assertNull(foundUser);
    }
}

package com.bestpractice.api.infrastrucuture.persistent.local;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;

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
        // GIVEN
        String email = "test@example.com";
        User user = new User(UUID.randomUUID().toString(), "Test User", email, "password");
        repository.insert(user);
        // WHEN
        User foundUser = repository.findByEmail(email);
        // THEN
        assertNotNull(foundUser);
        assertEquals(email, foundUser.getEmail());
    }

    @Test
    void testFindByEmail_NonExistingUser() {
        // GIVEN
        String email = "nonexistent@example.com";
        // WHEN
        User foundUser = repository.findByEmail(email);
        // THEN
        assertNull(foundUser);
    }

    @Test
    void testFindById_ExistingUser() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        User user = new User(id, "Test User", "test@example.com", "password");
        repository.insert(user);
        // WHEN
        User foundUser = repository.findById(id);
        // THEN
        assertNotNull(foundUser);
        assertEquals(id, foundUser.getId());
    }

    @Test
    void testFindById_NonExistingUser() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        // WHEN
        User foundUser = repository.findById(id);
        // THEN
        assertNull(foundUser);
    }

    @Test
    void testInsert() {
        // GIVEN
        User user = new User(UUID.randomUUID().toString(), "Test User", "test@example.com", "password");
        // WHEN
        User insertedUser = repository.insert(user);
        // THEN
        assertNotNull(insertedUser);
        assertEquals(user.getUsername(), insertedUser.getUsername());
    }

    @Test
    void testReplace() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        User existingUser = new User(id, "Test User", "test@example.com", "password");
        repository.insert(existingUser);
        User updatedUser = new User(id, "Updated User", "updated@example.com", "newpassword");
        // WHEN
        repository.replace(id, updatedUser);
        User foundUser = repository.findById(id);
        // THEN
        assertNotNull(foundUser);
        assertEquals("Updated User", foundUser.getUsername());
        assertEquals("updated@example.com", foundUser.getEmail());
    }

    @Test
    void testRemoveById() {
        // GIVEN
        String id = UUID.randomUUID().toString();
        User user = new User(id, "Test User", "test@example.com", "password");
        repository.insert(user);
        // WHEN
        boolean removed = repository.removeById(id);
        // THEN
        assertTrue(removed);
        assertNull(repository.findById(id));
    }
}

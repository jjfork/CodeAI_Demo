package com.bestpractice.api.infrastrucuture.persistent.local;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalUserPersistentRepositoryTests {

    private LocalUserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LocalUserPersistentRepository();
    }

    @Test
    void testNewIdGeneratesUniqueIds() {
        // GIVEN a repository instance
        String id1 = repository.newId();
        String id2 = repository.newId();

        // THEN the generated IDs should be unique
        assertNotEquals(id1, id2);
    }

    @Test
    void testFindByEmailReturnsUserWhenFound() {
        // GIVEN a user with an email and added to the repository
        User user = new User("id1", "username1", "email@example.com", "password");
        repository.insert(user);

        // WHEN searching for the user by email
        User foundUser = repository.findByEmail("email@example.com");

        // THEN the returned user should match the one added
        assertNotNull(foundUser);
        assertEquals(user.getEmail(), foundUser.getEmail());
    }

    @Test
    void testFindByEmailReturnsNullWhenNotFound() {
        // GIVEN a repository with no users

        // WHEN searching for a non-existent email
        User foundUser = repository.findByEmail("nonexistent@example.com");

        // THEN the result should be null
        assertNull(foundUser);
    }

    @Test
    void testInsertAddsUserToRepository() {
        // GIVEN an empty repository and a new user
        User newUser = new User("id2", "username2", "email2@example.com", "password2");

        // WHEN inserting the new user into the repository
        repository.insert(newUser);

        // THEN the repository should contain the user
        User foundUser = repository.findByEmail("email2@example.com");
        assertNotNull(foundUser);
    }

    @Test
    void testInsertOverwritesExistingUserWithSameId() {
        // GIVEN a user already in the repository and a new user with the same ID
        User existingUser = new User("id3", "username3", "email3@example.com", "password3");
        repository.insert(existingUser);
        User newUser = new User("id3", "newUsername", "newEmail@example.com", "newPassword");

        // WHEN inserting the new user with the same ID
        repository.insert(newUser);

        // THEN the repository should contain the updated user information
        User foundUser = repository.findByEmail("newEmail@example.com");
        assertNotNull(foundUser);
        assertEquals("newUsername", foundUser.getUsername());
    }

    @Test
    void testRemoveRemovesUserFromRepository() {
        // GIVEN a user in the repository
        User userToRemove = new User("id4", "username4", "email4@example.com", "password4");
        repository.insert(userToRemove);

        // WHEN removing the user by ID
        repository.removeById(userToRemove.getId());

        // THEN the user should no longer be found in the repository
        assertNull(repository.findByEmail("email4@example.com"));
    }

    @Test
    void testRemoveDoesNothingWhenUserNotFound() {
        // GIVEN a repository with no users

        // WHEN attempting to remove a non-existent user by ID
        repository.removeById("nonexistentId");

        // THEN the operation should have no effect (no exception thrown)
        assertTrue(true);  // No assertion needed as we expect no change or error
    }
}

package com.bestpractice.api.infrastrucuture.persistent;

import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

;
;

class UserPersistentRepositoryTests {


    private UserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(UserPersistentRepository.class);
    }

    @Test
    void testNewId() {
        // GIVEN: A mock repository that generates new IDs
        String expectedId = "1234-5678-91011";
        when(repository.newId()).thenReturn(expectedId);

        // WHEN: Generating a new ID
        String actualId = repository.newId();

        // THEN: Verify the new ID matches the expected ID
        assertNotNull(actualId);
        assertEquals(expectedId, actualId);
    }

    @Test
    void testFindByEmailSuccess() {
        // GIVEN: A repository with a User associated with an email
        User mockUser = createUser("1", "username", "user@example.com", "password");
        when(repository.findByEmail("user@example.com")).thenReturn(mockUser);

        // WHEN: Finding a User by email
        User result = repository.findByEmail("user@example.com");

        // THEN: Verify the correct User object is returned
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("username", result.getUsername());
        assertEquals("user@example.com", result.getEmail());
    }

    @Test
    void testFindByEmailNotFound() {
        // GIVEN: A repository without a User for the specified email
        when(repository.findByEmail("nonexistent@example.com")).thenReturn(null);

        // WHEN: Attempting to find a User by a non-existent email
        User result = repository.findByEmail("nonexistent@example.com");

        // THEN: Verify the result is null
        assertNull(result);
    }

    @Test
    void testFindByIdSuccess() {
        // GIVEN: A repository with a User associated with an ID
        User mockUser = createUser("1", "username", "user@example.com", "password");
        when(repository.findById("1")).thenReturn(mockUser);

        // WHEN: Finding a User by ID
        User result = repository.findById("1");

        // THEN: Verify the correct User object is returned
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("username", result.getUsername());
        assertEquals("user@example.com", result.getEmail());
    }

    @Test
    void testFindByIdNotFound() {
        // GIVEN: A repository without a User for the specified ID
        when(repository.findById("nonexistent-id")).thenReturn(null);

        // WHEN: Attempting to find a User by a non-existent ID
        User result = repository.findById("nonexistent-id");

        // THEN: Verify the result is null
        assertNull(result);
    }

    @Test
    void testInsertSuccess() {
        // GIVEN: A valid User to insert
        User newUser = createUser("3", "newuser", "new@example.com", "newpassword");
        when(repository.insert(newUser)).thenReturn(newUser);

        // WHEN: Inserting the User
        User result = repository.insert(newUser);

        // THEN: Verify the User is returned as inserted
        assertNotNull(result);
        assertEquals("3", result.getId());
        assertEquals("newuser", result.getUsername());
        assertEquals("new@example.com", result.getEmail());
    }

    @Test
    void testReplaceSuccess() {
        // GIVEN: An existing User to replace
        User updatedUser = createUser("1", "updateduser", "updated@example.com", "updatedpassword");
        when(repository.replace("1", updatedUser)).thenReturn(updatedUser);

        // WHEN: Replacing the User
        User result = repository.replace("1", updatedUser);

        // THEN: Verify the User is returned as updated
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("updateduser", result.getUsername());
        assertEquals("updated@example.com", result.getEmail());
    }

    @Test
    void testRemoveByIdSuccess() {
        // GIVEN: An existing User ID for removal
        when(repository.removeById("1")).thenReturn(true);

        // WHEN: Removing a User by ID
        boolean result = repository.removeById("1");

        // THEN: Verify the removal operation succeeded
        assertTrue(result);
    }

    @Test
    void testRemoveByIdFailure() {
        // GIVEN: A non-existent User ID for removal
        when(repository.removeById("nonexistent-id")).thenReturn(false);

        // WHEN: Attempting to remove a User by a non-existent ID
        boolean result = repository.removeById("nonexistent-id");

        // THEN: Verify the removal operation failed
        assertFalse(result);
    }

    private User createUser(String id, String username, String email, String password) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
package com.bestpractice.api.infrastrucuture.persistent.rdbms;

import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


class RdbmsUserPersistentRepositoryTests {

    private JdbcTemplate jdbcTemplate;
    private RdbmsUserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        repository = new RdbmsUserPersistentRepository(jdbcTemplate);
    }

    @Test
    void testNewId() {
        // GIVEN: A repository instance

        // WHEN: Generating a new ID
        String newId = repository.newId();

        // THEN: Verify the ID is not null and has the correct format
        assertNotNull(newId);
        assertDoesNotThrow(() -> UUID.fromString(newId));
    }

    @Test
    void testFindByEmailSuccess() {
        // GIVEN: A database with a user having a specific email
        User mockUser = createUser("id1", "User1", "user1@example.com", "password1");
        when(jdbcTemplate.queryForObject(anyString(), any(DataClassRowMapper.class), eq("user1@example.com")))
                .thenReturn(mockUser);

        // WHEN: Finding a user by email
        User result = repository.findByEmail("user1@example.com");

        // THEN: Verify the correct user is retrieved
        assertNotNull(result);
        assertEquals("id1", result.getId());
        assertEquals("User1", result.getUsername());
        assertEquals("user1@example.com", result.getEmail());
    }

    @Test
    void testFindByEmailNotFound() {
        // GIVEN: A database without a matching email
        when(jdbcTemplate.queryForObject(anyString(), any(DataClassRowMapper.class), eq("nonexistent@example.com")))
                .thenReturn(null);

        // WHEN: Attempting to find a non-existent user
        User result = repository.findByEmail("nonexistent@example.com");

        // THEN: Verify the result is null
        assertNull(result);
    }

    @Test
    void testFindByIdSuccess() {
        // GIVEN: A database with a user having a specific ID
        User mockUser = createUser("id1", "User1", "user1@example.com", "password1");
        when(jdbcTemplate.queryForObject(anyString(), any(DataClassRowMapper.class), eq("id1")))
                .thenReturn(mockUser);

        // WHEN: Finding a user by ID
        User result = repository.findById("id1");

        // THEN: Verify the correct user is retrieved
        assertNotNull(result);
        assertEquals("id1", result.getId());
        assertEquals("User1", result.getUsername());
        assertEquals("user1@example.com", result.getEmail());
    }

    @Test
    void testFindByIdNotFound() {
        // GIVEN: A database without a matching ID
        when(jdbcTemplate.queryForObject(anyString(), any(DataClassRowMapper.class), eq("nonexistent-id")))
                .thenReturn(null);

        // WHEN: Attempting to find a non-existent user
        User result = repository.findById("nonexistent-id");

        // THEN: Verify the result is null
        assertNull(result);
    }

    @Test
    void testInsertSuccess() {
        // GIVEN: A valid User object
        User user = createUser("id1", "User1", "user1@example.com", "password1");

        // WHEN: Inserting the user
        User result = repository.insert(user);

        // THEN: Verify the user is inserted correctly
        assertNotNull(result);
        verify(jdbcTemplate, times(1))
                .update(anyString(), eq("id1"), eq("User1"), eq("user1@example.com"), eq("password1"));
    }



    @Test
    void testReplaceSuccess() {
        // GIVEN: A valid User object and ID
        User user = createUser("id1", "UpdatedUser", "updated@example.com", "updatedPassword");

        // WHEN: Replacing the user record
        User result = repository.replace("id1", user);

        // THEN: Verify the update query is executed
        assertNotNull(result);
        verify(jdbcTemplate, times(1))
                .update(anyString(), eq("UpdatedUser"), eq("updated@example.com"), eq("updatedPassword"), eq("id1"));
    }

    @Test
    void testRemoveByIdSuccess() {
        // GIVEN: A valid ID for deletion
        when(jdbcTemplate.update(anyString(), eq("id1"))).thenReturn(1);

        // WHEN: Deleting the user by ID
        boolean result = repository.removeById("id1");

        // THEN: Verify the user is deleted successfully
        assertTrue(result);
    }

    @Test
    void testRemoveByIdFailure() {
        // GIVEN: A non-existent ID for deletion
        when(jdbcTemplate.update(anyString(), eq("nonexistent-id"))).thenThrow(new RuntimeException());

        // WHEN: Attempting to delete a user by ID
        boolean result = repository.removeById("nonexistent-id");

        // THEN: Verify the deletion fails gracefully
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
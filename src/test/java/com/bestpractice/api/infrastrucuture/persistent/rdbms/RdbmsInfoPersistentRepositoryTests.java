package com.bestpractice.api.infrastrucuture.persistent.rdbms;

import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.InternalServerError;
import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

;
;

class RdbmsInfoPersistentRepositoryTests {

    private JdbcTemplate jdbcTemplate;
    private RdbmsInfoPersistentRepository repository;

    @BeforeEach
    void setUp() {
        jdbcTemplate = mock(JdbcTemplate.class);
        repository = new RdbmsInfoPersistentRepository(jdbcTemplate);
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
    void testFindAllEmpty() {
        // GIVEN: A database with no entries
        when(jdbcTemplate.query(anyString(), (ResultSetExtractor<Object>) any())).thenReturn(Collections.emptyList());

        // WHEN: Fetching all records
        List<Info> result = repository.findAll();

        // THEN: Verify the result is an empty list
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindByIdSuccess() {
        // GIVEN: A pre-configured database with a specific entry
        Info mockInfo = createInfo("id1", "Title1", "Description1");
        when(jdbcTemplate.queryForObject(anyString(), (RowMapper<Object>) any(), eq("id1"))).thenReturn(mockInfo);

        // WHEN: Fetching a record by ID
        Info result = repository.findById("id1");

        // THEN: Verify the correct record is retrieved
        assertNotNull(result);
        assertEquals("id1", result.getId());
        assertEquals("Title1", result.getTitle());
        assertEquals("Description1", result.getDescription());
    }

    @Test
    void testFindByIdNotFound() {
        // GIVEN: A database with no matching ID
        when(jdbcTemplate.queryForObject(anyString(), (RowMapper<Object>) any(), eq("nonexistent-id"))).thenReturn(null);

        // WHEN: Fetching a non-existent record
        Info result = repository.findById("nonexistent-id");

        // THEN: Verify the result is null
        assertNull(result);
    }



    @Test
    void testReplaceSuccess() {
        // GIVEN: A valid Info object and ID
        Info info = createInfo("id1", "UpdatedTitle", "UpdatedDescription");

        // WHEN: Replacing the record
        repository.replace("id1", info);

        // THEN: Verify the update query is executed
        verify(jdbcTemplate, times(1)).update(anyString(), eq("UpdatedTitle"), eq("UpdatedDescription"), eq("id1"));
    }

    @Test
    void testRemoveByIdSuccess() {
        // GIVEN: A valid ID for deletion
        when(jdbcTemplate.update(anyString(), eq("id1"))).thenReturn(1);

        // WHEN: Deleting the record by ID
        boolean result = repository.removeById("id1");

        // THEN: Verify the record is deleted successfully
        assertTrue(result);
    }

    @Test
    void testRemoveByIdFailure() {
        // GIVEN: A non-existent ID for deletion
        when(jdbcTemplate.update(anyString(), eq("nonexistent-id"))).thenThrow(new RuntimeException());

        // WHEN: Attempting to delete a record by ID
        boolean result = repository.removeById("nonexistent-id");

        // THEN: Verify the deletion fails gracefully
        assertFalse(result);
    }


    private Info createInfo(String id, String title, String description) {
        Info info = new Info();
        info.setId(id);
        info.setTitle(title);
        info.setDescription(description);
        return info;
    }
}
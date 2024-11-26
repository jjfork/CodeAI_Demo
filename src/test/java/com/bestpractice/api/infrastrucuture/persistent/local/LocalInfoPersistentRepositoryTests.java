package com.bestpractice.api.infrastrucuture.persistent.local;

import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocalInfoPersistentRepositoryTests {

    private LocalInfoPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LocalInfoPersistentRepository();
    }

    @Test
    void testNewId() {
        // GIVEN: A LocalInfoPersistentRepository instance

        // WHEN: Generating a new ID
        String newId = repository.newId();

        // THEN: The new ID should not be null
        assertNotNull(newId);
        assertFalse(newId.isEmpty());
    }

    @Test
    void testFindAll_EmptyRepository() {
        // GIVEN: An empty repository

        // WHEN: Retrieving all infos
        List<Info> infos = repository.findAll();

        // THEN: The list should be empty
        assertNotNull(infos);
        assertTrue(infos.isEmpty());
    }

    @Test
    void testFindAll_WithEntries() {
        // GIVEN: A repository with one entry
        Info info = new Info();
        info.setId("1");
        info.setTitle("Title 1");
        info.setDescription("Description 1");
        repository.insert(info);

        // WHEN: Retrieving all infos
        List<Info> infos = repository.findAll();

        // THEN: The list should contain the inserted entry
        assertNotNull(infos);
        assertEquals(1, infos.size());
        assertEquals("1", infos.get(0).getId());
    }

    @Test
    void testFindById_ExistingId() {
        // GIVEN: A repository with one entry
        Info info = new Info();
        info.setId("1");
        info.setTitle("Title 1");
        info.setDescription("Description 1");
        repository.insert(info);

        // WHEN: Searching for the entry by ID
        Info result = repository.findById("1");

        // THEN: The correct entry should be returned
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Title 1", result.getTitle());
        assertEquals("Description 1", result.getDescription());
    }

    @Test
    void testFindById_NonExistingId() {
        // GIVEN: An empty repository

        // WHEN: Searching for a non-existing ID
        Info result = repository.findById("1");

        // THEN: The result should be null
        assertNull(result);
    }

    @Test
    void testInsert() {
        // GIVEN: An empty repository
        Info info = new Info();
        info.setId("1");
        info.setTitle("Title 1");
        info.setDescription("Description 1");

        // WHEN: Inserting an entry
        Info inserted = repository.insert(info);

        // THEN: The inserted entry should match the input
        assertNotNull(inserted);
        assertEquals("1", inserted.getId());
        assertEquals("Title 1", inserted.getTitle());
        assertEquals("Description 1", inserted.getDescription());
    }


    @Test
    void testReplace_NonExistingId() {
        // GIVEN: An empty repository
        Info newInfo = new Info();
        newInfo.setId("1");
        newInfo.setTitle("New Title");
        newInfo.setDescription("New Description");

        // WHEN: Attempting to replace a non-existing entry
        Exception exception = assertThrows(RuntimeException.class, () -> repository.replace("1", newInfo));

        // THEN: An exception should be thrown
        assertEquals("Data does not exist.", exception.getMessage());
    }

    @Test
    void testRemoveById_ExistingId() {
        // GIVEN: A repository with one entry
        Info info = new Info();
        info.setId("1");
        info.setTitle("Title 1");
        info.setDescription("Description 1");
        repository.insert(info);

        // WHEN: Removing the entry by ID
        boolean result = repository.removeById("1");

        // THEN: The entry should be removed
        assertTrue(result);
        assertNull(repository.findById("1"));
    }

    @Test
    void testRemoveById_NonExistingId() {
        // GIVEN: An empty repository

        // WHEN: Attempting to remove a non-existing ID
        boolean result = repository.removeById("1");

        // THEN: The result should be true (method does not throw an exception)
        assertTrue(result);
    }
}

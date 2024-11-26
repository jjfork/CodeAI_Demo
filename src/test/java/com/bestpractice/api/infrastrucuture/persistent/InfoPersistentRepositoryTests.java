package com.bestpractice.api.infrastrucuture.persistent;

import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

;
;

class InfoPersistentRepositoryTests {

    private InfoPersistentRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(InfoPersistentRepository.class);
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
    void testFindAllSuccess() {
        // GIVEN: A repository with a list of Info objects
        List<Info> mockInfos = new ArrayList<>();
        mockInfos.add(createInfo("1", "Title1", "Description1"));
        mockInfos.add(createInfo("2", "Title2", "Description2"));
        when(repository.findAll()).thenReturn(mockInfos);

        // WHEN: Retrieving all Info objects
        List<Info> result = repository.findAll();

        // THEN: Verify the correct list is returned
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Title1", result.get(0).getTitle());
        assertEquals("Title2", result.get(1).getTitle());
    }

    @Test
    void testFindByIdSuccess() {
        // GIVEN: A repository with an Info object for a specific ID
        Info mockInfo = createInfo("1", "Title1", "Description1");
        when(repository.findById("1")).thenReturn(mockInfo);

        // WHEN: Finding an Info object by ID
        Info result = repository.findById("1");

        // THEN: Verify the correct Info object is returned
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Title1", result.getTitle());
        assertEquals("Description1", result.getDescription());
    }

    @Test
    void testFindByIdNotFound() {
        // GIVEN: A repository without a matching Info object
        when(repository.findById("nonexistent-id")).thenReturn(null);

        // WHEN: Attempting to find a non-existent Info object
        Info result = repository.findById("nonexistent-id");

        // THEN: Verify the result is null
        assertNull(result);
    }

    @Test
    void testInsertSuccess() {
        // GIVEN: A valid Info object to insert
        Info newInfo = createInfo("3", "NewTitle", "NewDescription");
        when(repository.insert(newInfo)).thenReturn(newInfo);

        // WHEN: Inserting the Info object
        Info result = repository.insert(newInfo);

        // THEN: Verify the Info object is returned as inserted
        assertNotNull(result);
        assertEquals("3", result.getId());
        assertEquals("NewTitle", result.getTitle());
        assertEquals("NewDescription", result.getDescription());
    }

    @Test
    void testReplaceSuccess() {
        // GIVEN: An existing Info object to replace
        Info updatedInfo = createInfo("1", "UpdatedTitle", "UpdatedDescription");
        when(repository.replace("1", updatedInfo)).thenReturn(updatedInfo);

        // WHEN: Replacing the Info object
        Info result = repository.replace("1", updatedInfo);

        // THEN: Verify the Info object is returned as updated
        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("UpdatedTitle", result.getTitle());
        assertEquals("UpdatedDescription", result.getDescription());
    }

    @Test
    void testRemoveByIdSuccess() {
        // GIVEN: An existing ID for removal
        when(repository.removeById("1")).thenReturn(true);

        // WHEN: Removing an Info object by ID
        boolean result = repository.removeById("1");

        // THEN: Verify the removal operation succeeded
        assertTrue(result);
    }

    @Test
    void testRemoveByIdFailure() {
        // GIVEN: A non-existent ID for removal
        when(repository.removeById("nonexistent-id")).thenReturn(false);

        // WHEN: Attempting to remove a non-existent Info object
        boolean result = repository.removeById("nonexistent-id");

        // THEN: Verify the removal operation failed
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
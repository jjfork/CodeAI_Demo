package com.bestpractice.api.infrastrucuture.persistent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.bestpractice.api.infrastrucuture.persistent.InfoPersistentRepository;


class InfoPersistentRepositoryTests {
    private InfoPersistentRepository infoPersistentRepository;

    @BeforeEach
    void setUp() {
        infoPersistentRepository = new InfoPersistentRepository();
    }

    @Test
    void testNewId() {
        // GIVEN - 
        // WHEN - String newId = infoPersistentRepository.newId();
        // THEN - assertNotNull(newId);
    }

    @Test
    void testFindAll() {
        // GIVEN - 
        // WHEN - List<Info> all = infoPersistentRepository.findAll();
        // THEN - assertTrue(all.size() > 0);
    }

    @Test
    void testFindById() {
        // GIVEN - String id = "someId";
        // WHEN - Info found = infoPersistentRepository.findById(id);
        // THEN - assertNotNull(found);
    }

    @Test
    void testInsert() {
        // GIVEN - Info info = new Info();
        // WHEN - Info inserted = infoPersistentRepository.insert(info);
        // THEN - assertNotNull(inserted);
    }

    @Test
    void testReplace() {
        // GIVEN - String id = "someId";
        // Info info = new Info();
        // WHEN - Info replaced = infoPersistentRepository.replace(id, info);
        // THEN - assertNotNull(replaced);
    }

    @Test
    void testRemoveById() {
        // GIVEN - String id = "someId";
        // WHEN - boolean removed = infoPersistentRepository.removeById(id);
        // THEN - assertTrue(removed);
    }
}
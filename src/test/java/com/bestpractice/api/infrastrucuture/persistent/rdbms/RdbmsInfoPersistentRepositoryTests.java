package com.bestpractice.api.infrastrucuture.persistent.rdbms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class InfoRepositoryTests {

    @Autowired
    private InfoRepository repository;

    @BeforeEach
    void setUp() {
        // Reset the database state before each test
    }

    @Test
    void testFindAll() {
        // GIVEN a list of Infos in the database
        List<Info> infos = List.of(new Info(), new Info());
        // WHEN findAll is called
        List<Info> foundInfos = repository.findAll();
        // THEN the returned list contains all Infos
        assertEquals(infos.size(), foundInfos.size());
    }

    @Test
    void testfindById() {
        // GIVEN an Info in the database with a specific ID
        Info info = new Info();
        info.setId("testId");
        repository.save(info);
        // WHEN findById is called with the specific ID
        Info foundInfo = repository.findById("testId").orElse(null);
        // THEN the returned Info matches the saved Info
        assertEquals(info.getId(), foundInfo.getId());
    }

    @Test
    void testInsert() {
        // GIVEN a new Info object
        Info info = new Info();
        // WHEN insert is called with the new Info object
        repository.insert(info);
        // THEN the Info is saved in the database
        assertNotNull(repository.findById(info.getId()));
    }

    @Test
    void testReplace() {
        // GIVEN an existing Info in the database with a specific ID
        Info info = new Info();
        info.setId("testId");
        repository.save(info);
        // WHEN replace is called with the updated Info object
        info.setTitle("New Title");
        repository.replace(info);
        // THEN the Info in the database matches the updated Info
        assertEquals("New Title", repository.findById("testId").get().getTitle());
    }

    @Test
    void testRemoveById() {
        // GIVEN an existing Info in the database with a specific ID
        Info info = new Info();
        info.setId("testId");
        repository.save(info);
        // WHEN removeById is called with the Info's ID
        repository.removeById("testId");
        // THEN the Info is removed from the database
        assertNull(repository.findById("testId"));
    }
}
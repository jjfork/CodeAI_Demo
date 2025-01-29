package com.bestpractice.api.infrastrucuture.persistent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserPersistentRepositoryTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testNewId() {
        // GIVEN - 
        // WHEN - String newId = userPersistentRepository.newId();
        // THEN - assertNotNull(newId);
    }

    @Test
    void testFindByEmail() {
        // GIVEN - 
        // WHEN - User user = userPersistentRepository.findByEmail("test@example.com");
        // THEN - assertNotNull(user);
    }

    @Test
    void testFindById() {
        // GIVEN - 
        // WHEN - User user = userPersistentRepository.findById("testId");
        // THEN - assertNotNull(user);
    }

    @Test
    void testInsert() {
        // GIVEN - User user = new User("testId", "testUsername", "testEmail", "testPassword");
        // WHEN - User insertedUser = userPersistentRepository.insert(user);
        // THEN - assertNotNull(insertedUser);
    }

    @Test
    void testReplace() {
        // GIVEN - User user = new User("testId", "testUsername", "testEmail", "testPassword");
        // WHEN - User replacedUser = userPersistentRepository.replace("testId", user);
        // THEN - assertNotNull(replacedUser);
    }

    @Test
    void testRemove() {
        // GIVEN - 
        // WHEN - boolean removed = userPersistentRepository.remove("testId");
        // THEN - assertTrue(removed);
    }
}
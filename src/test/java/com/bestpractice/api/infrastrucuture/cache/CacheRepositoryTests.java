package com.bestpractice.api.infrastrucuture.cache;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CacheRepositoryTests {

    private CacheRepository cacheRepository;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize the CacheRepository instance before each test.
        cacheRepository = new CacheRepository();
    }

    @Test
    void testCacheRepositoryInitialization() {
        // GIVEN: A newly created CacheRepository object.

        // WHEN: The CacheRepository is instantiated.

        // THEN: The CacheRepository should not be null.
        assertNotNull(cacheRepository, "The CacheRepository instance should not be null.");
    }
}

package com.bestpractice.api.infrastrucuture.cache.local;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalCacheRepositoryTests {

    private LocalCacheRepository localCacheRepository;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize the LocalCacheRepository before each test to ensure a clean state.
        localCacheRepository = new LocalCacheRepository();
    }

    @Test
    void testLocalCacheRepositoryInitialization() {
        // GIVEN: A newly instantiated LocalCacheRepository object.

        // WHEN: The repository is created.

        // THEN: The repository should not be null, indicating successful initialization.
        assertNotNull(localCacheRepository);
    }
}

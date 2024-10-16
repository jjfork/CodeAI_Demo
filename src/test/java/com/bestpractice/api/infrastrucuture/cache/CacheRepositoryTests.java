package com.bestpractice.api.infrastrucuture.cache;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CacheRepositoryTests {

    private CacheRepository cacheRepository;

    @BeforeEach
    void setUp() {
        cacheRepository = new CacheRepository();
    }

    @Test
    void testSomeMethod() {
        // GIVEN
        // WHEN
        // THEN
    }
}

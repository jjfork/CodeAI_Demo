package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SharedDataTests {
    private SharedData sharedData;

    @BeforeEach
    void setUp() {
        sharedData = new SharedData();
    }

    @Test
    void testGetCreatedAt_ReturnsInitialValue() {
        // GIVEN - A newly created instance of SharedData
        // WHEN - We call getCreatedAt()
        java.util.Date createdAt = sharedData.getCreatedAt();
        // THEN - The returned value should be null
        org.junit.jupiter.api.Assertions.assertNull(createdAt);
    }

    @Test
    void testSetCreatedAt_SetsValue() {
        // GIVEN - A newly created instance of SharedData
        // WHEN - We call setCreatedAt() with a new Date object
        sharedData.setCreatedAt(new java.util.Date());
        // THEN - The returned value should be the provided Date object
        org.junit.jupiter.api.Assertions.assertNotNull(sharedData.getCreatedAt());
    }
}
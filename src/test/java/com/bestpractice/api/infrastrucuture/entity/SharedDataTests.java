package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SharedDataTests {

    private SharedData sharedData;

    @BeforeEach
    void setUp() {
        // GIVEN: A new instance of a subclass of SharedData
        sharedData = new SharedData() {}; // Using an anonymous subclass since SharedData is abstract
    }

    @Test
    void testGetAndSetCreatedAt() {
        // GIVEN: A specific Date value
        Date now = new Date();

        // WHEN: setCreatedAt is called
        sharedData.setCreatedAt(now);

        // THEN: getCreatedAt returns the same Date value
        assertEquals(now, sharedData.getCreatedAt());
    }

    @Test
    void testOnPrePersistSetsCreatedAt() {
        // GIVEN: A new instance of SharedData

        // WHEN: onPrePersist is called
        sharedData.onPrePersist();

        // THEN: createdAt is set to a non-null value
        assertNotNull(sharedData.getCreatedAt());

        // AND: createdAt is set to a time close to the current system time
        long diffInMillis = Math.abs(sharedData.getCreatedAt().getTime() - new Date().getTime());
        assertTrue(diffInMillis < 1000, "createdAt should be set to a recent time");
    }

    @Test
    void testSetCreatedAtWithNull() {
        // GIVEN: A null Date value
        Date nullDate = null;

        // WHEN: setCreatedAt is called with null
        sharedData.setCreatedAt(nullDate);

        // THEN: getCreatedAt returns null
        assertNull(sharedData.getCreatedAt());
    }
}

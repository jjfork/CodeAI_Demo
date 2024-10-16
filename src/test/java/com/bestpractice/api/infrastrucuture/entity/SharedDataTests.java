package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SharedDataTests {

    private SharedData sharedData;

    @BeforeEach
    void setUp() {
        sharedData = new SharedData();
    }

    @Test
    void testCreatedAt() {
        // GIVEN - A new instance of SharedData
        // WHEN - The onPrePersist method is called
        sharedData.onPrePersist();
        // THEN - The createdAt field is set to the current date and time
        assertEquals(new Date(), sharedData.getCreatedAt());
    }
}

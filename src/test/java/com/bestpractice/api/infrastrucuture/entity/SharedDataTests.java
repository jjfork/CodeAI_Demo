package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class SharedDataTests {

    @Test
    void testCreatedAt() {
        SharedData sharedData = new SharedData();
        Date createdAt = new Date();
        sharedData.setCreatedAt(createdAt);
        assertEquals(createdAt, sharedData.getCreatedAt());
    }
}

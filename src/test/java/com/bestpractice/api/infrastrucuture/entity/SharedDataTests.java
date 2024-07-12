package com.bestpractice.api.infrastrucuture.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class SharedDataTests {

    @Test
    public void onPrePersist_ShouldSetCreatedAt() {
        SharedData sharedData = new SharedData();
        sharedData.onPrePersist();
        assertNotNull(sharedData.getCreatedAt());
    }

    @Test
    public void getCreatedAt_ShouldReturnCreatedAt() {
        SharedData sharedData = new SharedData();
        Date date = new Date();
        sharedData.setCreatedAt(date);
        assertEquals(date, sharedData.getCreatedAt());
    }

    @Test
    public void setCreatedAt_ShouldSetCreatedAt() {
        SharedData sharedData = new SharedData();
        Date date = new Date();
        sharedData.setCreatedAt(date);
        assertEquals(date, sharedData.getCreatedAt());
    }
}

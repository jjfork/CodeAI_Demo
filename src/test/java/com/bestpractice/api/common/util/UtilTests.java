package com.bestpractice.api.common.util;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCalculateDate() {
        Date date = Util.calculateDate();
        assertEquals(date.getYear() + 1900, java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) + 1);
    }

    @Test
    void testDeepClone() throws IOException, ClassNotFoundException {
        Date date = new Date();
        Date clonedDate = Util.deepClone(date);
        assertEquals(date, clonedDate);
    }

    @Test
    void testGetSpringProfileActive() {
        String profile = Util.getSpringProfileActive();
        assertEquals(profile, System.getenv("SPRING_PROFILES_ACTIVE"));
    }
}

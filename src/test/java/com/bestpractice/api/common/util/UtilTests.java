package com.bestpractice.api.common.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UtilTests {
    private Util util = new Util();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCalculateDate() {
        // GIVEN - Today's date
        Date today = new Date();
        // WHEN - Calculate the date one year from today
        Date futureDate = util.calculateDate();
        // THEN - The calculated date is one year after today
        assertEquals(today.getYear() + 1, futureDate.getYear());
    }

    @Test
    void testDeepClone() throws IOException, ClassNotFoundException {
        // GIVEN - A sample object to clone
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // WHEN - Deep clone the calendar object
        Calendar clonedCalendar = (Calendar) util.deepClone(calendar);
        // THEN - The cloned calendar is a separate instance with the same values as the original
        assertNotSame(calendar, clonedCalendar);
        assertEquals(calendar.getTime(), clonedCalendar.getTime());
    }

    @Test
    void testGetSpringProfileActive() {
        // GIVEN - A system environment variable "SPRING_PROFILES_ACTIVE"
        String expectedProfile = "development";
        System.setProperty("SPRING_PROFILES_ACTIVE", expectedProfile);
        // WHEN - Get the active Spring profile
        String actualProfile = util.getSpringProfileActive();
        // THEN - The retrieved profile matches the set environment variable
        assertEquals(expectedProfile, actualProfile);
    }
}
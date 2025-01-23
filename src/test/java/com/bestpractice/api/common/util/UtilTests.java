package com.bestpractice.api.common.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateDateTest() {
        // GIVEN - Today's date
        Date today = new Date();
        // WHEN - Calculate date one year from today
        Date futureDate = Util.calculateDate();
        // THEN - Future date should be one year from today
        assertEquals(today.getYear() + 1, futureDate.getYear());
    }

    @Test
    void deepCloneTest() throws IOException, ClassNotFoundException {
        // GIVEN - An object to clone
        Calendar calendar = Calendar.getInstance();
        // WHEN - Deep clone the calendar object
        Calendar clonedCalendar = Util.deepClone(calendar);
        // THEN - Cloned calendar should be a deep copy of the original
        assertEquals(calendar.getTimeInMillis(), clonedCalendar.getTimeInMillis());
    }

    @Test
    void getSpringProfileActiveTest() {
        // GIVEN - No SPRING_PROFILES_ACTIVE environment variable set
        // WHEN - Get the active Spring profile
        String activeProfile = Util.getSpringProfileActive();
        // THEN - Active profile should be null
        assertEquals(null, activeProfile);
    }
}

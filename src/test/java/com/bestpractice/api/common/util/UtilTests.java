package com.bestpractice.api.common.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void calculateDateTest() {
        // GIVEN - No specific setup needed
        // WHEN - Calculate the date one year from now
        Date futureDate = Util.calculateDate();
        // THEN - Assert that the calculated date is in the future
        assertEquals(futureDate.after(new Date()), true);
    }

    @Test
    void deepCloneTest() throws IOException, ClassNotFoundException {
        // GIVEN - Create a sample object to clone
        Date sampleDate = new Date();
        // WHEN - Deep clone the sample object
        Date clonedDate = Util.deepClone(sampleDate);
        // THEN - Assert that the cloned object is not the same as the original object
        assertEquals(sampleDate, clonedDate);
    }

    @Test
    void getSpringProfileActiveTest() {
        // GIVEN - No specific setup needed
        // WHEN - Get the active Spring profile
        String activeProfile = Util.getSpringProfileActive();
        // THEN - Assert that the active profile is not null
        assertEquals(activeProfile, null);
    }
}

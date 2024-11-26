package com.bestpractice.api.common.util;

import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;

import java.io.IOException; import java.util.Calendar; import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UtilTests {


    @BeforeEach
    void setUp() {
        // No shared state to reset for these utility methods
    }

    @Test
    void givenCurrentDate_whenCalculateDate_thenReturnDateOneYearLater() {
        // GIVEN: The current date
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.YEAR, 1);
        Date expectedDate = calendar.getTime();

        // WHEN: Calling calculateDate
        Date resultDate = Util.calculateDate();

        // THEN: The result should match the expected date
        assertNotNull(resultDate, "The returned date should not be null");
        assertEquals(expectedDate.getYear(), resultDate.getYear(), "The year should be one year later");
    }

    @Test
    void givenSerializableObject_whenDeepClone_thenReturnClonedObject() throws IOException, ClassNotFoundException {
        // GIVEN: A serializable object (in this case, a simple String)
        String original = "Deep clone test";

        // WHEN: Calling deepClone
        String cloned = Util.deepClone(original);

        // THEN: The cloned object should be equal but not the same reference as the original
        assertNotNull(cloned, "The cloned object should not be null");
        assertEquals(original, cloned, "The cloned object should have the same value as the original");
        assertNotSame(original, cloned, "The cloned object should not be the same reference as the original");
    }

    @Test
    void givenInvalidObject_whenDeepClone_thenThrowException() {
        // GIVEN: A non-serializable object (in this case, an object with no Serializable interface)
        Object nonSerializableObject = new Object();

        // WHEN: Attempting to deepClone, expect an exception
        Exception exception = assertThrows(IOException.class, () -> Util.deepClone(nonSerializableObject));

        // THEN: An IOException should be thrown
        assertNotNull(exception, "An exception should be thrown for a non-serializable object");
    }



    @Test
    void givenSpringProfilesActiveEnvVarNotSet_whenGetSpringProfileActive_thenReturnNull() {
        // GIVEN: The SPRING_PROFILES_ACTIVE environment variable is not set
        System.clearProperty("SPRING_PROFILES_ACTIVE"); // Ensure the variable is unset

        // WHEN: Calling getSpringProfileActive
        String result = Util.getSpringProfileActive();

        // THEN: The result should be null
        assertNull(result, "The returned value should be null if the environment variable is not set");
    }
}
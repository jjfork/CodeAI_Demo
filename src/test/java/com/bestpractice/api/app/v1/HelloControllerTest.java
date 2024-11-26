package com.bestpractice.api.app.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HelloControllerTests {

    @InjectMocks
    private HelloController helloController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSample1() {
        // GIVEN: No preconditions are necessary for this test

        // WHEN: The sample1 method is called
        Map<String, String> response = helloController.sample1();

        // THEN: The response should contain the expected key-value pair
        assertNotNull(response, "Response should not be null");
        assertEquals(1, response.size(), "Response should contain exactly one entry");
        assertEquals("Hello world.", response.get("key"), "Value associated with 'key' should match");
    }
}
package com.bestpractice.api.app.v1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSample1() throws Exception {
        // GIVEN - No specific setup needed for this test
        // WHEN - Make a GET request to /api/v1/hello
        mockMvc.perform(get("/api/v1/hello")
                .contentType(MediaType.APPLICATION_JSON))
                // THEN - Verify the response status code and content
                .andExpect(status().isOk())
                .andExpect(content().json("{\"key\":\"Hello world.\"}"));
    }
}
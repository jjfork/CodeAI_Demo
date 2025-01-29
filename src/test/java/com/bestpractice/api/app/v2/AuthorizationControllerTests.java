package com.bestpractice.api.app.v2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class AuthorizationControllerTests {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        // Setup any necessary preconditions for each test
    }

    @Test
    void testRootEndpoint() throws Exception {
        // GIVEN - Context setup
        // WHEN - Send a GET request to the root endpoint
        mockMvc.perform(get("/api/v2/"))
                // THEN - Assert the expected response status and content
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
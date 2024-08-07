package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InfoResponseTests {

    @Test
    void testGetId() {
        InfoResponse infoResponse = new InfoResponse("1", "Title 1", "Description 1");
        assertEquals("1", infoResponse.getId());
    }

    @Test
    void testGetTitle() {
        InfoResponse infoResponse = new InfoResponse("2", "Title 2", "Description 2");
        assertEquals("Title 2", infoResponse.getTitle());
    }

    @Test
    void testGetDescription() {
        InfoResponse infoResponse = new InfoResponse("3", "Title 3", "Description 3");
        assertEquals("Description 3", infoResponse.getDescription());
    }
}

package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoRequestTests {

    private InfoRequest infoRequest;

    @BeforeEach
    void setUp() {
        infoRequest = new InfoRequest();
    }

    @Test
    void testConvert() {
        String id = "testId";
        infoRequest.setTitle("testTitle");
        infoRequest.setDescription("testDescription");
        com.bestpractice.api.infrastrucuture.entity.Info info = infoRequest.convert(id);
        assertEquals(id, info.getId());
        assertEquals("testTitle", info.getTitle());
        assertEquals("testDescription", info.getDescription());
    }
}

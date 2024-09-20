package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.bestpractice.api.infrastrucuture.entity.Info; 

class InfoRequestTests {

    @Test
    void testConvert() {
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Test Title");
        infoRequest.setDescription("Test Description");
        Info info = infoRequest.convert("testId");
        assertEquals("Test Title", info.getTitle());
        assertEquals("Test Description", info.getDescription());
        assertEquals("testId", info.getId());
    }
}

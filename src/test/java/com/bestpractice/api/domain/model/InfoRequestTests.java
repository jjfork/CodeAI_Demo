package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InfoRequestTests {

    @Test
    void convert_ValidId_ReturnsInfoObject() {
        // Arrange
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Test Title");
        infoRequest.setDescription("Test Description");
        String id = "123";

        // Act
        Info info = infoRequest.convert(id);

        // Assert
        assertNotNull(info);
        assertEquals(id, info.getId());
        assertEquals(infoRequest.getTitle(), info.getTitle());
        assertEquals(infoRequest.getDescription(), info.getDescription());
    }

    @Test
    void convert_NullId_ReturnsInfoObject() {
        // Arrange
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Test Title");
        infoRequest.setDescription("Test Description");

        // Act
        Info info = infoRequest.convert(null);

        // Assert
        assertNotNull(info);
        assertNull(info.getId());
        assertEquals(infoRequest.getTitle(), info.getTitle());
        assertEquals(infoRequest.getDescription(), info.getDescription());
    }
}

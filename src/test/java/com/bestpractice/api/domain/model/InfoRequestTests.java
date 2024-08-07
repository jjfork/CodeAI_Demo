package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class InfoRequestTests {

    @Test
    void convert_ValidId_ReturnsInfoObject() {
        // Arrange
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Test Title");
        infoRequest.setDescription("Test Description");

        // Act
        Info info = infoRequest.convert("123");

        // Assert
        assertNotNull(info);
        assertEquals("123", info.getId());
        assertEquals("Test Title", info.getTitle());
        assertEquals("Test Description", info.getDescription());
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
        assertEquals("Test Title", info.getTitle());
        assertEquals("Test Description", info.getDescription());
    }

    @Test
    void convert_EmptyId_ReturnsInfoObject() {
        // Arrange
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Test Title");
        infoRequest.setDescription("Test Description");

        // Act
        Info info = infoRequest.convert("");

        // Assert
        assertNotNull(info);
        assertEquals("", info.getId());
        assertEquals("Test Title", info.getTitle());
        assertEquals("Test Description", info.getDescription());
    }
}

package com.bestpractice.api.domain.service;

    @Test

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
    void testUpdateInfo_Success() {
        // GIVEN
        String id = "1";
        InfoRequest request = new InfoRequest("Updated Title", "Updated Description");
        Info info = new Info(id, request.getTitle(), request.getDescription());
        when(repository.findById(id)).thenReturn(new Info(id, "Original Title", "Original Description")); 
        when(repository.save(any(Info.class))).thenReturn(info);

        // WHEN
        InfoResponse result = infoService.updateInfo(id, request);

        // THEN
        assertEquals(id, result.getId());
        assertEquals(request.getTitle(), result.getTitle());
        assertEquals(request.getDescription(), result.getDescription());
    }

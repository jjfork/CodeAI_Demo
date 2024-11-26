package com.bestpractice.api.domain.service;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.InternalServerError;
import com.bestpractice.api.domain.model.InfoRequest;
import com.bestpractice.api.domain.model.InfoResponse;
import com.bestpractice.api.infrastrucuture.entity.Info;
import com.bestpractice.api.infrastrucuture.persistent.InfoPersistentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InfoServiceImplTests {

    private InfoPersistentRepository mockInfoRepository;
    private InfoServiceImpl infoService;

    @BeforeEach
    void setUp() {
        mockInfoRepository = mock(InfoPersistentRepository.class);
        infoService = new InfoServiceImpl(mockInfoRepository);
    }

    @Test
    void testGetInfos_Success() {
        // GIVEN: Mock repository returning a list of Info entities
        Info info1 = new Info();
        info1.setId("1");
        info1.setTitle("Title 1");
        info1.setDescription("Description 1");

        Info info2 = new Info();
        info2.setId("2");
        info2.setTitle("Title 2");
        info2.setDescription("Description 2");

        when(mockInfoRepository.findAll()).thenReturn(List.of(info1, info2));

        // WHEN: getInfos is called
        List<InfoResponse> result = infoService.getInfos();

        // THEN: The result should match the mocked Info entities
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("1", result.get(0).getId());
        assertEquals("Title 1", result.get(0).getTitle());
        assertEquals("Description 1", result.get(0).getDescription());
    }

    @Test
    void testGetInfos_InternalServerError() {
        // GIVEN: Mock repository throws an exception
        when(mockInfoRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // WHEN: getInfos is called
        InternalServerError exception = assertThrows(InternalServerError.class, () -> {
            infoService.getInfos();
        });

        // THEN: Ensure the exception is thrown with the correct cause
        assertEquals("java.lang.RuntimeException: Database error", exception.getCause().toString());
    }

    @Test
    void testGetInfo_Success() {
        // GIVEN: Mock repository returning a valid Info entity
        String id = "1";
        Info info = new Info();
        info.setId(id);
        info.setTitle("Title");
        info.setDescription("Description");

        when(mockInfoRepository.findById(id)).thenReturn(info);

        // WHEN: getInfo is called with a valid ID
        InfoResponse result = infoService.getInfo(id);

        // THEN: The result should match the mocked Info entity
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Title", result.getTitle());
        assertEquals("Description", result.getDescription());
    }

    @Test
    void testGetInfo_InternalServerError() {
        // GIVEN: Mock repository throws an exception
        String id = "1";
        when(mockInfoRepository.findById(id)).thenThrow(new RuntimeException("Database error"));

        // WHEN: getInfo is called with a valid ID
        InternalServerError exception = assertThrows(InternalServerError.class, () -> {
            infoService.getInfo(id);
        });

        // THEN: Ensure the exception is thrown with the correct cause
        assertEquals("java.lang.RuntimeException: Database error", exception.getCause().toString());
    }

    @Test
    void testUpdateInfo_Success() {
        // GIVEN: Mock repository returning a valid Info entity
        String id = "1";
        Info existingInfo = new Info();
        existingInfo.setId(id);
        existingInfo.setTitle("Old Title");
        existingInfo.setDescription("Old Description");

        Info updatedInfo = new Info();
        updatedInfo.setId(id);
        updatedInfo.setTitle("New Title");
        updatedInfo.setDescription("New Description");

        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("New Title");
        infoRequest.setDescription("New Description");

        when(mockInfoRepository.findById(id)).thenReturn(existingInfo);
        when(mockInfoRepository.insert(any(Info.class))).thenReturn(updatedInfo);

        // WHEN: updateInfo is called with a valid ID and request
        InfoResponse result = infoService.updateInfo(id, infoRequest);

        // THEN: The result should match the updated Info entity
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("New Title", result.getTitle());
        assertEquals("New Description", result.getDescription());
    }

    @Test
    void testUpdateInfo_BadRequest() {
        // GIVEN: Mock repository throws an exception when finding Info
        String id = "1";
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("New Title");
        infoRequest.setDescription("New Description");

        when(mockInfoRepository.findById(id)).thenThrow(new RuntimeException("Not found"));

        // WHEN: updateInfo is called with an invalid ID
        BadRequest exception = assertThrows(BadRequest.class, () -> {
            infoService.updateInfo(id, infoRequest);
        });

        // THEN: Ensure the exception is thrown
        assertNotNull(exception);
    }

    @Test
    void testGenerateInfo_Success() {
        // GIVEN: Mock repository inserting a new Info entity
        String newId = "3";
        Info newInfo = new Info();
        newInfo.setId(newId);
        newInfo.setTitle("Title");
        newInfo.setDescription("Description");

        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Title");
        infoRequest.setDescription("Description");

        when(mockInfoRepository.newId()).thenReturn(newId);
        when(mockInfoRepository.insert(any(Info.class))).thenReturn(newInfo);

        // WHEN: generateInfo is called with a valid request
        InfoResponse result = infoService.generateInfo(infoRequest);

        // THEN: The result should match the newly created Info entity
        assertNotNull(result);
        assertEquals(newId, result.getId());
        assertEquals("Title", result.getTitle());
        assertEquals("Description", result.getDescription());
    }



    @Test
    void testDeleteInfo_Success() {
        // GIVEN: A valid ID for deletion
        String id = "1";

        // WHEN: deleteInfo is called
        infoService.deleteInfo(id);

        // THEN: Verify that the repository's removeById method was called
        verify(mockInfoRepository, times(1)).removeById(id);
    }

    @Test
    void testDeleteInfo_InternalServerError() {
        // GIVEN: Mock repository throws an exception
        String id = "1";
        doThrow(new RuntimeException("Database error")).when(mockInfoRepository).removeById(id);

        // WHEN: deleteInfo is called with a valid ID
        InternalServerError exception = assertThrows(InternalServerError.class, () -> {
            infoService.deleteInfo(id);
        });

        // THEN: Ensure the exception is thrown with the correct cause
        assertEquals("java.lang.RuntimeException: Database error", exception.getCause().toString());
    }
}

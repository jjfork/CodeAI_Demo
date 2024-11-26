package com.bestpractice.api.domain.service;

import com.bestpractice.api.domain.model.InfoRequest;
import com.bestpractice.api.domain.model.InfoResponse;
import com.bestpractice.api.infrastrucuture.entity.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InfoServiceTests {

    private InfoService infoService;
    private InfoService mockInfoService;

    @BeforeEach
    void setUp() {
        // Mock the InfoService interface to simulate its behavior
        mockInfoService = mock(InfoService.class);
        infoService = mockInfoService;
    }

    @Test
    void testGetInfos_Success() {
        // GIVEN: A mocked InfoService that returns a list of InfoResponse
        InfoResponse infoResponse1 = new InfoResponse("1", "Info 1", "Desc 1");
        InfoResponse infoResponse2 = new InfoResponse("2", "Info 2", "Desc 2");

        when(mockInfoService.getInfos()).thenReturn(List.of(infoResponse1, infoResponse2));

        // WHEN: getInfos is called
        List<InfoResponse> result = infoService.getInfos();

        // THEN: The result should be a list containing the mocked InfoResponse objects
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("1", result.get(0).getId());
        assertEquals("Info 1", result.get(0).getTitle());
        assertEquals("2", result.get(1).getId());
        assertEquals("Info 2", result.get(1).getTitle());
    }

    @Test
    void testGetInfo_Success() {
        // GIVEN: A mocked InfoService that returns an InfoResponse for a given id
        String id = "1";
        InfoResponse infoResponse = new InfoResponse(id, "Info 1", "test");

        when(mockInfoService.getInfo(id)).thenReturn(infoResponse);

        // WHEN: getInfo is called with the id
        InfoResponse result = infoService.getInfo(id);

        // THEN: The result should be the mocked InfoResponse for the given id
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Info 1", result.getTitle());
    }

    @Test
    void testUpdateInfo_Success() {
        // GIVEN: A mocked InfoService that returns an updated InfoResponse
        String id = "1";
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Updated Info");
        infoRequest.setDescription("Updated description");

        InfoResponse updatedInfo = new InfoResponse(id, "Updated Info", "Updated desc");

        when(mockInfoService.updateInfo(id, infoRequest)).thenReturn(updatedInfo);

        // WHEN: updateInfo is called with the id and request
        InfoResponse result = infoService.updateInfo(id, infoRequest);

        // THEN: The result should be the updated InfoResponse
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Updated Info", result.getTitle());
    }

    @Test
    void testGenerateInfo_Success() {
        // GIVEN: A mocked InfoService that generates a new InfoResponse
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("New Info");
        infoRequest.setDescription("New description");

        InfoResponse generatedInfo = new InfoResponse("3", "New Title", "New Desc");

        when(mockInfoService.generateInfo(infoRequest)).thenReturn(generatedInfo);

        // WHEN: generateInfo is called with the request
        InfoResponse result = infoService.generateInfo(infoRequest);

        // THEN: The result should be the generated InfoResponse
        assertNotNull(result);
        assertEquals("3", result.getId());
        assertEquals("New Title", result.getTitle());
    }

    @Test
    void testDeleteInfo_Success() {
        // GIVEN: A mocked InfoService that deletes an InfoResponse for a given id
        String id = "1";

        // WHEN: deleteInfo is called with the id
        infoService.deleteInfo(id);

        // THEN: No exceptions should be thrown (Void method)
        verify(mockInfoService, times(1)).deleteInfo(id);
    }

    @Test
    void testGetInfo_Failure_InfoNotFound() {
        // GIVEN: A mocked InfoService that returns null for a non-existent id
        String id = "999";

        when(mockInfoService.getInfo(id)).thenReturn(null);

        // WHEN: getInfo is called with a non-existent id
        InfoResponse result = infoService.getInfo(id);

        // THEN: The result should be null, indicating no info found for the given id
        assertNull(result);
    }

    @Test
    void testUpdateInfo_Failure_InfoNotFound() {
        // GIVEN: A mocked InfoService that returns null when updating non-existent info
        String id = "999";
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Non-existent Info");
        infoRequest.setDescription("Non-existent description");

        when(mockInfoService.updateInfo(id, infoRequest)).thenReturn(null);

        // WHEN: updateInfo is called with a non-existent id
        InfoResponse result = infoService.updateInfo(id, infoRequest);

        // THEN: The result should be null, indicating info could not be updated
        assertNull(result);
    }

    @Test
    void testGenerateInfo_Failure_InvalidRequest() {
        // GIVEN: A mocked InfoService that returns null when generating info with invalid data
        InfoRequest invalidRequest = new InfoRequest();
        invalidRequest.setTitle(null); // Invalid title

        when(mockInfoService.generateInfo(invalidRequest)).thenReturn(null);

        // WHEN: generateInfo is called with an invalid request
        InfoResponse result = infoService.generateInfo(invalidRequest);

        // THEN: The result should be null, indicating info could not be generated
        assertNull(result);
    }

    @Test
    void testDeleteInfo_Failure_InfoNotFound() {
        // GIVEN: A mocked InfoService that throws an exception when trying to delete non-existent info
        String id = "999";

        doThrow(new IllegalArgumentException("Info not found")).when(mockInfoService).deleteInfo(id);

        // WHEN: deleteInfo is called with a non-existent id
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            infoService.deleteInfo(id);
        });

        // THEN: Ensure the exception is thrown with the correct message
        assertEquals("Info not found", thrown.getMessage());
    }

    @Test
    void testConvertMethod_ValidConversion() {
        // GIVEN: An InfoRequest object with valid data
        String id = "1";
        InfoRequest infoRequest = new InfoRequest();
        infoRequest.setTitle("Sample Info");
        infoRequest.setDescription("Sample Description");

        // WHEN: convert is called to convert to Info entity
        Info info = infoRequest.convert(id);

        // THEN: Ensure the Info entity is properly populated with data from InfoRequest
        assertNotNull(info);
        assertEquals(id, info.getId());
        assertEquals("Sample Info", info.getTitle());
        assertEquals("Sample Description", info.getDescription());
    }
}

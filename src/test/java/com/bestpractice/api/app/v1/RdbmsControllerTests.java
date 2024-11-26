package com.bestpractice.api.app.v1;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.InternalServerError;
import com.bestpractice.api.domain.model.InfoRequest;
import com.bestpractice.api.domain.model.InfoResponse;
import com.bestpractice.api.domain.service.InfoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RdbmsControllerTests {

    @Mock
    private InfoServiceImpl infoService;

    @InjectMocks
    private RdbmsController rdbmsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetInfos() {
        // GIVEN: Mocked list of responses
        List<InfoResponse> mockResponses = List.of(new InfoResponse("1", "Title", "Description"));
        when(infoService.getInfos()).thenReturn(mockResponses);

        // WHEN: The getInfos method is called
        List<InfoResponse> result = rdbmsController.getInfos();

        // THEN: Verify the expected responses
        assertNotNull(result);
        assertEquals(mockResponses.size(), result.size());
        verify(infoService, times(1)).getInfos();
    }

    @Test
    void testGetInfo() {
        // GIVEN: A valid ID and a mocked response
        String id = "123";
        InfoResponse mockResponse = new InfoResponse("123", "Title", "Description");
        when(infoService.getInfo(id)).thenReturn(mockResponse);

        // WHEN: The getInfo method is called
        InfoResponse result = rdbmsController.getInfo(id);

        // THEN: Verify the expected response
        assertNotNull(result);
        assertEquals(mockResponse, result);
        verify(infoService, times(1)).getInfo(id);
    }

    @Test
    void testGetInfoThrowsInternalServerError() {
        // GIVEN: A valid ID that triggers an InternalServerError
        String id = "123";
        when(infoService.getInfo(id)).thenThrow(new InternalServerError("Database Error"));

        // WHEN: The getInfo method is called
        Exception exception = assertThrows(InternalServerError.class, () -> rdbmsController.getInfo(id));

        // THEN: Verify exception message
        assertEquals("Database Error", exception.getMessage());
        verify(infoService, times(1)).getInfo(id);
    }

    @Test
    void testPostInfo() throws URISyntaxException {
        // GIVEN: A valid InfoRequest and a mocked InfoResponse
        InfoRequest req = new InfoRequest();
        req.setTitle("Title");
        req.setDescription("Description");

        InfoResponse mockResponse = new InfoResponse("123", "Title", "Description");
        when(infoService.generateInfo(req)).thenReturn(mockResponse);

        // WHEN: The postInfo method is called
        ResponseEntity<InfoResponse> response = rdbmsController.postInfo(req);

        // THEN: Verify the response and HTTP status
        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
        verify(infoService, times(1)).generateInfo(req);
    }

    @Test
    void testPostInfoThrowsConflict() {
        // GIVEN: A valid InfoRequest that triggers a Conflict exception
        InfoRequest req = new InfoRequest();
        req.setTitle("Duplicate Title");
        req.setDescription("Description");

        when(infoService.generateInfo(req)).thenThrow(new Conflict("Conflict Error"));

        // WHEN: The postInfo method is called
        Exception exception = assertThrows(Conflict.class, () -> rdbmsController.postInfo(req));

        // THEN: Verify exception message
        assertEquals("Conflict Error", exception.getMessage());
        verify(infoService, times(1)).generateInfo(req);
    }

    @Test
    void testPutInfo() {
        // GIVEN: A valid ID, InfoRequest, and mocked InfoResponse
        String id = "123";
        InfoRequest req = new InfoRequest();
        req.setTitle("Updated Title");
        req.setDescription("Updated Description");

        InfoResponse mockResponse = new InfoResponse("123", "Updated Title", "Updated Description");
        when(infoService.updateInfo(id, req)).thenReturn(mockResponse);

        // WHEN: The putInfo method is called
        InfoResponse result = rdbmsController.putInfo(id, req);

        // THEN: Verify the expected response
        assertNotNull(result);
        assertEquals(mockResponse, result);
        verify(infoService, times(1)).updateInfo(id, req);
    }

    @Test
    void testDeleteInfo() {
        // GIVEN: A valid ID
        String id = "123";
        doNothing().when(infoService).deleteInfo(id);

        // WHEN: The deleteInfo method is called
        Map<String, String> result = rdbmsController.deleteInfo(id);

        // THEN: Verify the response and behavior
        assertNotNull(result);
        assertEquals("ok", result.get("message"));
        verify(infoService, times(1)).deleteInfo(id);
    }

    @Test
    void testDeleteInfoThrowsInternalServerError() {
        // GIVEN: A valid ID that triggers an InternalServerError
        String id = "123";
        doThrow(new InternalServerError("Error during delete")).when(infoService).deleteInfo(id);

        // WHEN: The deleteInfo method is called
        Exception exception = assertThrows(InternalServerError.class, () -> rdbmsController.deleteInfo(id));

        // THEN: Verify exception message
        assertEquals("Error during delete", exception.getMessage());
        verify(infoService, times(1)).deleteInfo(id);
    }
}

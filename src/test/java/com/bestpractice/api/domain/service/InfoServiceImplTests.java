package com.bestpractice.api.domain.service;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import com.bestpractice.api.common.exception.BadRequest;
import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.common.exception.InternalServerError;
import com.bestpractice.api.domain.model.InfoRequest;
import com.bestpractice.api.domain.model.InfoResponse;
import com.bestpractice.api.infrastrucuture.entity.Info;
import com.bestpractice.api.infrastrucuture.persistent.InfoPersistentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InfoServiceImplTests {

    @InjectMocks
    private InfoServiceImpl infoServiceImpl;

    @Mock
    private InfoPersistentRepository infoPersistentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetInfos() {
        List<Info> infoEntities = new ArrayList<>();
        infoEntities.add(new Info());
        when(infoPersistentRepository.findAll()).thenReturn(infoEntities);
        List<InfoResponse> infoResponses = infoServiceImpl.getInfos();
        assertEquals(1, infoResponses.size());
    }

    @Test
    void testGetInfo() {
        Info info = new Info();
        info.setId("id");
        when(infoPersistentRepository.findById("id")).thenReturn(info);
        InfoResponse infoResponse = infoServiceImpl.getInfo("id");
        assertEquals("id", infoResponse.getId());
    }

    @Test
    void testUpdateInfo() {
        Info info = new Info();
        info.setId("id");
        InfoRequest req = new InfoRequest();
        when(infoPersistentRepository.findById("id")).thenReturn(info);
        when(infoPersistentRepository.insert(any(Info.class))).thenReturn(info);
        InfoResponse infoResponse = infoServiceImpl.updateInfo("id", req);
        assertEquals("id", infoResponse.getId());
    }

    @Test
    void testGenerateInfo() {
        InfoRequest request = new InfoRequest();
        Info info = new Info();
        when(infoPersistentRepository.insert(any(Info.class))).thenReturn(info);
        InfoResponse infoResponse = infoServiceImpl.generateInfo(request);
        assertEquals(info.getId(), infoResponse.getId());
    }

    @Test
    void testDeleteInfo() {
        infoServiceImpl.deleteInfo("id");
        verify(infoPersistentRepository, times(1)).removeById("id");
    }
}

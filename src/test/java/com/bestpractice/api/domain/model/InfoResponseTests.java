package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

public class InfoResponseTests {

    @Test
    void testInfoResponseConstructor() {
        String id = "testId";
        String title = "testTitle";
        String description = "testDescription";

        InfoResponse infoResponse = new InfoResponse(id, title, description);

        assert infoResponse.getId().equals(id);
        assert infoResponse.getTitle().equals(title);
        assert infoResponse.getDescription().equals(description);
    }
}

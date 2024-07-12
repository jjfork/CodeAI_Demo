package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthByRefreshTokenRequestTests {

    @Test
    void testGetRefreshToken() {
        AuthByRefreshTokenRequest request = new AuthByRefreshTokenRequest();
        request.setRefreshToken("test-refresh-token");
        assertEquals("test-refresh-token", request.getRefreshToken());
    }

    @Test
    void testSetRefreshToken() {
        AuthByRefreshTokenRequest request = Mockito.mock(AuthByRefreshTokenRequest.class);
        request.setRefreshToken("test-refresh-token");
        Mockito.verify(request, Mockito.times(1)).setRefreshToken("test-refresh-token");
    }
}

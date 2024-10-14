package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CredentialTests {

    private String token;
    private String tokenType;
    private Date exp;
    private boolean isRefresh;

    @BeforeEach
    void setUp() {
        token = "token";
        tokenType = "tokenType";
        exp = new Date();
        isRefresh = true;
    }

    @Test
    void testGetToken() {
        Credential credential = new Credential(token, tokenType, exp, isRefresh);
        assertEquals(token, credential.getToken());
    }

    @Test
    void testGetTokenType() {
        Credential credential = new Credential(token, tokenType, exp, isRefresh);
        assertEquals(tokenType, credential.getTokenType());
    }

    @Test
    void testGetExp() {
        Credential credential = new Credential(token, tokenType, exp, isRefresh);
        assertEquals(exp, credential.getExp());
    }

    @Test
    void testIsRefresh() {
        Credential credential = new Credential(token, tokenType, exp, isRefresh);
        assertTrue(credential.isRefresh());
    }
}

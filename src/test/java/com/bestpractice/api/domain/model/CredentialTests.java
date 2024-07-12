package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class CredentialTests {

    @Test
    void getToken() {
        Credential credential = new Credential("testToken", "Bearer", new Date(), true);
        assertEquals("testToken", credential.getToken());
    }

    @Test
    void getTokenType() {
        Credential credential = new Credential("testToken", "Bearer", new Date(), true);
        assertEquals("Bearer", credential.getTokenType());
    }

    @Test
    void getExp() {
        Date expDate = new Date();
        Credential credential = new Credential("testToken", "Bearer", expDate, true);
        assertEquals(expDate, credential.getExp());
    }

    @Test
    void isRefresh() {
        Credential credential = new Credential("testToken", "Bearer", new Date(), true);
        assertTrue(credential.isRefresh());
    }
}

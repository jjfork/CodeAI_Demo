package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CredentialTests {
    private String token = "testToken";
    private String tokenType = "Bearer";
    private Date exp = new Date();
    private boolean isRefresh = true;
    private Credential credential;

    @BeforeEach
    void setUp() {
        credential = new Credential(token, tokenType, exp, isRefresh);
    }

    @Test
    void testGetToken() {
        // GIVEN - A Credential object has been created.
        // WHEN - The getToken method is called on the credential object.
        String retrievedToken = credential.getToken();
        // THEN - The retrieved token should be equal to the token used in the constructor.
        assertEquals(token, retrievedToken);
    }

    @Test
    void testGetTokenType() {
        // GIVEN - A Credential object has been created.
        // WHEN - The getTokenType method is called on the credential object.
        String retrievedTokenType = credential.getTokenType();
        // THEN - The retrieved token type should be equal to the tokenType used in the constructor.
        assertEquals(tokenType, retrievedTokenType);
    }

    @Test
    void testGetExp() {
        // GIVEN - A Credential object has been created.
        // WHEN - The getExp method is called on the credential object.
        Date retrievedExp = credential.getExp();
        // THEN - The retrieved expiration date should be equal to the exp used in the constructor.
        assertEquals(exp, retrievedExp);
    }

    @Test
    void testIsRefresh() {
        // GIVEN - A Credential object has been created.
        // WHEN - The isRefresh method is called on the credential object.
        boolean retrievedIsRefresh = credential.isRefresh();
        // THEN - The retrieved refresh status should be equal to the isRefresh used in the constructor.
        assertEquals(isRefresh, retrievedIsRefresh);
    }
}

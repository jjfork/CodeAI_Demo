package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

class CredentialTests {

    private String token;
    private String tokenType;
    private Date exp;
    private boolean isRefresh;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize common test data for each test case.
        token = "sampleToken";
        tokenType = "Bearer";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Set expiration to one day from now.
        exp = calendar.getTime();
        isRefresh = false;
    }

    @Test
    void getToken_returnsCorrectToken() {
        // GIVEN: A Credential object with a known token value.
        Credential credential = new Credential(token, tokenType, exp, isRefresh);

        // WHEN: Retrieving the token from the Credential object.
        String retrievedToken = credential.getToken();

        // THEN: The retrieved token should match the expected token.
        assertEquals("sampleToken", retrievedToken);
    }

    @Test
    void getTokenType_returnsCorrectTokenType() {
        // GIVEN: A Credential object with a known token type value.
        Credential credential = new Credential(token, tokenType, exp, isRefresh);

        // WHEN: Retrieving the token type from the Credential object.
        String retrievedTokenType = credential.getTokenType();

        // THEN: The retrieved token type should match the expected token type.
        assertEquals("Bearer", retrievedTokenType);
    }

    @Test
    void getExp_returnsCorrectExpirationDate() {
        // GIVEN: A Credential object with a known expiration date set to one day from now.
        Credential credential = new Credential(token, tokenType, exp, isRefresh);

        // WHEN: Retrieving the expiration date from the Credential object.
        Date retrievedExp = credential.getExp();

        // THEN: The retrieved expiration date should match the expected expiration date.
        assertEquals(exp, retrievedExp);
    }

    @Test
    void isRefresh_returnsCorrectIsRefreshValue() {
        // GIVEN: A Credential object with a known refresh flag set to false.
        Credential credential = new Credential(token, tokenType, exp, isRefresh);

        // WHEN: Checking the refresh status of the Credential object.
        boolean retrievedIsRefresh = credential.isRefresh();

        // THEN: The retrieved refresh status should match the expected value.
        assertFalse(retrievedIsRefresh);
    }

    @Test
    void testCredentialWithDifferentValues() {
        // GIVEN: A Credential object with different values for testing flexibility.
        String newToken = "newSampleToken";
        String newTokenType = "OAuth2";
        Calendar newExpCalendar = Calendar.getInstance();
        newExpCalendar.add(Calendar.DAY_OF_YEAR, 7); // Set expiration to one week from now.
        Date newExp = newExpCalendar.getTime();
        boolean newIsRefresh = true;

        Credential credential = new Credential(newToken, newTokenType, newExp, newIsRefresh);

        // WHEN: Retrieving values from the Credential object with different inputs.
        String retrievedToken = credential.getToken();
        String retrievedTokenType = credential.getTokenType();
        Date retrievedExp = credential.getExp();
        boolean retrievedIsRefresh = credential.isRefresh();

        // THEN: The retrieved values should match the new expected values.
        assertEquals("newSampleToken", retrievedToken);
        assertEquals("OAuth2", retrievedTokenType);
        assertEquals(newExp, retrievedExp);
        assertTrue(retrievedIsRefresh);
    }
}

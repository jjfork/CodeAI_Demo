package com.bestpractice.api.common.property;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CredentialPropertyTests {


    private CredentialProperty credentialProperty;

    @BeforeEach
    void setUp() {
        // Reset the CredentialProperty instance before each test
        credentialProperty = new CredentialProperty();
    }

    @Test
    void givenValidValue_whenSetKeyAndGetKey_thenReturnCorrectValue() {
        // GIVEN: A valid key value
        String key = "test-key";

        // WHEN: Setting the key in CredentialProperty
        credentialProperty.setKey(key);

        // THEN: The getKey method should return the correct value
        assertEquals(key, credentialProperty.getKey(), "The returned key should match the set value");
    }

    @Test
    void givenValidValue_whenSetProviderAndGetProvider_thenReturnCorrectValue() {
        // GIVEN: A valid provider value
        String provider = "test-provider";

        // WHEN: Setting the provider in CredentialProperty
        credentialProperty.setProvider(provider);

        // THEN: The getProvider method should return the correct value
        assertEquals(provider, credentialProperty.getProvider(), "The returned provider should match the set value");
    }

    @Test
    void givenValidValue_whenSetSubjectAndGetSubject_thenReturnCorrectValue() {
        // GIVEN: A valid subject value
        String subject = "test-subject";

        // WHEN: Setting the subject in CredentialProperty
        credentialProperty.setSubject(subject);

        // THEN: The getSubject method should return the correct value
        assertEquals(subject, credentialProperty.getSubject(), "The returned subject should match the set value");
    }

    @Test
    void givenValidValue_whenSetAlgAndGetAlg_thenReturnCorrectValue() {
        // GIVEN: A valid alg value
        String alg = "HS256";

        // WHEN: Setting the alg in CredentialProperty
        credentialProperty.setAlg(alg);

        // THEN: The getAlg method should return the correct value
        assertEquals(alg, credentialProperty.getAlg(), "The returned alg should match the set value");
    }

    @Test
    void givenValidValue_whenSetHmacSecretAndGetHmacSecret_thenReturnCorrectValue() {
        // GIVEN: A valid HMAC secret value
        String hmacSecret = "secret";

        // WHEN: Setting the hmacSecret in CredentialProperty
        credentialProperty.setHmacSecret(hmacSecret);

        // THEN: The getHmacSecret method should return the correct value
        assertEquals(hmacSecret, credentialProperty.getHmacSecret(), "The returned HMAC secret should match the set value");
    }

    @Test
    void givenValidValue_whenSetExpiresHourStrAndGetExpiresHourStr_thenReturnCorrectValue() {
        // GIVEN: A valid expiresHourStr value
        String expiresHourStr = "24";

        // WHEN: Setting the expiresHourStr in CredentialProperty
        credentialProperty.setExpiresHourStr(expiresHourStr);

        // THEN: The getExpiresHourStr method should return the correct value
        assertEquals(expiresHourStr, credentialProperty.getExpiresHourStr(), "The returned expiresHourStr should match the set value");
    }

    @Test
    void givenValidExpiresHourStr_whenConvertToIntExpires_thenReturnParsedInteger() {
        // GIVEN: A valid expiresHourStr value that can be parsed to an integer
        String expiresHourStr = "12";
        credentialProperty.setExpiresHourStr(expiresHourStr);

        // WHEN: Calling convertToIntExpires
        Integer expires = credentialProperty.convertToIntExpires();

        // THEN: The returned value should match the parsed integer
        assertEquals(12, expires, "The returned value should be the parsed integer");
    }

    @Test
    void givenInvalidExpiresHourStr_whenConvertToIntExpires_thenReturnNull() {
        // GIVEN: An invalid expiresHourStr value that cannot be parsed to an integer
        String expiresHourStr = "invalid";
        credentialProperty.setExpiresHourStr(expiresHourStr);

        // WHEN: Calling convertToIntExpires
        Integer expires = credentialProperty.convertToIntExpires();

        // THEN: The returned value should be null
        assertNull(expires, "The returned value should be null for invalid input");
    }

    @Test
    void givenSpecialExpiresHourStr_whenConvertToIntExpires_thenReturnNull() {
        // GIVEN: A special expiresHourStr value "-"
        String expiresHourStr = "-";
        credentialProperty.setExpiresHourStr(expiresHourStr);

        // WHEN: Calling convertToIntExpires
        Integer expires = credentialProperty.convertToIntExpires();

        // THEN: The returned value should be null
        assertNull(expires, "The returned value should be null for the special '-' input");
    }
}
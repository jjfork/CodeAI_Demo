package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BCryptPasswordEncryptionComponentTests {

    private BCryptPasswordEncryptionComponent passwordEncryptionComponent;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize the component before each test to ensure a clean state.
        passwordEncryptionComponent = new BCryptPasswordEncryptionComponent();
    }

    @Test
    void encodePassword_shouldEncodeRawPasswordCorrectly() {
        // GIVEN: A raw password that needs encoding.
        String rawPassword = "password123";

        // WHEN: Encoding the raw password using the component.
        String encodedPassword = passwordEncryptionComponent.encodePassword(rawPassword);

        // THEN: The encoded password should not be null and should differ from the raw password.
        assertNotNull(encodedPassword, "Encoded password should not be null");
        assertNotEquals(rawPassword, encodedPassword, "Encoded password should differ from the raw password");
    }

    @Test
    void matchedPassword_shouldReturnTrueForMatchingPasswords() {
        // GIVEN: A raw password and its corresponding encoded version.
        String rawPassword = "password123";
        String encodedPassword = passwordEncryptionComponent.encodePassword(rawPassword);

        // WHEN: Checking if the raw password matches the encoded one.
        boolean isMatched = passwordEncryptionComponent.matchedPassword(rawPassword, encodedPassword);

        // THEN: The method should return true for matching passwords.
        assertTrue(isMatched, "Passwords should match");
    }

    @Test
    void matchedPassword_shouldReturnFalseForNonMatchingPasswords() {
        // GIVEN: A raw password and a different encoded version of another password.
        String rawPassword = "password123";
        String wrongEncodedPassword = "$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92.0JQF1Czr5G3V6L4fOy";

        // WHEN: Checking if the raw password matches the wrong encoded one.
        boolean isMatched = passwordEncryptionComponent.matchedPassword(rawPassword, wrongEncodedPassword);

        // THEN: The method should return false for non-matching passwords.
        assertFalse(isMatched, "Passwords should not match");
    }

    @Test
    void encodePassword_shouldHandleEmptyString() {
        // GIVEN: An empty string as the raw password.
        String rawPassword = "";

        // WHEN: Encoding the empty string using the component.
        String encodedPassword = passwordEncryptionComponent.encodePassword(rawPassword);

        // THEN: The encoded password should not be null and should differ from the input.
        assertNotNull(encodedPassword, "Encoded password for an empty string should not be null");
        assertNotEquals(rawPassword, encodedPassword, "Encoded password should differ from the raw password even if it's empty");
    }

    @Test
    void matchedPassword_shouldHandleEmptyStrings() {
        // GIVEN: An empty raw password and its corresponding encoded version.
        String rawPassword = "";
        String encodedPassword = passwordEncryptionComponent.encodePassword(rawPassword);

        // WHEN: Checking if the empty raw password matches the encoded one.
        boolean isMatched = passwordEncryptionComponent.matchedPassword(rawPassword, encodedPassword);

        // THEN: The method should return true for matching empty strings.
        assertTrue(isMatched, "Empty passwords should match");
    }
}

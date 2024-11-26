package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AuthByEmailRequestTests {

    private AuthByEmailRequest authByEmailRequest;

    @BeforeEach
    void setUp() {
        authByEmailRequest = new AuthByEmailRequest();
    }

    @Test
    void givenValidEmail_whenSetEmail_thenGetEmailReturnsSameValue() {
        // GIVEN: A valid email
        String email = "test@example.com";

        // WHEN: Setting the email
        authByEmailRequest.setEmail(email);

        // THEN: The getEmail method should return the same email
        assertEquals(email, authByEmailRequest.getEmail(), "getEmail should return the set email");
    }

    @Test
    void givenNullEmail_whenSetEmail_thenGetEmailReturnsNull() {
        // GIVEN: A null email
        String email = null;

        // WHEN: Setting the email
        authByEmailRequest.setEmail(email);

        // THEN: The getEmail method should return null
        assertNull(authByEmailRequest.getEmail(), "getEmail should return null when email is not set");
    }

    @Test
    void givenValidPassword_whenSetPassword_thenGetPasswordReturnsSameValue() {
        // GIVEN: A valid password
        String password = "SecurePassword123";

        // WHEN: Setting the password
        authByEmailRequest.setPassword(password);

        // THEN: The getPassword method should return the same password
        assertEquals(password, authByEmailRequest.getPassword(), "getPassword should return the set password");
    }

    @Test
    void givenNullPassword_whenSetPassword_thenGetPasswordReturnsNull() {
        // GIVEN: A null password
        String password = null;

        // WHEN: Setting the password
        authByEmailRequest.setPassword(password);

        // THEN: The getPassword method should return null
        assertNull(authByEmailRequest.getPassword(), "getPassword should return null when password is not set");
    }

    @Test
    void givenInvalidEmailFormat_whenSetEmail_thenAnnotationEnforcementIsExpected() {
        // GIVEN: An invalid email format
        String invalidEmail = "invalid-email-format";

        // WHEN: Checking if the annotation enforces validation
        authByEmailRequest.setEmail(invalidEmail);

        // THEN: Email validation occurs through annotations (manual validation is expected elsewhere)
        assertEquals(invalidEmail, authByEmailRequest.getEmail(), "The email field still holds the invalid value");
    }

    @Test
    void givenValidEmailAndPassword_whenSetFields_thenBothReturnCorrectValues() {
        // GIVEN: Valid email and password
        String email = "user@example.com";
        String password = "StrongPassword123";

        // WHEN: Setting both fields
        authByEmailRequest.setEmail(email);
        authByEmailRequest.setPassword(password);

        // THEN: Both getters return the correct values
        assertEquals(email, authByEmailRequest.getEmail(), "getEmail should return the set email");
        assertEquals(password, authByEmailRequest.getPassword(), "getPassword should return the set password");
    }
}
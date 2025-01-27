package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.junit.jupiter.api.Assertions.*;

class AuthByEmailRequestTests {

    private AuthByEmailRequest authByEmailRequest;
    private Validator validator;

    @BeforeEach
    void setUp() {
        authByEmailRequest = new AuthByEmailRequest();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testGetEmail() {
        String expectedEmail = "test@example.com";
        authByEmailRequest.setEmail(expectedEmail);
        assertEquals(expectedEmail, authByEmailRequest.getEmail());
    }

    @Test
    void testSetAndGetEmail() {
        String validEmail = "user@example.com";
        authByEmailRequest.setEmail(validEmail);
        assertEquals(validEmail, authByEmailRequest.getEmail());
    }

    @Test
    void testSetInvalidEmail() {
        String invalidEmail = "invalid-email";
        authByEmailRequest.setEmail(invalidEmail);
        var violations = validator.validate(authByEmailRequest);
        assertFalse(violations.isEmpty(), "Expected validation errors for invalid email");
    }

    @Test
    void testSetPassword() {
        String validPassword = "password123";
        authByEmailRequest.setPassword(validPassword);
        assertEquals(validPassword, authByEmailRequest.getPassword());
    }

    @Test
    void testSetNullPassword() {
        authByEmailRequest.setPassword(null);
        var violations = validator.validate(authByEmailRequest);
        assertFalse(violations.isEmpty(), "Expected validation errors for null password");
    }
}

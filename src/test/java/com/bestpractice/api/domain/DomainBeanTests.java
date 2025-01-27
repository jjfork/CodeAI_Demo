package com.bestpractice.api.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.security.crypto.password.PasswordEncoder;

class DomainBeanTests {

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        // GIVEN: Initialize the DomainBean to get a PasswordEncoder instance.
        DomainBean domainBean = new DomainBean();
        this.passwordEncoder = domainBean.passwordEncoder();
    }

    @Test
    void testPasswordEncoderIsNotNull() {
        // WHEN: Retrieve the password encoder from the bean.
        
        // THEN: Verify that the password encoder is not null.
        assertNotNull(passwordEncoder, "Password encoder should be initialized and not null.");
    }

    @Test
    void testEncodeAndMatchesMethod() {
        // GIVEN: A sample plain text password to encode.
        String rawPassword = "password123";

        // WHEN: Encode the password using the password encoder.
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // THEN: Verify that the encoded password is not null and matches the original password when checked.
        assertNotNull(encodedPassword, "Encoded password should not be null.");
        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword), 
                   "The encoded password should match the raw password.");
    }
}

package com.bestpractice.api.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DomainBeanTests {
    @Autowired
    private DomainBean domainBean;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testPasswordEncoder() {
        // GIVEN - The DomainBean is initialized.
        // WHEN - The passwordEncoder bean is retrieved.
        org.springframework.security.crypto.password.PasswordEncoder encoder = domainBean.getPasswordEncoder();
        // THEN - The returned object should be an instance of BCryptPasswordEncoder.
        assertTrue(encoder instanceof org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder);
    }
}
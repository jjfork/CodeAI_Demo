package com.bestpractice.api.domain;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainBeanTests {

    private DomainBean domainBean;

    @BeforeEach
    void setUp() {
        domainBean = new DomainBean();
    }

    @Test
    void testPasswordEncoder() {
        org.springframework.security.crypto.password.PasswordEncoder passwordEncoder = domainBean.passwordEncoder();
        assertEquals(BCryptPasswordEncoder.class, passwordEncoder.getClass());
    }
}

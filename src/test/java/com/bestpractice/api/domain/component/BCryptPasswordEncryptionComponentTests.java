package com.bestpractice.api.domain.component;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BCryptPasswordEncryptionComponentTests {

    @InjectMocks
    private BCryptPasswordEncryptionComponent bCryptPasswordEncryptionComponent;

    @Test
    void testEncodePassword() {
        String rawPassword = "password";
        String encryptedPassword = bCryptPasswordEncryptionComponent.encodePassword(rawPassword);
        assertEquals(encryptedPassword.length(), 60); // Check the length of the encrypted password
    }

    @Test
    void testMatchedPassword() {
        String rawPassword = "password";
        String encryptedPassword = bCryptPasswordEncryptionComponent.encodePassword(rawPassword);
        assertTrue(bCryptPasswordEncryptionComponent.matchedPassword(rawPassword, encryptedPassword)); // Check if the raw and encrypted passwords match
    }
}

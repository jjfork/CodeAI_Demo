package com.bestpractice.api.domain.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

public class UserResponseTests {

    @Test
    void testUserResponseConstructor() {
        String id = "testId";
        String username = "testUsername";
        String email = "testEmail";

        UserResponse userResponse = new UserResponse(id, username, email);

        assert userResponse.getId().equals(id);
        assert userResponse.getUsername().equals(username);
        assert userResponse.getEmail().equals(email);
    }

    @Test
    void testGetId() {
        String id = "testId";
        String username = "testUsername";
        String email = "testEmail";

        UserResponse userResponse = new UserResponse(id, username, email);

        assert userResponse.getId().equals(id);
    }

    @Test
    void testGetUsername() {
        String id = "testId";
        String username = "testUsername";
        String email = "testEmail";

        UserResponse userResponse = new UserResponse(id, username, email);

        assert userResponse.getUsername().equals(username);
    }

    @Test
    void testGetEmail() {
        String id = "testId";
        String username = "testUsername";
        String email = "testEmail";

        UserResponse userResponse = new UserResponse(id, username, email);

        assert userResponse.getEmail().equals(email);
    }
}

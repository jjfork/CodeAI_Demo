package com.bestpractice.api.infrastrucuture.persistent.rdbms;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.bestpractice.api.common.exception.Conflict;
import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class RdbmsUserPersistentRepositoryTests {

    @Test
    void newId() {
        // UNKNOWN
    }

    @Test
    void findByEmail() {
        // UNKNOWN
    }

    @Test
    void findById() {
        // UNKNOWN
    }

    @Test
    void insert() {
        // UNKNOWN
    }

    @Test
    void replace() {
        // UNKNOWN
    }

    @Test
    void removeById() {
        // UNKNOWN
    }
}

package com.bestpractice.api.infrastrucuture.persistent.mongo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MongoUserPersistentRepositoryTests {

    @Test
    public void testMain() {
        String nullString = null;
        assertThrows(NullPointerException.class, () -> {
            System.out.println(nullString.toString());
        });
    }
}
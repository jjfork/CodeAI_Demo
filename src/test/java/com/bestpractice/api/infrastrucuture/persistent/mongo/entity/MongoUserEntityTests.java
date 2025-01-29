package com.bestpractice.api.infrastrucuture.persistent.mongo.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MongoUserEntityTests {

    private MongoUserEntity mongoUserEntity;

    @BeforeEach
    void setUp() {
        mongoUserEntity = new MongoUserEntity();
    }

    @Test
    void testConvertFrom() {
        // GIVEN
        User user = new User(new org.bson.types.ObjectId("1"), "testUsername", "testEmail", "testPassword");
        // WHEN
        MongoUserEntity convertedEntity =  user.convertToMongoUserEntity(); 
        // THEN
        assertEquals(user.getId(), convertedEntity.getId());
        assertEquals("testUsername", convertedEntity.getUsername());
        assertEquals("testEmail", convertedEntity.getEmail());
        assertEquals("testPassword", convertedEntity.getPassword());
    }

    @Test
    void testConvertTo() {
        // GIVEN
        mongoUserEntity.setId(new org.bson.types.ObjectId("1"));
        mongoUserEntity.setUsername("testUsername");
        mongoUserEntity.setEmail("testEmail");
        mongoUserEntity.setPassword("testPassword");
        // WHEN
        User convertedUser = mongoUserEntity.convertToUser();
        // THEN
        assertEquals(mongoUserEntity.getId(), convertedUser.getId());
        assertEquals("testUsername", convertedUser.getUsername());
        assertEquals("testEmail", convertedUser.getEmail());
        assertEquals("testPassword", convertedUser.getPassword());
    }

}
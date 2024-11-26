package com.bestpractice.api.infrastrucuture.persistent.mongo.entity;

import com.bestpractice.api.infrastrucuture.entity.User;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MongoUserEntityTests {

    @Test
    void testConstructorAndGetters() {
        // GIVEN: An ObjectId, username, email, and password
        ObjectId id = new ObjectId();
        String username = "testuser";
        String email = "test@example.com";
        String password = "securepassword";

        // WHEN: Creating a MongoUserEntity using the constructor
        MongoUserEntity entity = new MongoUserEntity(id, username, email, password);

        // THEN: The fields should be correctly initialized
        assertEquals(id, entity.getId());
        assertEquals(username, entity.getUsername());
        assertEquals(email, entity.getEmail());
        assertEquals(password, entity.getPassword());
    }

    @Test
    void testDefaultConstructorAndSetters() {
        // GIVEN: A MongoUserEntity created using the default constructor
        MongoUserEntity entity = new MongoUserEntity();

        ObjectId id = new ObjectId();
        String username = "newuser";
        String email = "newuser@example.com";
        String password = "newpassword";

        // WHEN: Setting values using setters
        entity.setId(id);
        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(password);

        // THEN: The fields should reflect the set values
        assertEquals(id, entity.getId());
        assertEquals(username, entity.getUsername());
        assertEquals(email, entity.getEmail());
        assertEquals(password, entity.getPassword());
    }

    @Test
    void testConvertFrom() {
        // GIVEN: A User object
        User user = new User();
        user.setId(new ObjectId().toString());
        user.setUsername("sampleuser");
        user.setEmail("sample@example.com");
        user.setPassword("samplepassword");

        // WHEN: Converting User to MongoUserEntity
        MongoUserEntity entity = MongoUserEntity.convertFrom(user);

        // THEN: The fields in MongoUserEntity should match the User object
        assertEquals(new ObjectId(user.getId()), entity.getId());
        assertEquals(user.getUsername(), entity.getUsername());
        assertEquals(user.getEmail(), entity.getEmail());
        assertEquals(user.getPassword(), entity.getPassword());
    }

    @Test
    void testConvertTo() {
        // GIVEN: A MongoUserEntity object
        ObjectId id = new ObjectId();
        String username = "converteduser";
        String email = "converted@example.com";
        String password = "convertedpassword";

        MongoUserEntity entity = new MongoUserEntity(id, username, email, password);

        // WHEN: Converting MongoUserEntity to User
        User user = entity.convertTo();

        // THEN: The fields in User should match the MongoUserEntity object
        assertEquals(id.toString(), user.getId());
        assertEquals(username, user.getUsername());
        assertNull(user.getEmail()); // Email is not set in convertTo()
        assertEquals(password, user.getPassword());
    }
}

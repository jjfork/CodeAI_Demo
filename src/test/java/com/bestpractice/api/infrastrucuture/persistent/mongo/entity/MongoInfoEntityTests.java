package com.bestpractice.api.infrastrucuture.persistent.mongo.entity;

import com.bestpractice.api.infrastrucuture.entity.Info;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MongoInfoEntityTests {

    @Test
    void testConstructorAndGetters() {
        // GIVEN: An ObjectId, title, and description
        ObjectId id = new ObjectId();
        String title = "Test Title";
        String description = "Test Description";

        // WHEN: Creating a MongoInfoEntity using the constructor
        MongoInfoEntity entity = new MongoInfoEntity(id, title, description);

        // THEN: The fields should be correctly initialized
        assertEquals(id, entity.getId());
        assertEquals(title, entity.getTitle());
        assertEquals(description, entity.getDescription());
    }

    @Test
    void testDefaultConstructorAndSetters() {
        // GIVEN: A MongoInfoEntity created using the default constructor
        MongoInfoEntity entity = new MongoInfoEntity();

        ObjectId id = new ObjectId();
        String title = "New Title";
        String description = "New Description";

        // WHEN: Setting values using setters
        entity.setId(id);
        entity.setTitle(title);
        entity.setDescription(description);

        // THEN: The fields should reflect the set values
        assertEquals(id, entity.getId());
        assertEquals(title, entity.getTitle());
        assertEquals(description, entity.getDescription());
    }

    @Test
    void testConvertFrom() {
        // GIVEN: An Info object
        Info info = new Info();
        info.setId(new ObjectId().toString());
        info.setTitle("Sample Title");
        info.setDescription("Sample Description");

        // WHEN: Converting Info to MongoInfoEntity
        MongoInfoEntity entity = MongoInfoEntity.convertFrom(info);

        // THEN: The fields in MongoInfoEntity should match the Info object
        assertEquals(new ObjectId(info.getId()), entity.getId());
        assertEquals(info.getTitle(), entity.getTitle());
        assertEquals(info.getDescription(), entity.getDescription());
    }

    @Test
    void testConvertTo() {
        // GIVEN: A MongoInfoEntity object
        ObjectId id = new ObjectId();
        MongoInfoEntity entity = new MongoInfoEntity(id, "Test Title", "Test Description");

        // WHEN: Converting MongoInfoEntity to Info
        Info info = entity.convertTo();

        // THEN: The fields in Info should match the MongoInfoEntity object
        assertEquals(id.toString(), info.getId());
        assertEquals("Test Title", info.getTitle());
        assertEquals("Test Description", info.getDescription());
    }
}

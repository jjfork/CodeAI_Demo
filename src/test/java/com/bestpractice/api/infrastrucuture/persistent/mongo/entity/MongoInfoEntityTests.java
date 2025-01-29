package com.bestpractice.api.infrastrucuture.persistent.mongo.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.bson.types.ObjectId; 
import com.example.project.Info; // Replace with the correct import path

public class MongoInfoEntityTests {
    @Test
    public void testSave() {
        MongoInfoEntity entity = new MongoInfoEntity();
        entity.setId(new ObjectId()); 
        entity.setName("Test Name");
        // ... rest of your test code ...
    }

    // ... other tests ...
}

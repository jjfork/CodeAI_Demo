package com.bestpractice.api.infrastrucuture.persistent.mongo;

import com.bestpractice.api.common.exception.InternalServerError;
import com.bestpractice.api.infrastrucuture.entity.User;
import com.bestpractice.api.infrastrucuture.persistent.mongo.entity.MongoUserEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class MongoUserPersistentRepositoryTests {


    private MongoDatabase mongoDatabase;
    private MongoCollection<MongoUserEntity> collection;
    private MongoUserPersistentRepository repository;

    @BeforeEach
    void setUp() {
        mongoDatabase = Mockito.mock(MongoDatabase.class);
        collection = Mockito.mock(MongoCollection.class);
        when(mongoDatabase.getCollection(any(String.class), eq(MongoUserEntity.class))).thenReturn(collection);
        repository = new MongoUserPersistentRepository(null, mongoDatabase);
    }

    @Test
    void testNewId() {
        // GIVEN: A MongoUserPersistentRepository instance

        // WHEN: Generating a new ID
        String newId = repository.newId();

        // THEN: Verify the ID is not null and matches the expected format
        assertNotNull(newId);
        assertTrue(ObjectId.isValid(newId));
    }


    @Test
    void testInsertSuccess() {
        // GIVEN: A User object to insert
        User user = new User();
        user.setId(new ObjectId().toString());
        user.setEmail("email@example.com");
        user.setUsername("username");

        // WHEN: Inserting the user
        User result = repository.insert(user);

        // THEN: Verify the insertion succeeds and the returned User is the same
        assertNotNull(result);
        assertEquals("email@example.com", result.getEmail());
        verify(collection, times(1)).insertOne(any(MongoUserEntity.class));
    }

    @Test
    void testInsertFailure() {
        // GIVEN: A mock collection that throws an exception during insertion
        doThrow(new RuntimeException("Mock Insert Failure")).when(collection).insertOne(any());

        // WHEN: Attempting to insert a User object
        User user = new User();
        Exception exception = assertThrows(InternalServerError.class, () -> repository.insert(user));

        // THEN: Verify an InternalServerError is thrown
        assertTrue(exception.getMessage().contains("Failed to insert"));
    }


    @Test
    void testRemoveByIdSuccess() {
        // GIVEN: A valid ObjectId and a successful delete operation
        ObjectId objectId = new ObjectId();
        DeleteResult mockResult = mock(DeleteResult.class);
        when(mockResult.wasAcknowledged()).thenReturn(true);
        when(collection.deleteOne(any())).thenReturn(mockResult);

        // WHEN: Removing a user by ID
        boolean result = repository.removeById(objectId.toString());

        // THEN: Verify the removal was acknowledged
        assertTrue(result);
        verify(collection, times(1)).deleteOne(any());
    }

    @Test
    void testRemoveByIdFailure() {
        // GIVEN: A mock collection that throws an exception during deletion
        doThrow(new RuntimeException("Mock Delete Failure")).when(collection).deleteOne(any());

        // WHEN: Attempting to remove a user by ID
        Exception exception = assertThrows(InternalServerError.class, () -> repository.removeById(new ObjectId().toString()));

        // THEN: Verify an InternalServerError is thrown
        assertTrue(exception.getMessage().contains("Failed to delete"));
    }
}
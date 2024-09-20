package com.bestpractice.api.infrastrucuture.persistent.local;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import com.bestpractice.api.infrastrucuture.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalUserPersistentRepositoryTests {

    @Test
    void newId() {
        LocalUserPersistentRepository repository = new LocalUserPersistentRepository();
        String id = repository.newId();
        assertNotNull(id);
    }

    @Test
    void findByEmail() {
        LocalUserPersistentRepository repository = new LocalUserPersistentRepository();
        User user = new User("id1", "username1", "email1@example.com", "password1");
        repository.insert(user);
        User foundUser = repository.findByEmail("email1@example.com");
        assertEquals(user, foundUser);
    }

    @Test
    void findById() {
        LocalUserPersistentRepository repository = new LocalUserPersistentRepository();
        User user = new User("id1", "username1", "email1@example.com", "password1");
        repository.insert(user);
        User foundUser = repository.findById("id1");
        assertEquals(user, foundUser);
    }

    @Test
    void insert() {
        LocalUserPersistentRepository repository = new LocalUserPersistentRepository();
        User user = new User("id1", "username1", "email1@example.com", "password1");
        User insertedUser = repository.insert(user);
        assertEquals(user, insertedUser);
    }

    @Test
    void replace() {
        LocalUserPersistentRepository repository = new LocalUserPersistentRepository();
        User user = new User("id1", "username1", "email1@example.com", "password1");
        repository.insert(user);
        User updatedUser = new User("id1", "username2", "email2@example.com", "password2");
        repository.replace("id1", updatedUser);
        User foundUser = repository.findById("id1");
        assertEquals(updatedUser, foundUser);
    }

    @Test
    void removeById() {
        LocalUserPersistentRepository repository = new LocalUserPersistentRepository();
        User user = new User("id1", "username1", "email1@example.com", "password1");
        repository.insert(user);
        boolean removed = repository.removeById("id1");
        assertTrue(removed);
        assertNull(repository.findById("id1"));
    }
}

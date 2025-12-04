package com.example.tasktracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

public class TaskRepositoryTest {

    TaskRepository repo = new TaskRepository();

    @Test
    void testInsertAndRead() throws SQLException {
        Task t = new Task("DB Test");
        t.setStatus(TaskStatus.OPEN);

        Task saved = repo.save(t);
        assertTrue(saved.getId() > 0);

        Task loaded = repo.findById(saved.getId());
        assertNotNull(loaded);
        assertEquals("DB Test", loaded.getDescription());
    }

    @Test
    void testUpdate() throws SQLException {
        Task t = new Task("Update Test");
        t.setStatus(TaskStatus.OPEN);
        repo.save(t);

        t.setDescription("Updated!");
        t.setStatus(TaskStatus.CLOSED);

        boolean ok = repo.update(t);
        assertTrue(ok);

        Task loaded = repo.findById(t.getId());
        assertEquals("Updated!", loaded.getDescription());
        assertEquals(TaskStatus.CLOSED, loaded.getStatus());
    }

    @Test
    void testDelete() throws SQLException {
        Task t = new Task("Delete Test");
        t.setStatus(TaskStatus.OPEN);
        repo.save(t);

        boolean deleted = repo.delete(t.getId());
        assertTrue(deleted);

        assertNull(repo.findById(t.getId()));
    }
}

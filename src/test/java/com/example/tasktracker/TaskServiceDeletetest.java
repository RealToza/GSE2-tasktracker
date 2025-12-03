package com.example.tasktracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceDeleteTest {

    @Test
    void deleteExistingTask_shouldReturnTrueAndRemove() {
        TaskService service = new TaskService();
        Task t = service.createTask("Test löschen");

        boolean removed = service.deleteTask(t);

        assertTrue(removed);
        assertFalse(service.findAll().contains(t));
    }

    @Test
    void deleteNonExistingTask_shouldReturnFalse() {
        TaskService service = new TaskService();
        Task fake = new Task("Fake Task"); // nie hinzugefügt

        boolean removed = service.deleteTask(fake);

        assertFalse(removed);
    }
}

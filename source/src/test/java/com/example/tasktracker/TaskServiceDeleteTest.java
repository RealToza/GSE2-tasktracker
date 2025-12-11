package com.example.tasktracker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

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

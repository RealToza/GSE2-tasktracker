package com.example.tasktracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceUpdateTest {

    @Test
    void updateStatus_shouldChangeTaskStatus() {
        TaskService service = new TaskService();
        Task t = service.createTask("Update Test");

        boolean updated = service.updateStatus(t, TaskStatus.DONE);

        assertTrue(updated);
        assertEquals(TaskStatus.DONE, t.getStatus());
    }

    @Test
    void updateStatus_shouldFailIfTaskNotInList() {
        TaskService service = new TaskService();

        Task fake = new Task("Nicht hinzugefügt");

        boolean updated = service.updateStatus(fake, TaskStatus.DONE);

        assertFalse(updated);
    }
}

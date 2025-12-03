package com.example.tasktracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void createTask_withValidDescription_shouldSaveAndReturnOpenTask() {
        // Arrange
        TaskService service = new TaskService();

        // Act
        Task created = service.createTask("Meine Aufgabe");

        // Assert
        assertNotNull(created);
        assertEquals("Meine Aufgabe", created.getDescription());
        assertEquals(TaskStatus.OPEN, created.getStatus());
    }

    @Test
    void createTask_emptyDescription_shouldThrow() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.createTask(""));
    }
}

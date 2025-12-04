package com.example.tasktracker;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private final List<Task> storage = new ArrayList<>();

    public Task createTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description must not be empty");
        }
        Task t = new Task(description);
        storage.add(t);
        return t;
    }

    // minimal: weitere Methoden später
    public List<Task> findAll() {
        return new ArrayList<>(storage);
    }

    public boolean deleteTask(Task t) {
        return storage.remove(t);
    }
    public boolean updateStatus(Task t, TaskStatus newStatus) {
    if (t == null || newStatus == null) {
        return false;
    }

    if (!storage.contains(t)) {
        return false;
    }

    t.setStatus(newStatus);
    return true;
}


}

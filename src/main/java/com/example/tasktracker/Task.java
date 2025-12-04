package com.example.tasktracker;

public class Task {

    private int id;
    private String description;
    private TaskStatus status = TaskStatus.OPEN;

    public Task(String description) {
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
}

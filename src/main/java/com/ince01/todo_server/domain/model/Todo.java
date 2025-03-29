package com.ince01.todo_server.domain.model;

import lombok.*;
import lombok.extern.java.Log;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Todo {
    private Integer id;
    private String title;
    private String description;
    private boolean completed;
    private Integer createdBy;

    public Todo(String title, String description, Integer userId) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (userId == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdBy = userId;
    }

    public void markAsCompleted() {
        if (this.completed) {
            throw new IllegalStateException("Todo is already completed");
        }
        this.completed = true;
    }

    public void update(String title, String description) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
        this.description = description;
    }
}
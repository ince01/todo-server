package com.todo.todo_server.domain.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private User user;

    public Todo(String title, String description, User user) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.title = title;
        this.description = description;
        this.completed = false;
        this.user = user;
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
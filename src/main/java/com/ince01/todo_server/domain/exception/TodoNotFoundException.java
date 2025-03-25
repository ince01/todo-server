package com.ince01.todo_server.domain.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id) {
        super("Todo with ID " + id + " not found");
    }
}

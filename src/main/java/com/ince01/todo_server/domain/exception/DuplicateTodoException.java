package com.ince01.todo_server.domain.exception;

public class DuplicateTodoException extends RuntimeException {
    public DuplicateTodoException(String title) {
        super("Todo with title " + title + " already exists");
    }
}

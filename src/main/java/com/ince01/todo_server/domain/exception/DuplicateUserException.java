package com.ince01.todo_server.domain.exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String username) {
        super("User with username " + username + " already exists");
    }
}

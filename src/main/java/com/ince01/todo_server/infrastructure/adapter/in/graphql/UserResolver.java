package com.ince01.todo_server.infrastructure.adapter.in.graphql;

import com.ince01.todo_server.domain.model.Todo;
import com.ince01.todo_server.domain.model.User;

public class UserResolver {
    public User user(Todo todo) {
        return todo.getUser();
    }
}
package com.ince01.todo_server.application.port.in;

import com.ince01.todo_server.domain.model.Todo;

import java.util.List;

public interface TodoService {
    Todo createTodo(Long userId, String title, String description);

    Todo getTodoById(Long userId, Long todoId);

    List<Todo> getAllTodos(Long userId);

    Todo updateTodo(Long userId, Long todoId, String title, String description, boolean completed);

    void deleteTodo(Long userId, Long todoId);
}

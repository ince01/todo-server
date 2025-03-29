package com.ince01.todo_server.application.port.in;

import com.ince01.todo_server.domain.model.Todo;

import java.util.List;

public interface TodoService {
    Todo createTodo(Integer userId, String title, String description);

    Todo getTodoById(Integer userId, Integer todoId);

    List<Todo> getAllTodos(Integer userId);

    Todo updateTodo(Integer userId, Integer todoId, String title, String description, boolean completed);

    void deleteTodo(Integer userId, Integer todoId);
}

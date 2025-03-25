package com.ince01.todo_server.infrastructure.adapter.in.graphql;

import com.ince01.todo_server.application.port.in.TodoService;
import com.ince01.todo_server.domain.model.Todo;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TodoResolver {
    private final TodoService todoService;

    public Todo todo(Long userId, Long todoId) {
        return todoService.getTodoById(userId, todoId);
    }

    public List<Todo> todos(Long userId) {
        return todoService.getAllTodos(userId);
    }

    public Todo createTodo(Long userId, String title, String description) {
        return todoService.createTodo(userId, title, description);
    }

    public Todo updateTodo(Long userId, Long todoId, String title, String description, Boolean completed) {
        return todoService.updateTodo(userId, todoId, title, description, completed);
    }

    public Boolean deleteTodo(Long userId, Long todoId) {
        todoService.deleteTodo(userId, todoId);
        return true;
    }
}
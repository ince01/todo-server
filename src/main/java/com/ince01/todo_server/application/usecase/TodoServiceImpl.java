package com.ince01.todo_server.application.usecase;

import com.ince01.todo_server.application.port.in.TodoService;
import com.ince01.todo_server.application.port.out.TodoRepositoryPort;
import com.ince01.todo_server.domain.model.Todo;
import com.ince01.todo_server.domain.model.User;
import com.ince01.todo_server.domain.exception.DuplicateTodoException;
import com.ince01.todo_server.domain.exception.TodoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepositoryPort todoRepositoryPort;

    @Override
    public Todo createTodo(Long userId, String title, String description) {
        if (todoRepositoryPort.existsByUserIdAndTitle(userId, title)) {
            throw new DuplicateTodoException(title);
        }

        User user = new User("anonymous");
        user.setId(userId);
        Todo todo = new Todo(title, description, user);
        Todo savedTodo = todoRepositoryPort.save(todo);

        return savedTodo;
    }

    @Override
    public Todo getTodoById(Long userId, Long todoId) {
        Todo todo = todoRepositoryPort.findById(todoId);

        if (todo == null || !todo.getUser().getId().equals(userId)) {
            throw new TodoNotFoundException(todoId);
        }

        return todo;
    }

    @Override
    public List<Todo> getAllTodos(Long userId) {
        return todoRepositoryPort.findAllByUserId(userId);
    }

    @Override
    public Todo updateTodo(Long userId, Long todoId, String title, String description, boolean completed) {
        Todo existingTodo = getTodoById(userId, todoId);
        if (!existingTodo.getTitle().equals(title) && todoRepositoryPort.existsByUserIdAndTitle(userId, title)) {
            throw new DuplicateTodoException(title);
        }

        existingTodo.update(title, description);

        if (completed) {
            existingTodo.markAsCompleted();
        }

        return todoRepositoryPort.save(existingTodo);
    }

    @Override
    public void deleteTodo(Long userId, Long todoId) {
        Todo todo = getTodoById(userId, todoId);
        todoRepositoryPort.deleteById(todoId);
    }
}
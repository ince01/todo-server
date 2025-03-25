package com.ince01.todo_server.infrastructure.adapter.in.rest;

import com.ince01.todo_server.application.port.in.TodoService;
import com.ince01.todo_server.domain.model.Todo;
import com.ince01.todo_server.domain.exception.DuplicateTodoException;
import com.ince01.todo_server.domain.exception.TodoNotFoundException;
import com.ince01.todo_server.infrastructure.adapter.in.dto.TodoRequest;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/todos")
@RequiredArgsConstructor
public class TodoController {
    @Autowired
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@PathVariable Long userId, @RequestBody TodoRequest request) {
        Todo todo = todoService.createTodo(userId, request.getTitle(), request.getDescription());
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long userId, @PathVariable Long todoId) {
        Todo todo = todoService.getTodoById(userId, todoId);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(@PathVariable Long userId) {
        List<Todo> todos = todoService.getAllTodos(userId);
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long userId, @PathVariable Long todoId, @RequestBody TodoRequest request) {
        Todo todo = todoService.updateTodo(userId, todoId, request.getTitle(), request.getDescription(), request.isCompleted());
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
        todoService.deleteTodo(userId, todoId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DuplicateTodoException.class)
    public ResponseEntity<String> handleDuplicateTitle(DuplicateTodoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<String> handleNotFound(TodoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

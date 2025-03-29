package com.ince01.todo_server.infrastructure.adapter.in.rest;

import com.ince01.todo_server.application.port.in.TodoService;
import com.ince01.todo_server.domain.model.Todo;
import com.ince01.todo_server.domain.exception.DuplicateTodoException;
import com.ince01.todo_server.domain.exception.TodoNotFoundException;
import com.ince01.todo_server.infrastructure.adapter.in.dto.TodoRequest;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@PathVariable Integer userId, @Valid @RequestBody TodoRequest request) {
        Todo todo = todoService.createTodo(userId, request.getTitle(), request.getDescription());
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable Integer userId, @PathVariable Integer todoId) {
        Todo todo = todoService.getTodoById(userId, todoId);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(@PathVariable Integer userId) {
        List<Todo> todos = todoService.getAllTodos(userId);
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Integer userId, @PathVariable Integer todoId, @Valid @RequestBody TodoRequest request) {
        Todo todo = todoService.updateTodo(userId, todoId, request.getTitle(), request.getDescription(), request.isCompleted());
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer userId, @PathVariable Integer todoId) {
        todoService.deleteTodo(userId, todoId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(DuplicateTodoException.class)
    public ResponseEntity<ProblemDetail> handleDuplicateTitle(DuplicateTodoException duplicateTodoException) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, duplicateTodoException.getMessage());
        return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
    }

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFound(TodoNotFoundException todoNotFoundException) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, todoNotFoundException.getMessage());
        return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
    }
}

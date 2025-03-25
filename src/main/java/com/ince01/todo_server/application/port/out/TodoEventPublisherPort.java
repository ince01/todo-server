package com.ince01.todo_server.application.port.out;

import com.ince01.todo_server.domain.model.Todo;

public interface TodoEventPublisherPort {
    void publishTodoCreated(Todo todo);

    void publishTodoUpdated(Todo todo);

    void publishTodoDeleted(Long userId, Long todoId);
}
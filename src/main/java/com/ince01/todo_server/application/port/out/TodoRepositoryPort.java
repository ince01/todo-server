package com.ince01.todo_server.application.port.out;

import com.ince01.todo_server.domain.model.Todo;

import java.util.List;

public interface TodoRepositoryPort {
    Todo save(Todo todo);

    Todo findById(Long id);

    List<Todo> findAllByUserId(Long userId);

    void deleteById(Long id);

    boolean existsByUserIdAndTitle(Long userId, String title);
}

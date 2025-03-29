package com.ince01.todo_server.application.port.out;

import com.ince01.todo_server.domain.model.Todo;

import java.util.List;

public interface TodoRepositoryPort {
    Todo save(Todo todo);

    Todo findById(Integer id);

    List<Todo> findAllByUserId(Integer userId);

    void deleteById(Integer id);

    boolean existsByUserIdAndTitle(Integer userId, String title);
}

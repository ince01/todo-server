package com.ince01.todo_server.infrastructure.adapter.out.persistence;

import com.ince01.todo_server.infrastructure.adapter.out.persistence.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataTodoRepository extends JpaRepository<TodoEntity, Integer> {
    List<TodoEntity> findByUserId(Integer userId);

    boolean existsByUserIdAndTitle(Integer userId, String title);
}
package com.ince01.todo_server.infrastructure.adapter.out.persistence;

import com.ince01.todo_server.application.port.out.TodoRepositoryPort;
import com.ince01.todo_server.domain.model.Todo;
import com.ince01.todo_server.infrastructure.adapter.out.persistence.entity.TodoEntity;
import com.ince01.todo_server.infrastructure.adapter.out.persistence.mapper.TodoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class JpaTodoRepository implements TodoRepositoryPort {
    private final SpringDataTodoRepository springDataTodoRepository;

    @Override
    public Todo save(Todo todo) {
        TodoEntity entity = TodoMapper.toEntity(todo);
        TodoEntity savedEntity = springDataTodoRepository.save(entity);
        return TodoMapper.toDomain(savedEntity);
    }

    @Override
    public Todo findById(Long id) {
        return springDataTodoRepository.findById(id).map(TodoMapper::toDomain).orElse(null);
    }

    @Override
    public List<Todo> findAllByUserId(Long userId) {
        return springDataTodoRepository.findByUserId(userId).stream().map(TodoMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        springDataTodoRepository.deleteById(id);
    }

    @Override
    public boolean existsByUserIdAndTitle(Long userId, String title) {
        return springDataTodoRepository.existsByUserIdAndTitle(userId, title);
    }
}
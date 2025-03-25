package com.ince01.todo_server.infrastructure.adapter.out.persistence.mapper;

import com.ince01.todo_server.domain.model.Todo;
import com.ince01.todo_server.domain.model.User;
import com.ince01.todo_server.infrastructure.adapter.out.persistence.entity.TodoEntity;
import com.ince01.todo_server.infrastructure.adapter.out.persistence.entity.UserEntity;

public class TodoMapper {
    public static TodoEntity toEntity(Todo todo) {
        if (todo == null) return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(todo.getUser().getId());
        userEntity.setUsername(todo.getUser().getUsername());
        return new TodoEntity(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted(), userEntity);
    }

    public static Todo toDomain(TodoEntity entity) {
        if (entity == null) return null;
        User user = new User(entity.getUser().getUsername());
        user.setId(entity.getUser().getId());
        Todo todo = new Todo(entity.getTitle(), entity.getDescription(), user);
        todo.setId(entity.getId());
        if (entity.isCompleted()) {
            todo.markAsCompleted();
        }
        return todo;
    }
}
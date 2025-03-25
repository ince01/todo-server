package com.ince01.todo_server.infrastructure.adapter.out.persistence.mapper;

import com.ince01.todo_server.domain.model.User;
import com.ince01.todo_server.infrastructure.adapter.out.persistence.entity.UserEntity;

public class UserMapper {
    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getUsername());
    }

    public static User toDomain(UserEntity entity) {
        User user = new User(entity.getUsername());
        user.setId(entity.getId());
        return user;
    }
}

package com.ince01.todo_server.application.port.out;

import com.ince01.todo_server.domain.model.User;

public interface UserRepositoryPort {
    User save(User user);

    boolean existsByUsername(String username);
}

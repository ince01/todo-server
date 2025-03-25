package com.ince01.todo_server.application.port.in;

import com.ince01.todo_server.domain.model.User;

public interface UserService {
    User createUser(String userName);
}

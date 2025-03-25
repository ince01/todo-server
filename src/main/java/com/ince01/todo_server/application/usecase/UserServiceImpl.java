package com.ince01.todo_server.application.usecase;

import com.ince01.todo_server.application.port.in.UserService;
import com.ince01.todo_server.application.port.out.UserRepositoryPort;
import com.ince01.todo_server.domain.exception.DuplicateUserException;
import com.ince01.todo_server.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User createUser(String userName) {
        if (userRepositoryPort.existsByUsername(userName)) {
            throw new DuplicateUserException(userName);
        }
        return userRepositoryPort.save(new User(userName));
    }
}

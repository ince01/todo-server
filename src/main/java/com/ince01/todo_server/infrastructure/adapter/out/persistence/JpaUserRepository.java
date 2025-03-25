package com.ince01.todo_server.infrastructure.adapter.out.persistence;

import com.ince01.todo_server.application.port.out.UserRepositoryPort;
import com.ince01.todo_server.domain.model.User;
import com.ince01.todo_server.infrastructure.adapter.out.persistence.entity.UserEntity;
import com.ince01.todo_server.infrastructure.adapter.out.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepositoryPort {
    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        UserEntity savedUserEntity = springDataUserRepository.save(userEntity);
        return UserMapper.toDomain(savedUserEntity);
    }

    @Override
    public boolean existsByUsername(String username) {
        return springDataUserRepository.existsByUsername(username);
    }
}

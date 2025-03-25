package com.ince01.todo_server.infrastructure.adapter.out.persistence;

import com.ince01.todo_server.infrastructure.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
}

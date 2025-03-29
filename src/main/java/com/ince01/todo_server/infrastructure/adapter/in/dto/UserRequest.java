package com.ince01.todo_server.infrastructure.adapter.in.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRequest {
    @NotEmpty
    private String username;
}

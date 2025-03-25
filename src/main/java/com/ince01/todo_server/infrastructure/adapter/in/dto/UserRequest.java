package com.ince01.todo_server.infrastructure.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserRequest {
    private String username;
}

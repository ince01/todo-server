package com.ince01.todo_server.infrastructure.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {
    private String title;
    private String description;
    private boolean completed;
}
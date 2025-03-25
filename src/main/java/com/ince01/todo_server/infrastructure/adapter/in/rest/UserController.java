package com.ince01.todo_server.infrastructure.adapter.in.rest;

import com.ince01.todo_server.application.port.in.UserService;
import com.ince01.todo_server.domain.model.User;
import com.ince01.todo_server.infrastructure.adapter.in.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest request) {
        User user = userService.createUser(request.getUsername());
        return ResponseEntity.ok(user);
    }
}

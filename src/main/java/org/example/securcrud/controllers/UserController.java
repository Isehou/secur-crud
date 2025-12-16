package org.example.securcrud.controllers;

import lombok.RequiredArgsConstructor;
import org.example.securcrud.model.User;
import org.example.securcrud.services.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserDetailsServiceImpl userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllRoles() {
        return userService.getAllUser();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }
}

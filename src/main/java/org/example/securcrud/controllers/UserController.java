package org.example.securcrud.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.securcrud.model.User;
import org.example.securcrud.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

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
        return userService.addUser(user);
    }
}

package org.example.securcrud.services;

import lombok.AllArgsConstructor;
import org.example.securcrud.model.User;
import org.example.securcrud.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}

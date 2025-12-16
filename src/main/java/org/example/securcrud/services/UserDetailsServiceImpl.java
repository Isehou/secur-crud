package org.example.securcrud.services;

import lombok.RequiredArgsConstructor;
import org.example.securcrud.model.User;
import org.example.securcrud.repositories.UserRepository;
import org.example.securcrud.security.UsersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService  {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    } 

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new UsersDetails(user);
    }


    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}

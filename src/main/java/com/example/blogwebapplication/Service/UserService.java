package com.example.blogwebapplication.Service;

import com.example.blogwebapplication.Model.User;
import com.example.blogwebapplication.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User deleteUser(Long id) {
        userRepository.deleteById(id);
        return null;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + user.getId() + " не найден."));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public void subscribe(User user, User targetUser) {
        user.subscribe(targetUser);
        userRepository.save(user);
    }
    public void unsubscribe(User user, User targerUser){
        user.unsubscribe(targerUser);
        userRepository.save(user);
    }
}
package com.example.blogwebapplication.service;

import com.example.blogwebapplication.model.User;
import com.example.blogwebapplication.repository.UserRepository;
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
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setEmail(user.getEmail());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + id + " не найден."));
    }

    /* Старый способ.
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + user.getId() + " не найден."));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
     */

    public void subscribe(User user, User targetUser) {
        user.subscribe(targetUser);
        userRepository.save(user);
    }
    public void unsubscribe(User user, User targerUser){
        user.unsubscribe(targerUser);
        userRepository.save(user);
    }
}

/* Более лучшая версия
import com.example.blogwebapplication.model.User;
import com.example.blogwebapplication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setUsername(updatedUser.getUsername());
                    existingUser.setEmail(updatedUser.getEmail());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + id + " не найден."));
    }

    public void subscribe(User user, User targetUser) {
        user.subscribe(targetUser);
        userRepository.save(user);
    }

    public void unsubscribe(User user, User targetUser) {
        user.unsubscribe(targetUser);
        userRepository.save(user);
    }
}

 */
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
//        return userRepository.findById(id)
//                .map(existingUser -> {
//                    existingUser.setUsername(user.getUsername());
//                    existingUser.setEmail(user.getEmail());
//                    return userRepository.save(existingUser);
//                })
//                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + id + " не найден."));
    User exisitingUser = userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("User with id: " + id + " not found."));
    exisitingUser.setUsername(user.getUsername());
    exisitingUser.setEmail(user.getEmail());
    exisitingUser.setComments(user.getComments());
    return userRepository.save(exisitingUser);
  }

  public void subscribe(User user, User targetUser) {
    user.subscribe(targetUser);
    userRepository.save(user);
  }

  public void unSubscribe(User user, User targerUser) {
    user.unSubscribe(targerUser);
    userRepository.save(user);
  }
}
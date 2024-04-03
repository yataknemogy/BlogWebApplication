package com.example.blogwebapplication.service;

import com.example.blogwebapplication.model.User;
import com.example.blogwebapplication.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    public Mono<User> updateUser(Long id, User user) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setEmail(user.getEmail());
                    // Set other properties as needed
                    return userRepository.save(existingUser);
                });
    }

    public Mono<Void> subscribe(Long id, Long targetUserId) {
        return userRepository.findById(id)
                .flatMap(user -> userRepository.findById(targetUserId)
                        .map(targetUser -> {
                            user.subscribe(targetUser);
                            return user;
                        }))
                .flatMap(userRepository::save)
                .then();
    }

    public Mono<Void> unSubscribe(Long id, Long targetUserId) {
        return userRepository.findById(id)
                .flatMap(user -> userRepository.findById(targetUserId)
                        .map(targetUser -> {
                            user.unsubscribe(targetUser);
                            return user;
                        }))
                .flatMap(userRepository::save)
                .then();
    }
}

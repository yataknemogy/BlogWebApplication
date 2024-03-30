package com.example.blogwebapplication.Service;

import com.example.blogwebapplication.Model.User;
import com.example.blogwebapplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User findUserById(Long id){
        Optional<User>user = userRepository.findById(id);
        return user.orElse(new User());
    }
    public void deleteUser(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }
    public List<User> allUsers(){
        return userRepository.findAll();
    }
    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + user.getId() + " не найден."));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }
}

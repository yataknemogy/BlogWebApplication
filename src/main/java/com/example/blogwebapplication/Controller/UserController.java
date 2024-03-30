package com.example.blogwebapplication.controller;

import com.example.blogwebapplication.model.User;
import com.example.blogwebapplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUserById(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updated){
        return userService.updateUser(id, updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/subscribe")
    public void subscribe(@RequestParam Long id, @RequestParam Long targetUserId) {
        User user = userService.getUserById(id);
        User targetUser = userService.getUserById(targetUserId);
        if (user != null && targetUser != null) {
            user.subscribe(targetUser);
            userService.updateUser(id, user);
        }
    }

    @PostMapping("/unsubscribe")
    public void unsubscribe(@RequestParam Long id, @RequestParam Long targetUserId) {
        User user = userService.getUserById(id);
        User targetUser = userService.getUserById(targetUserId);
        if (user != null && targetUser != null) {
            user.unsubscribe(targetUser);
            userService.updateUser(id, user);
        }
    }
}

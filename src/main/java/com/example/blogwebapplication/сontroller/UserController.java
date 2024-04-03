package com.example.blogwebapplication.controller;

import com.example.blogwebapplication.model.User;
import com.example.blogwebapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/add")
  public Mono<User> addUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @DeleteMapping("/delete/{id}")
  public Mono<Void> deleteUserById(@PathVariable Long id) {
    return userService.deleteUser(id);
  }

  @PutMapping("/update/{id}")
  public Mono<User> updateUser(@PathVariable Long id, @RequestBody User updateUser) {
    return userService.updateUser(id, updateUser);
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<User>> getUserById(@PathVariable Long id) {
    return userService.getUserById(id)
            .map(user -> ResponseEntity.ok(user))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @PostMapping("/subscribe")
  public Mono<Void> subscribe(@RequestParam Long id, @RequestParam Long targetUserId) {
    return userService.subscribe(id, targetUserId);
  }

  @PostMapping("/unsubscribe")
  public Mono<Void> unSubscribe(@RequestParam Long id, @RequestParam Long targetUserId) {
    return userService.unSubscribe(id, targetUserId);
  }
}

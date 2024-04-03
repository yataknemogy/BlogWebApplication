package com.example.blogwebapplication.repository;

import com.example.blogwebapplication.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {}

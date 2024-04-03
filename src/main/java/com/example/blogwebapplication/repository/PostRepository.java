package com.example.blogwebapplication.repository;

import com.example.blogwebapplication.model.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post, Long> {}

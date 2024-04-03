package com.example.blogwebapplication.repository;

import com.example.blogwebapplication.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends ReactiveCrudRepository<Comment, Long> {}


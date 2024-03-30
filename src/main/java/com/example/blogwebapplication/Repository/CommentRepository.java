package com.example.blogwebapplication.Repository;

import com.example.blogwebapplication.Model.Comment;
import com.example.blogwebapplication.Model.Post;
import com.example.blogwebapplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(Long id);
}

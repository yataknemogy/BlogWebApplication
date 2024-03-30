package com.example.blogwebapplication.Repository;

import com.example.blogwebapplication.Model.Post;
import com.example.blogwebapplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
}

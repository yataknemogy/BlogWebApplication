package com.example.blogwebapplication.Repository;

import com.example.blogwebapplication.Model.Post;

import java.util.Optional;

public interface PostRepository {
    Optional<Post> findById(Long id);
}

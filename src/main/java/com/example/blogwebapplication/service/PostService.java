package com.example.blogwebapplication.service;

import com.example.blogwebapplication.model.Post;
import com.example.blogwebapplication.model.User;
import com.example.blogwebapplication.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public Post createPost(Post post) {
    return postRepository.save(post);
  }

  public Post getPostById(Long id) {
    return postRepository.findById(id).orElse(null);
  }

  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Post updatePost(Long id, Post updatedPost) {
    return postRepository.findById(id)
        .map(existingPost -> {
          existingPost.setTitle(updatedPost.getTitle());
          existingPost.setContent(updatedPost.getContent());
          return postRepository.save(existingPost);
        })
        .orElseThrow(() -> new IllegalArgumentException("Пост с ID: " + id + " не найден."));
  }
}
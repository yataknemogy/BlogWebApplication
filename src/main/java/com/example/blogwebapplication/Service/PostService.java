package com.example.blogwebapplication.Service;

import com.example.blogwebapplication.Model.Post;
import com.example.blogwebapplication.Model.User;
import com.example.blogwebapplication.Repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post createPostWithUser(Post post, User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        post.setUser(user); // Установка пользователя для поста

        // Сохранение поста в репозитории
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(post.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + post.getId() + " не найден."));
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postRepository.save(existingPost);
    }
}
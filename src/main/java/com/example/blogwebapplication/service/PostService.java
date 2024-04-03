package com.example.blogwebapplication.service;

import com.example.blogwebapplication.model.Post;
import com.example.blogwebapplication.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Mono<Post> createPost(Post post) {
        return postRepository.save(post);
    }

    public Mono<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Mono<Void> deletePost(Long id) {
        return postRepository.deleteById(id);
    }

    public Flux<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Mono<Post> updatePost(Long id, Post updatedPost) {
        return postRepository.findById(id)
                .flatMap(existingPost -> {
                    existingPost.setTitle(updatedPost.getTitle());
                    existingPost.setContent(updatedPost.getContent());
                    return postRepository.save(existingPost);
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Пост с ID: " + id + " не найден.")));
    }
}

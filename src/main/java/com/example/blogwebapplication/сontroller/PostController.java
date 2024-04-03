package com.example.blogwebapplication.controller;

import com.example.blogwebapplication.model.Post;
import com.example.blogwebapplication.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public Mono<ResponseEntity<?>> createPost(@RequestBody Post post) {
        return Mono.just(post)
                .flatMap(p -> {
                    if (p.getUser() == null) {
                        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User must be specified!"));
                    } else {
                        return postService.createPost(p)
                                .map(createdPost -> ResponseEntity.status(HttpStatus.CREATED).body(createdPost));
                    }
                });
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> deletePostById(@PathVariable Long id) {
        return postService.deletePost(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Post>> updatePost(@PathVariable Long id, @RequestBody Post updatePost) {
        return postService.updatePost(id, updatePost)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Post>> getPostById(@PathVariable Long id) {
        return postService.getPostById(id)
                .map(post -> ResponseEntity.ok(post))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

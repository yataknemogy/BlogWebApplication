package com.example.blogwebapplication.Controller;

import com.example.blogwebapplication.Model.Post;
import com.example.blogwebapplication.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        if (post.getUser() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Пользователь должен быть указан!");
        }
        Post createdPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Post updatePost) {
        Post updatedPost = postService.updatePost(id, updatePost);
        return ResponseEntity.ok(updatedPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

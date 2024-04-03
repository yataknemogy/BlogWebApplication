package com.example.blogwebapplication.controller;

import com.example.blogwebapplication.model.Comment;
import com.example.blogwebapplication.service.CommentService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/createComment")
    public Mono<Comment> createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/comment/{id}")
    public Mono<Comment> getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

    @GetMapping("/comments")
    public Flux<Comment> getAllComments() {
        return commentService.allComments();
    }

    @PutMapping("/update")
    public Mono<Comment> updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }
}

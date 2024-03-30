package com.example.blogwebapplication.controller;

import com.example.blogwebapplication.model.Comment;
import com.example.blogwebapplication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/createComment")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.allComments();
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }
}


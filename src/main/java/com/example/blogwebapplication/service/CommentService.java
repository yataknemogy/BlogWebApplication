package com.example.blogwebapplication.service;

import com.example.blogwebapplication.model.Comment;
import com.example.blogwebapplication.repository.CommentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Mono<Comment> createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Mono<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Mono<Void> deleteComment(Long id) {
        return commentRepository.deleteById(id);
    }

    public Flux<Comment> allComments() {
        return commentRepository.findAll();
    }

    public Mono<Comment> updateComment(Comment updatedComment) {
        return commentRepository.findById(updatedComment.getId())
                .flatMap(existingComment -> {
                    existingComment.setUsername(updatedComment.getUsername());
                    existingComment.setContent(updatedComment.getContent());
                    return commentRepository.save(existingComment);
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException(
                        "Comment with ID: " + updatedComment.getId() + " not found.")));
    }
}

package com.example.blogwebapplication.service;

import com.example.blogwebapplication.model.Comment;
import com.example.blogwebapplication.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /* @REVIEW 1
    * Лучше вернуть Optional, а не null.
    */
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> allComments() {
        return commentRepository.findAll();
    }

    /* Старый способ.
    public Comment updateComment(Comment comment) {
        Comment existingComment = commentRepository.findById(comment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + comment.getId() + " не найден."));
        existingComment.setUsername(comment.getUsername());
        existingComment.setContent(comment.getContent());
        return commentRepository.save(existingComment);
    }
    */

    public Comment updateComment(Comment updatedComment) {
        return commentRepository.findById(updatedComment.getId())
                .map(existingComment -> {
                    existingComment.setUsername(updatedComment.getUsername());
                    existingComment.setContent(updatedComment.getContent());
                    return commentRepository.save(existingComment);
                })
                .orElseThrow(() -> new IllegalArgumentException("Комментарий с ID: " + updatedComment.getId() + " не найден."));
    }
}

/* Более лучшая версия

import com.example.blogwebapplication.model.Comment;
import com.example.blogwebapplication.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> allComments() {
        return commentRepository.findAll();
    }

    public Comment updateComment(Comment updatedComment) {
        return commentRepository.findById(updatedComment.getId())
                .map(existingComment -> {
                    existingComment.setUsername(updatedComment.getUsername());
                    existingComment.setContent(updatedComment.getContent());
                    return commentRepository.save(existingComment);
                })
                .orElseThrow(() -> new IllegalArgumentException("Комментарий с ID: " + updatedComment.getId() + " не найден."));
    }
}
 */

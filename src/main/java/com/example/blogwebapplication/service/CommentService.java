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

  public Comment getCommentById(Long id) {
    return commentRepository.findById(id).orElse(null);
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
        .orElseThrow(() -> new IllegalArgumentException(
            "Комментарий с ID: " + updatedComment.getId() + " не найден."));
  }
}
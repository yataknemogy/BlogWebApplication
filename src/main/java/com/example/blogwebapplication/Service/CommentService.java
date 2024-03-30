package com.example.blogwebapplication.Service;

import com.example.blogwebapplication.Model.Comment;
import com.example.blogwebapplication.Model.Post;
import com.example.blogwebapplication.Repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }

    public List<Comment> allComments(){
        return commentRepository.findAll();
    }

    public Comment updateComment(Comment comment){
        Comment existingComment = commentRepository.findById(comment.getId())
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID: " + comment.getId() + " не найден."));
        existingComment.setUsername(comment.getUsername());
        existingComment.setContent(comment.getContent());
        return commentRepository.save(existingComment);
    }
}

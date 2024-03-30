package com.example.blogwebapplication;

import com.example.blogwebapplication.model.Comment;
import com.example.blogwebapplication.repository.CommentRepository;
import com.example.blogwebapplication.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CommentServiceTest {

    @Test
    void getCommentById_ExistingId_ReturnsComment() {
        // Arrange
        Long commentId = 1L;
        Comment comment = new Comment();
        comment.setId(commentId);

        CommentRepository commentRepository = Mockito.mock(CommentRepository.class);
        when(commentRepository.findById(commentId)).thenReturn(Optional.of(comment));

        CommentService commentService = new CommentService(commentRepository);

        // Act
        Comment result = commentService.getCommentById(commentId);

        // Assert
        assertEquals(comment, result);
    }

}

package com.example.blogwebapplication;

import com.example.blogwebapplication.model.Post;
import com.example.blogwebapplication.repository.PostRepository;
import com.example.blogwebapplication.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PostServiceTest {

    @Test
    void getPostById_ExistingId_ReturnsPost() {
        // Arrange
        Long postId = 1L;
        Post post = new Post();
        post.setId(postId);

        PostRepository postRepository = Mockito.mock(PostRepository.class);
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));

        PostService postService = new PostService(postRepository);

        Post result = postService.getPostById(postId);

        assertEquals(post, result);
    }

}

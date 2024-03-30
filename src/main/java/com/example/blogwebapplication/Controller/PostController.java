package com.example.blogwebapplication.Controller;

import com.example.blogwebapplication.Model.Post;
import com.example.blogwebapplication.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePostById(@PathVariable Long id){
        postService.deletePost(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updatePost(@PathVariable Long id, @RequestBody Post updatePost){
        Post updatedPost = postService.updatePost(id, updatePost);
        return ResponseEntity.ok(updatedPost);
    }


    @GetMapping("/{id}")
    public String getPostById(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "post";
        } else {
            return "error";
        }
    }
}

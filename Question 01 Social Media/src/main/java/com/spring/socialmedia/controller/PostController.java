package com.spring.socialmedia.controller;

import com.spring.socialmedia.model.Post;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final List<Post> posts = new ArrayList<>();

    public PostController() {
        posts.add(new Post(100, 1, "Spring Boot"));
        posts.add(new Post(125, 1, "Core Java"));
        posts.add(new Post(150, 2, "Collection Framework"));
    }

    @GetMapping
    public Map<String, List<Post>> getAllPosts() {
        Map<String, List<Post>> response = new HashMap<>();
        response.put("posts", posts);
        return response;
    }


    @PostMapping
    public Map<String, String> createPost(@RequestBody Post post) {
        posts.add(post);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Post created successfully");
        return response;
    }
}

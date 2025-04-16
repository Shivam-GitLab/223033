package com.spring.socialmedia.controller;

import com.spring.socialmedia.model.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final List<Comment> comments = new ArrayList<>();

    public CommentController() {
        comments.add(new Comment(13, 150, "Good Article"));
        comments.add(new Comment(15, 100, "Awesome Notes"));
    }


    @GetMapping
    public Map<String, List<Comment>> getComments() {
        Map<String, List<Comment>> response = new HashMap<>();
        response.put("comments", comments);
        return response;
    }

    @PostMapping
    public Map<String, String> addComment(@RequestBody Comment comment) {
        comments.add(comment);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Comment added successfully");
        return response;
    }
}


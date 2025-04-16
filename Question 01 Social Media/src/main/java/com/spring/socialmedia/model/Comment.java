package com.spring.socialmedia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private int id;
    private int postId;
    private String content;

    public Comment() {}

    public Comment(int id, int postId, String content) {
        this.id = id;
        this.postId = postId;
        this.content = content;
    }
}

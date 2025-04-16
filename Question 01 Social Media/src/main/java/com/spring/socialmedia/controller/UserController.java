package com.spring.socialmedia.controller;

import com.spring.socialmedia.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Map<Integer, String> users = new HashMap<>();

    public UserController() {

        users.put(1, "Shivam");
        users.put(2, "Sumit Jha");
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : users.entrySet()) {
            userList.add(new User(entry.getKey(), entry.getValue()));
        }
        return userList;
    }

    @PostMapping
    public Map<String, String> createUser(@RequestBody User user) {
        users.put(user.getId(), user.getName());
        Map<String, String> response = new HashMap<>();
        response.put("message", "User created successfully");
        return response;
    }
}

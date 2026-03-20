package com.example.springbootapp.controllers;

import com.example.springbootapp.models.*;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
class PostController {

    @GetMapping("/{number}")
    public Post getPost(@PathVariable String number) {
        try {
            System.out.println(number);
            var post = new Post();
            UUID id = UUID.randomUUID();
            post.setId(id);
            post.setTitle("I like to write lots of code");
            post.setContent(
                "The act of programming is one of the best feelings ever"
            );
            return post;
        } catch (Exception e) {
            var post = new Post();
            UUID id = UUID.randomUUID();
            post.setId(id);
            post.setTitle("I like to write lots of code");
            post.setContent(
                "The act of programming is one of the best feelings ever"
            );
            return post;
        }
    }

    @GetMapping("/healthCheck")
    public Map<String, Object> healthCheck() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("Message", "Health Check is successfull");
        return data;
    }
}

package com.rodolpho.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolpho.payload.PostDto;
import com.rodolpho.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    //create a post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

}

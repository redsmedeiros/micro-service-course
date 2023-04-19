package com.rodolpho.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolpho.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    
    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
}

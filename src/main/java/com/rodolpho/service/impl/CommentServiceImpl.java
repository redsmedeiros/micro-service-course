package com.rodolpho.service.impl;

import org.springframework.stereotype.Service;

import com.rodolpho.entity.Comment;
import com.rodolpho.payload.CommentDto;
import com.rodolpho.repository.CommentRepository;
import com.rodolpho.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
       return null;
    }

    private CommentDto maptoDto(Comment comment){
        
        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getName());

        return commentDto;
    }
    
}

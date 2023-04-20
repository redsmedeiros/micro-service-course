package com.rodolpho.service;

import java.util.List;

import com.rodolpho.payload.CommentDto;

public interface CommentService {
    
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest);
}

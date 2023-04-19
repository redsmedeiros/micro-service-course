package com.rodolpho.service;

import com.rodolpho.payload.CommentDto;

public interface CommentService {
    
    CommentDto createComment(long postId, CommentDto commentDto);
}

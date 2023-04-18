package com.rodolpho.service;

import com.rodolpho.payload.PostDto;
import com.rodolpho.payload.PostResponse;

public interface PostService {
    
    PostDto createPost(PostDto PostDto);

    PostResponse getAllPosts(int pageNo, int pageSize);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}

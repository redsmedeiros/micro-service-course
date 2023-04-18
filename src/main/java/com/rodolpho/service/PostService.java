package com.rodolpho.service;

import java.util.List;

import com.rodolpho.payload.PostDto;

public interface PostService {
    
    PostDto createPost(PostDto PostDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);
}

package com.rodolpho.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rodolpho.entity.Post;
import com.rodolpho.exception.ResourceNotFoundException;
import com.rodolpho.payload.PostDto;
import com.rodolpho.repository.PostRepository;
import com.rodolpho.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

       Post post = mapToEntity(postDto); 

       Post newPost = postRepository.save(post);

       PostDto postResponse = mapToDTO(newPost);

       return postResponse;

    
    }

    @Override
    public List<PostDto> getAllPosts() {
       
        List<Post> posts = postRepository.findAll();
        
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

    }

    @Override
    public PostDto getPostById(long id) {
       
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post", "id", id));

        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post", "id", id));

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);

        return mapToDTO(updatedPost);
    }
    

    private PostDto mapToDTO(Post post){

        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }

    private Post mapToEntity(PostDto postDto){

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }

   

   
}

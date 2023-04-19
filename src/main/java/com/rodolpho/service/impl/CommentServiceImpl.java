package com.rodolpho.service.impl;

import org.springframework.stereotype.Service;

import com.rodolpho.entity.Comment;
import com.rodolpho.entity.Post;
import com.rodolpho.exception.ResourceNotFoundException;
import com.rodolpho.payload.CommentDto;
import com.rodolpho.repository.CommentRepository;
import com.rodolpho.repository.PostRepository;
import com.rodolpho.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
       
        Comment comment = mapToEntity(commentDto);

        //PEGAR O POST POR ID
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Comments", "id", postId));

        //COLOCAR O POST NO OBJ COMMENT
        comment.setPost(post);

        //SALVAR A ENTIDADE NO DB
        Comment newComment = commentRepository.save(comment);

        return maptoDto(newComment);
    }

    private CommentDto maptoDto(Comment comment){
        
        CommentDto commentDto = new CommentDto();

        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getName());

        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){

        Comment comment = new Comment();

        comment.setId(commentDto.getId());
        comment.setName(comment.getName());
        comment.setEmail(comment.getEmail());
        comment.setBody(comment.getBody());

        return comment;
    }
    
}

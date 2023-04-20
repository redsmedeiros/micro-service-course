package com.rodolpho.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rodolpho.entity.Comment;
import com.rodolpho.entity.Post;
import com.rodolpho.exception.BlogAPIException;
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

    @Override
    public List<CommentDto> getCommentByPostId(long postId) {

        
        List<Comment> comments = commentRepository.findByPostId(postId);

        System.out.println("TEEEEEEEEEEEEEEEEEEEEESTE");
        System.out.println(comments);
        

        return comments.stream().map(comment -> maptoDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
      
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
        }
      
        return maptoDto(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest) {
       
       Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "id", postId));

       Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "id", commentId));

       if(!comment.getPost().getId().equals(post.getId())){
        throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
       }

       comment.setName(commentRequest.getName());
       comment.setEmail(commentRequest.getEmail());
       comment.setBody(comment.getBody());

       Comment updateComment = commentRepository.save(comment);
       
        return maptoDto(updateComment);
    }

    
    @Override
    public void deleteComment(Long postId, Long commentId) {
        
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "id", postId));

        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "ll");
        }

        commentRepository.deleteById(commentId);

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
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

       

        return comment;
    }


}

package com.rodolpho.payload;

import java.util.Set;

import lombok.Data;

@Data
public class PostDto {
    
    private Long id;
    private String description;
    private String title;
    private String content;
    private Set<CommentDto> comments;
}

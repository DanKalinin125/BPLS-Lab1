package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CommentDTO {
    private Long id;
    private String username;
    private String email;
    private String text;
    private Date creationDateTime;
}

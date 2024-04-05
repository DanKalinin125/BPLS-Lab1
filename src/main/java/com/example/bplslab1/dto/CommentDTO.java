package com.example.bplslab1.dto;

import com.example.bplslab1.entity.News;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class CommentDTO {
    private Long id;
    private String username;
    private String email;
    private String text;
    private Date creationDateTime;
}

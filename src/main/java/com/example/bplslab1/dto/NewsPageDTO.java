package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class NewsPageDTO {
    private ImageDTO image;
    private String title;
    private String text;
    private Date creationDateTime;
    private List<CommentDTO> commentList;
}

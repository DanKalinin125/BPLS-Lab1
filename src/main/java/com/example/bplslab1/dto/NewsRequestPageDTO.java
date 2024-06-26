package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NewsRequestPageDTO {
    private ImageDTO image;
    private String title;
    private String text;
    private Date creationDateTime;
}

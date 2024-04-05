package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NewsInListDTO {
    private ImageDTO image;
    private long id;
    private String title;
    private Date creationDateTime;
}

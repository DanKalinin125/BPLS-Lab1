package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class NewsInListDTO {
    private ImageDTO image;
    private String title;
    private Date creationDateTime;
}

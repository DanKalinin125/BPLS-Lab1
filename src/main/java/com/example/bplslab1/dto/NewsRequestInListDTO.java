package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NewsRequestInListDTO {
    private ImageDTO image;
    private long id;
    private String title;
    private Date creationDateTime;
}

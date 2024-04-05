package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class NewsRequestCreateDTO {
    private MultipartFile image;
    private String title;
    private String text;
}

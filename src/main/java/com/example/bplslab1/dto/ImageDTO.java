package com.example.bplslab1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageDTO {
    private Long id;
    private String name;
    private String type;
}

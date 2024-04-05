package com.example.bplslab1.controller;

import com.example.bplslab1.dto.NewsRequestDTO;
import com.example.bplslab1.entity.News;
import com.example.bplslab1.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/news")
@AllArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getAll() {
        return new ResponseEntity<>(newsService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<News> create(@RequestPart("image") MultipartFile file,
                                       String title,
                                       String text) throws IOException {
        NewsRequestDTO dto = NewsRequestDTO.builder()
                .image(file)
                .title(title)
                .text(text)
                .build();
        return new ResponseEntity<>(newsService.create(dto), HttpStatus.OK);
    }
}

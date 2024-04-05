package com.example.bplslab1.controller;

import com.example.bplslab1.dto.*;
import com.example.bplslab1.service.NewsRequestService;
import com.example.bplslab1.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/news")
@AllArgsConstructor
public class NewsController {
    private final NewsService newsService;
    private final NewsRequestService newsRequestService;

    @GetMapping
    public ResponseEntity<List<NewsInListDTO>> getAll() {
        return new ResponseEntity<>(newsService.readAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestPart("image") MultipartFile file,
                                    String title,
                                    String text) {
        NewsCreateDTO dto = NewsCreateDTO.builder()
                .image(file)
                .title(title)
                .text(text)
                .build();
        if (!dto.check())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Отсутствуют обязательные параметры");
        try {
            NewsPageDTO newsPageDTO = newsService.create(dto);
            return new ResponseEntity<>(newsPageDTO, HttpStatus.OK);
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getLocalizedMessage());
        }
    }

    @GetMapping(path = "/{newsId}")
    public ResponseEntity<?> getCertainNews(@PathVariable long newsId) {
        try {
            NewsPageDTO newsPageDTO = newsService.readCertain(newsId);
            return new ResponseEntity<>(newsPageDTO, HttpStatus.OK);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getLocalizedMessage());
        }
    }

    @PostMapping(path = "/{newsId}/comment")
    public ResponseEntity<?> createComment(@PathVariable long newsId, @RequestBody CommentCreateDTO dto) {
        if (!dto.check())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Отсутствуют обязательные параметры");

        try {
            CommentDTO commentDTO = newsService.createComment(newsId, dto);
            return new ResponseEntity<>(commentDTO, HttpStatus.OK);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getLocalizedMessage());
        }
    }

    @PostMapping(path = "/request")
    public ResponseEntity<?> createNewsRequest(@RequestPart("image") MultipartFile file,
                                               String title,
                                               String text) {
        NewsRequestCreateDTO dto = NewsRequestCreateDTO.builder()
                .image(file)
                .title(title)
                .text(text)
                .build();
        if (!dto.check())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Отсутствуют обязательные параметры");

        try {
            NewsRequestPageDTO newsRequestPageDTO = newsRequestService.create(dto);
            return new ResponseEntity<>(newsRequestPageDTO, HttpStatus.OK);
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getLocalizedMessage());
        }
    }

    @GetMapping("/all_requests")
    public ResponseEntity<?> getAllRequests() {
        return new ResponseEntity<>(newsRequestService.readAll(), HttpStatus.OK);
    }
}

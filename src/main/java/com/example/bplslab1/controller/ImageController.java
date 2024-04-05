package com.example.bplslab1.controller;

import com.example.bplslab1.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping(path = "/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        try{
            byte[] image = imageService.downloadImage(fileName);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpg")).body(image);
        } catch (IOException ioException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ioException.getLocalizedMessage());
        }
    }
}

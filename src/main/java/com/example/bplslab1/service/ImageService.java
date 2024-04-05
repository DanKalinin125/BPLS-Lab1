package com.example.bplslab1.service;

import com.example.bplslab1.entity.News;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@NoArgsConstructor
public class ImageService {
    private static final String IMAGES_DIRECTORY = "./images/";
    public String uploadImage(MultipartFile file) throws IOException{
        String extension = file.getOriginalFilename().split("\\.")[1];
        String url = IMAGES_DIRECTORY + getRandomString() + "." + extension;

        byte[] bytes = file.getBytes();
        Path path = Paths.get(url);
        Files.write(path, bytes);

        return url;
    }

    public byte[] findImage(String fileName) throws IOException {
        String url = IMAGES_DIRECTORY + fileName;
        return Files.readAllBytes(Paths.get(url));
    }

    private String getRandomString() {
        final int SIZE = 20;

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(SIZE);

        for (int i = 0; i < SIZE; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}

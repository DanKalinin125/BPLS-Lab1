package com.example.bplslab1.service;

import com.example.bplslab1.Utils;
import com.example.bplslab1.entity.Image;
import com.example.bplslab1.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image uploadImage(MultipartFile file) throws IOException{
        String extension = file.getOriginalFilename().split("\\.")[1];
        String name = getRandomString() + "." + extension;

        return imageRepository.save(Image.builder()
                .name(name)
                .type(file.getContentType())
                .imageData(Utils.compressImage(file.getBytes()))
                .build());
    }

    public byte[] downloadImage(String fileName) throws IOException {
        Optional<Image> image = imageRepository.findByName(fileName);
        return Utils.decompressImage(image.get().getImageData());
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

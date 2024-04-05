package com.example.bplslab1.service;

import com.example.bplslab1.Utils;
import com.example.bplslab1.dto.NewsRequestDTO;
import com.example.bplslab1.entity.Image;
import com.example.bplslab1.entity.News;
import com.example.bplslab1.repository.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    private final ImageService imageService;

    public News create(NewsRequestDTO newsRequestDTO) throws IOException {
        Image image = imageService.uploadImage(newsRequestDTO.getImage());
        return newsRepository.save(News.builder()
                .image(image)
                .title(newsRequestDTO.getTitle())
                .text(newsRequestDTO.getText())
                .creationDateTime(Utils.getCurrentDateTime())
                .build());
    }

    public List<News> readAll(){
        return newsRepository.findAll(Sort.by(Sort.Order.asc("creationDateTime")));
    }
}

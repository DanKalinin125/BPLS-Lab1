package com.example.bplslab1.service;

import com.example.bplslab1.Utils;
import com.example.bplslab1.dto.ImageDTO;
import com.example.bplslab1.dto.NewsCreateDTO;
import com.example.bplslab1.dto.NewsInListDTO;
import com.example.bplslab1.dto.NewsPageDTO;
import com.example.bplslab1.entity.Image;
import com.example.bplslab1.entity.News;
import com.example.bplslab1.repository.NewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    private final ImageService imageService;

    public News create(NewsCreateDTO newsCreateDTO) throws IOException {
        Image image = imageService.uploadImage(newsCreateDTO.getImage());
        return newsRepository.save(Utils.newsCreateDTOToNews(newsCreateDTO, image));
    }

    public List<NewsInListDTO> readAll(){
        List<News> newsRepositoryAll = newsRepository.findAll(Sort.by(Sort.Order.asc("creationDateTime")));
        List<NewsInListDTO> newsList = new ArrayList<>();
        for (News news : newsRepositoryAll){
            newsList.add(Utils.newsToNewsInListDTO(news));
        }
        return newsList;
    }
}

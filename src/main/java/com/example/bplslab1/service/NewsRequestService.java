package com.example.bplslab1.service;

import com.example.bplslab1.Utils;
import com.example.bplslab1.dto.NewsRequestCreateDTO;
import com.example.bplslab1.dto.NewsRequestPageDTO;
import com.example.bplslab1.entity.Image;
import com.example.bplslab1.entity.NewsRequest;
import com.example.bplslab1.repository.NewsRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class NewsRequestService {
    private final NewsRequestRepository newsRequestRepository;
    private final ImageService imageService;

    public NewsRequestPageDTO create(NewsRequestCreateDTO dto) throws IOException {
        Image image = imageService.uploadImage(dto.getImage());
        NewsRequest newsRequest = newsRequestRepository.save(Utils.newsRequestCreateDTOToNewsRequest(dto, image));
        return Utils.newsRequestToNewsRequestPageDTO(newsRequest);
    }
}

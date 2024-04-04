package com.example.bplslab1.repositories;

import com.example.bplslab1.models.NewsRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRequestRepository extends JpaRepository<NewsRequest, Long> {
}

package com.example.bplslab1.repository;

import com.example.bplslab1.entity.NewsRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRequestRepository extends JpaRepository<NewsRequest, Long> {
}

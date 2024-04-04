package com.example.bplslab1.repository;

import com.example.bplslab1.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository <News, Long> {
}

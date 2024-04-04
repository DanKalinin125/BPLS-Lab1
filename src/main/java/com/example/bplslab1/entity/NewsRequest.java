package com.example.bplslab1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="NewsRequests")
public class NewsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "newsRequestTitle", nullable = false)
    private String title;

    @Column(name = "newsRequestText", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "creationDateTime", nullable = false)
    private Date creationDateTime;
}

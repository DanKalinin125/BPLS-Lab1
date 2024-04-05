package com.example.bplslab1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="NewsRequests")
public class NewsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "imageFK", nullable = false)
    private Image image;

    @Column(name = "newsRequestTitle", nullable = false)
    private String title;

    @Column(name = "newsRequestText", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDateTime", nullable = false)
    private Date creationDateTime;
}

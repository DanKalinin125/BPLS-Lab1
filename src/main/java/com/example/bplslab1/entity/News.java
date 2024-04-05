package com.example.bplslab1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="News")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "newsTitle", nullable = false)
    private String title;

    @Column(name = "newsText", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "creationDateTime", nullable = false)
    private Date creationDateTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "news")
    private List<Comment> commentList;

}

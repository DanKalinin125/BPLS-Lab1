package com.example.bplslab1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Comments")
public class Comment {
    private final int MAX_COMMENT_LENGTH = 4000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="newsFK", nullable=false)
    private News news;

    @Column(name = "commentText", nullable = false, length = MAX_COMMENT_LENGTH)
    private String text;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "creationDateTime", nullable = false)
    private Date creationDateTime;
}

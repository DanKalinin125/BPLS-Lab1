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
@Table(name="Comments")
public class Comment {
    @Transient
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDateTime", nullable = false)
    private Date creationDateTime;
}

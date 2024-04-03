package com.example.blogwebapplication.model;

import jakarta.persistence.*;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "comment")
@Data
@Getter
@Setter
public class Comment {
    @Id
    private Long id;
    private String username;
    private String content;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
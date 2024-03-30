package com.example.blogwebapplication.Model;

import jakarta.persistence.*;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    @JoinColumn(name = "postId", nullable = false)
    private Post postComment;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
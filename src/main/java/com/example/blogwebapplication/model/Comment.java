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

//    @ManyToOne
//    @JoinColumn(name = "postId", nullable = false)
//    private Post postComment;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false) // Указываем название колонки, которая ссылается на пост
    private Post post; // Добавляем поле для хранения ссылки на пост

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
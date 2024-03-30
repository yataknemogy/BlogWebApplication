package com.example.blogwebapplication.Model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    private Long id;
    private String username;
    private String content;
    private Date date;
}
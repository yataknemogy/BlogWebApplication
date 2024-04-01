package com.example.blogwebapplication.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String email;

  @OneToMany(mappedBy = "user")
  private Set<Post> posts = new HashSet<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<Comment> comments = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "user_subscriptions",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "subscription_id")
  )
  private Set<User> subscriptions = new HashSet<>();

  public void subscribe(User user) {
    subscriptions.add(user);
    user.getSubscriptions().add(this);
  }

  public void unSubscribe(User user) {
    subscriptions.remove(user);
    user.getSubscriptions().remove(this);
  }
}
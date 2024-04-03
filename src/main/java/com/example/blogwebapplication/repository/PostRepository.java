package com.example.blogwebapplication.repository;

import com.example.blogwebapplication.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  @Override
  <S extends Post> S save(S entity);

  @Override
  Optional<Post> findById(Long id);

}

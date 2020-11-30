package com.example.demo.model.entity.repository;

import com.example.demo.model.entity.Post;
import com.example.demo.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
  Optional<Post> findById(Long id);

  Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);

  Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);
}

package com.example.demo.model.entity.repository;

import com.example.demo.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}

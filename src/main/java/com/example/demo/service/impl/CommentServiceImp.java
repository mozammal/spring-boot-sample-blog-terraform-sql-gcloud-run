package com.example.demo.service.impl;

import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.repository.CommentRepository;
import com.example.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommentServiceImp implements CommentService {

  private final CommentRepository commentRepository;

  @Override
  public Comment save(Comment comment) {
    return commentRepository.save(comment);
  }
}

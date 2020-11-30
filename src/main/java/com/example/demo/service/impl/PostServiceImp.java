package com.example.demo.service.impl;

import com.example.demo.model.entity.Post;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.repository.PostRepository;
import com.example.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostServiceImp implements PostService {

  private final PostRepository postRepository;

  @Override
  public Optional<Post> findForId(Long id) {
    return postRepository.findById(id);
  }

  @Override
  public Post save(Post post) {
    return postRepository.save(post);
  }

  @Override
  public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
    return postRepository.findByUserOrderByCreateDateDesc(
        user, PageRequest.of(subtractPageByOne(page), 5));
  }

  @Override
  public Page<Post> findAllOrderedByDatePageable(int page) {
    return postRepository.findAllByOrderByCreateDateDesc(
        PageRequest.of(subtractPageByOne(page), 5));
  }

  @Override
  public void delete(Post post) {
    postRepository.delete(post);
  }

  private int subtractPageByOne(int page) {
    return (page < 1) ? 0 : page - 1;
  }
}

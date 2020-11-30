package com.example.demo.controller;

import com.example.demo.model.entity.Post;
import com.example.demo.service.PostService;
import com.example.demo.util.Pager;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
public class HomeController {

  private final PostService postService;

  @GetMapping("/home")
  public String home(@RequestParam(defaultValue = "0") int page, Model model) {

    Page<Post> posts = postService.findAllOrderedByDatePageable(page);
    Pager pager = new Pager(posts);
    model.addAttribute("pager", pager);
    return "home";
  }
}

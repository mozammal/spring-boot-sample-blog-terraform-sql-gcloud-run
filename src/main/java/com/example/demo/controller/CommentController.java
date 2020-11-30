package com.example.demo.controller;

import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.Post;
import com.example.demo.model.entity.User;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CommentController {

  private final PostService postService;
  private final UserService userService;
  private final CommentService commentService;

  @RequestMapping(value = "/createComment", method = RequestMethod.POST)
  public String createNewPost(@Valid Comment comment, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "commentForm";
    } else {
      commentService.save(comment);
      return "redirect:/post/" + comment.getPost().getId();
    }
  }

  @RequestMapping(value = "/commentPost/{id}", method = RequestMethod.GET)
  public String commentPostWithId(@PathVariable Long id, Principal principal, Model model) {

    Optional<Post> post = postService.findForId(id);

    if (post.isPresent()) {
      Optional<User> user = userService.findByUsername(principal.getName());

      if (user.isPresent()) {
        Comment comment = new Comment();
        comment.setUser(user.get());
        comment.setPost(post.get());
        model.addAttribute("comment", comment);
        return "commentForm";
      } else {
        return "error";
      }
    } else {
      return "error";
    }
  }
}

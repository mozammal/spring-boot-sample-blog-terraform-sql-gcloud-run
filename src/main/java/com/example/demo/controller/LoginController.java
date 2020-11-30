package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.GeneratedValue;
import java.security.Principal;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String login(Principal principal) {

    if (principal != null) {
      return "redirect:/home";
    }
    return "login";
  }
}

package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
public class RegistrationController {

  private final UserService userService;

  @RequestMapping(value = "/registration", method = RequestMethod.GET)
  public String registration(Model model) {
    model.addAttribute("user", new User());
    return "registration";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
    if (userService.findByEmail(user.getEmail()).isPresent()) {
      bindingResult.rejectValue(
          "email", "error.user", "There is already a user registered with the email provided");
    }
    if (userService.findByUsername(user.getUsername()).isPresent()) {
      bindingResult.rejectValue(
          "username",
          "error.user",
          "There is already a user registered with the username provided");
    }
    if (!bindingResult.hasErrors()) {
      userService.save(user);
      model.addAttribute("successMessage", "User has been registered successfully");
      model.addAttribute("user", new User());
    }
    return "registration";
  }
}
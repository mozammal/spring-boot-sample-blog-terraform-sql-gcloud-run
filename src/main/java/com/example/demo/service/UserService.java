package com.example.demo.service;

import com.example.demo.model.entity.User;

import java.util.Optional;

public interface UserService {

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  User save(User user);
}

package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User loginService(String username, String password);
    User registService(User user);

}

package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/register")
    public Result<User> registController(@RequestBody User user){
        User newUser = userService.registService(user);
        if (newUser.getUsername() == null || newUser.getPassword() == null || user.getPhone() == null){
            return Result.error("-1", "用户名或密码或手机号为空");
        }
        if (newUser != null){
            return Result.success(user, "注册成功");
        }else{
            return Result.error("-1", "用户名已存在！");
        }
    }
    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String username, @RequestParam String password){
        User newUser = userService.loginService(username, password);
        if (newUser != null){
            return Result.success(newUser, "登陆成功");
        }else{
            return Result.error("-1", "账号或密码错误！");
        }
    }
}

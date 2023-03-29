package com.example.demo.service.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User loginService(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, password);
        if (user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        if (user.getUsername() == null || user.getPassword() == null || user.getPhone() == null){
            return user;
        }
        if (userMapper.findByUsername(user.getUsername()) != null){
            return null;
        }else{
            User newUser = user;
            if (userMapper.addAccount(user) == 1){
                newUser.setPassword("");
            }
            return newUser;
        }
    }

}

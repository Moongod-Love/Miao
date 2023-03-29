package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
@Mapper
public interface UserMapper {
    @Transactional
    int addAccount(User user);
    @Transactional
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    int updateAccount(User user);
}

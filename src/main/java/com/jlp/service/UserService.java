package com.jlp.service;

import com.jlp.mapper.UserMapper;
import com.jlp.pojo.User;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "userservice")
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    public User selectByUsername(User user) {
        return userMapper.selectByUsername(user.getUsername());
    }

    public User selectByPrimaryKey(User user){
        return  userMapper.selectByPrimaryKey(user.getUserid());
    }

    public User selectByUserMail(User user) {
        return userMapper.selectByUserMail(user.getUsermail());
    }

    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    public Integer update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public Integer deleteByUserid(User user) {
        return userMapper.deleteByPrimaryKey(user.getUserid());
    }


}
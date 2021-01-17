package com.jlp.service;

import com.jlp.mapper.UserMapper;
import com.jlp.pojo.User;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "friendrelation")
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    @Cacheable(key = "'listAll'")
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Caching(put = {@CachePut(key = "#user.username")})
    public User getUser(User user) {
        return userMapper.selectByUsername(user.getUsername());
    }

    @Caching(put = {@CachePut(key = "#user.username")})
    public Integer insert(User user) {
        return userMapper.insert(user);
    }

    @Caching(evict = {@CacheEvict(key = "#user.username")})
    public Integer update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Caching(evict = {@CacheEvict(key = "#user.username")})
    public Integer deleteByUserid(User user) {
        return userMapper.deleteByPrimaryKey(user.getUserid());
    }


}

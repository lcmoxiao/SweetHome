package com.jlp.mapper;

import com.jlp.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    User selectByUsername(String username);

    List<User> selectAll();

    Integer updateByPrimaryKeySelective(User user);
}
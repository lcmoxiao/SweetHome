package com.jlp.mapper;

import com.jlp.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

    User selectByUsername(String username);

    User selectByUserMail(String usermail);
}
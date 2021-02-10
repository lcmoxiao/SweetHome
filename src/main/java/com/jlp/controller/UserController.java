package com.jlp.controller;

import com.jlp.pojo.User;
import com.jlp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Api("UserController")
@RestController
@RequestMapping("/user")
public class UserController {

    final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    UserService userService;

    @ApiOperation(value = "获取所有用户账户信息")
    @GetMapping("/all")
    List<User> getUser() {
        return userService.getAllUser();
    }

    @ApiOperation(value = "获取指定用户账户名(username)的账户信息")
    @GetMapping
    User getUser(User user) {
        return userService.selectByUsername(user);
    }

    @ApiOperation(value = "获取指定用户账户名(userid)的账户信息")
    @GetMapping("/id")
    User getUserByUserID(User user) {
        return userService.selectByPrimaryKey(user);
    }


    @ApiOperation(value = "新增用户信息")
    @PostMapping
    Integer postUser(@RequestBody User user) {
        user.setUsercreatetime(new Date());
        user.setUserbirth(new Date());
        user.setUsersex((byte) 0);
        user.setUserphone("0");
        user.setUserstate(0);
        user.setUserfriendsize(1);
        if (userService.selectByUserMail(user) != null) return -2;
        else if (userService.selectByUsername(user) != null) return -1;
        else return userService.insert(user);
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping
    Integer putUser(User user) {
        if (userService.selectByUsername(user) != null) return userService.update(user);
        else return -1;
    }

    @ApiOperation(value = "删除用户信息")
    @DeleteMapping
    Integer deleteUser(@RequestBody User user) {
        if (userService.selectByUsername(user) != null) return userService.deleteByUserid(user);
        else return -1;
    }

}

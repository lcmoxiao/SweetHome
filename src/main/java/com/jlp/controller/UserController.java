package com.jlp.controller;

import com.jlp.pojo.User;
import com.jlp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    User getUser( User user) {
        return userService.getUser(user);
    }

    @ApiOperation(value = "新增用户信息")
    @PostMapping
    Integer postUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping
    List<User> putUser() {
        return userService.getAllUser();
    }

    @ApiOperation(value = "删除用户信息")
    @DeleteMapping
    Integer deleteUser(@RequestBody User user) {
        return userService.deleteByUserid(user);
    }


}

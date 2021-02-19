package com.jlp.controller;


import com.jlp.pojo.User;
import com.jlp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("LoginController")
@RestController
@RequestMapping("/login")
public class LoginController {


    final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Resource
    UserService userService;

    @ApiOperation(value = "输入用户名和密码 登录")
    @PostMapping
    User login(@RequestBody User user) {
        String userpassword = user.getUserpassword();
        User u2 = userService.selectByUserMail(user);
        String username = u2.getUsername();
        if (!userpassword.equals(u2.getUserpassword())) {
            logger.info(username + "登录失败，密码错误");
        } else {
            logger.info(username + "登陆成功");
            return u2;
        }
        return null;
    }


}

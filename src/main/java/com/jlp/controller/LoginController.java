package com.jlp.controller;


import com.jlp.pojo.User;
import com.jlp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api("LoginController")
@RestController
@RequestMapping("/login")
public class LoginController {


    @Resource
    UserService userService;

    final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation(value = "输入用户名和密码 登录")
    @PostMapping
    User login(User user) {
        String username = user.getUsername();
        String userpassword = user.getUserpassword();
        User u2 = (User)userService.getUser(user);
        if(u2==null) {
            logger.debug("空账户尝试登录,尝试的账户为："+username);
        } else if (!userpassword.equals(u2.getUserpassword())){
            logger.debug(u2.getUsername()+"登录失败，密码错误");
        } else {
            logger.debug(u2.getUsername()+"登陆成功");
            return u2;
        }
        return null;
    }



}

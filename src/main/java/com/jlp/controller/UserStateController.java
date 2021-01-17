package com.jlp.controller;

import com.jlp.pojo.UserStateInfo;
import com.jlp.service.UserStateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("UserStateController")
@RestController
@RequestMapping("/userstate")
public class UserStateController {

    @Resource
    UserStateService userStateService;

    @ApiOperation(value = "获取用户状态，离线为null，在线为状态类")
    @GetMapping
    UserStateInfo getUserStateInfo(Integer userid) {
        return userStateService.getUserState(userid);
    }

    @ApiOperation(value = "更新用户状态")
    @PostMapping
    String  postUserStateInfo(@RequestBody UserStateInfo userStateInfo) {
        System.out.println(userStateInfo);
        userStateService.setUserState(userStateInfo);
        return "postUserStateInfo Success";
    }

    @ApiOperation(value = "删除用户状态")
    @DeleteMapping
    String deleteUserStateInfo(@RequestBody Integer userid) {
        userStateService.deleteUserState(userid);
        return "deleteUserStateInfo Success";
    }

}


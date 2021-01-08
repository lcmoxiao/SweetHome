package com.jlp.controller;


import com.jlp.pojo.FriendRelation;
import com.jlp.pojo.User;
import com.jlp.service.FriendRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Api("FriendRelationController")
@RestController
@RequestMapping("/friendrelation")
public class FriendRelationController {


    final static Logger logger = LoggerFactory.getLogger(FriendRelationController.class);
    @Resource
    FriendRelationService friendRelationService;

    @ApiOperation(value = "获取用户的所有好友")
    @GetMapping
    List<FriendRelation> getUser(User user) {
        return friendRelationService.getFriendRelation(user);
    }

    @ApiOperation(value = "增加指定好友")
    @PostMapping
    Integer postUser(FriendRelation friendRelation) {
        if (friendRelationService.selectByUserid1AndUserid2(friendRelation) == null) {
            friendRelation.setFriendrelationcreatetime(Calendar.getInstance().getTime());
            return friendRelationService.insert(friendRelation);
        } else {
            logger.debug("该好友关系已存在");
            return -1;
        }

    }

    @ApiOperation(value = "删除指定好友")
    @DeleteMapping
    Integer deleteUser(FriendRelation friendRelation) {
        FriendRelation fr = friendRelationService.selectByUserid1AndUserid2(friendRelation);
        if (fr != null) {
            friendRelation.setFriendrelationcreatetime(Calendar.getInstance().getTime());
            return friendRelationService.deleteByFriendRelationid(fr);
        } else {
            logger.debug("该好友关系不存在");
            return -1;
        }

    }


}
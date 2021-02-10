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
    List<FriendRelation> getFriendRelation(User user) {
        return friendRelationService.getFriendRelation(user);
    }

    @ApiOperation(value = "获取用户的所有好友")
    @GetMapping("/toUser")
    List<User> getFriendRelationToUsers(User user) {
        return friendRelationService.getFriendRelationToUsers(user);
    }

    @ApiOperation(value = "确认指定id之间的好友关系")
    @GetMapping("/check")
    Boolean checkFriendRelation(FriendRelation friendRelation) {
        return friendRelationService.selectByUserid1AndUserid2(friendRelation) != null;
    }

    @ApiOperation(value = "增加指定好友")
    @PostMapping
    Integer postFriendRelation(@RequestBody FriendRelation friendRelation) {
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
    Integer deleteFriendRelation(@RequestBody FriendRelation friendRelation) {
        return friendRelationService.deleteByFriendRelationid(friendRelation);
    }


}

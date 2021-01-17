package com.jlp.controller;


import com.jlp.pojo.MatchRelation;
import com.jlp.pojo.User;
import com.jlp.service.MatchRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Api("MatchRelationController")
@RestController
@RequestMapping("/matchrelation")
public class MatchRelationController {


    final static Logger logger = LoggerFactory.getLogger(MatchRelationController.class);
    @Resource
    MatchRelationService matchRelationService;

    @ApiOperation(value = "获取用户的所有匹配")
    @GetMapping
    List<MatchRelation> getMatchRelation(User user) {
        return matchRelationService.getMatchRelation(user);
    }

    @ApiOperation(value = "添加匹配")
    @PostMapping
    Integer postUser(@RequestBody MatchRelation matchRelation) {
        if (matchRelationService.selectByUserid1AndUserid2(matchRelation) == null) {
            matchRelation.setMatchrelationcreatetime(Calendar.getInstance().getTime());
            return matchRelationService.insert(matchRelation);
        } else {
            logger.debug("该匹配已存在");
            return -1;
        }

    }

    @ApiOperation(value = "删除指定匹配")
    @DeleteMapping
    Integer deleteUser(@RequestBody MatchRelation matchRelation) {
        MatchRelation fr = matchRelationService.selectByUserid1AndUserid2(matchRelation);
        if (fr != null) {
            matchRelation.setMatchrelationcreatetime(Calendar.getInstance().getTime());
            return matchRelationService.deleteByFriendRelationid(fr);
        } else {
            logger.debug("该匹配不存在");
            return -1;
        }

    }


}

package com.jlp.controller;

import com.jlp.pojo.MatchGroup;
import com.jlp.pojo.MatchGroupRelation;
import com.jlp.pojo.User;
import com.jlp.service.MatchGroupRelationService;
import com.jlp.service.MatchGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Api("UserController")
@RestController
@RequestMapping("/matchgroup")
public class MatchGroupController {

    final static Logger logger = LoggerFactory.getLogger(MatchGroupController.class);
    @Resource
    MatchGroupService matchGroupService;
    @Resource
    MatchGroupRelationService matchGroupRelationService;


    @ApiOperation(value = "获取指定群id中的所有用户id")
    @GetMapping("/alluser")
    List<MatchGroupRelation> getUseridByGroupid(MatchGroup matchGroup) {
        return matchGroupRelationService.selectByMatchGroupid(matchGroup.getMatchgroupid());
    }


    @ApiOperation(value = "获取指定用户id中的所有群id")
    @GetMapping("/allgroup")
    List<MatchGroupRelation> getGroupidByUserid(User user) {
        return matchGroupRelationService.selectByUserid(user.getUserid());
    }

    @ApiOperation(value = "新建匹配群")
    @PostMapping
    MatchGroup createMatchGroup(@RequestBody MatchGroupInfo matchGroupInfo) {
        try {
            //1.申请新matchgroup获得新gid
            matchGroupInfo.matchGroup.setMatchgroupcreatetime(Calendar.getInstance().getTime());
            matchGroupService.insert(matchGroupInfo.matchGroup);
            //2.添加matchgrouprelation关系
            for (int userid : matchGroupInfo.userids) {
                MatchGroupRelation matchGroupRelation = new MatchGroupRelation();
                matchGroupRelation.setUserid(userid);
                matchGroupRelation.setMatchgroupid(matchGroupInfo.matchGroup.getMatchgroupid());
                matchGroupRelationService.insertMatchGroupRelation(matchGroupRelation);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return matchGroupInfo.matchGroup;
    }


    @ApiOperation(value = "清除匹配群")
    @DeleteMapping
    int deleteMatchGroup(@RequestBody MatchGroup matchGroup) {
        try {
            matchGroupService.deleteByMatchGroup(matchGroup);
            matchGroupRelationService.deleteMatchGroupRelationByMatchGroupid(matchGroup.getMatchgroupid());
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }


    //为了接受post信息创建的
    public static class MatchGroupInfo {
        List<Integer> userids;
        MatchGroup matchGroup;

        public List<Integer> getUserids() {
            return userids;
        }

        public void setUserids(List<Integer> userids) {
            this.userids = userids;
        }

        public MatchGroup getMatchGroup() {
            return matchGroup;
        }

        public void setMatchGroup(MatchGroup matchGroup) {
            this.matchGroup = matchGroup;
        }
    }

}

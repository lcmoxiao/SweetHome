package com.jlp.service;

import com.jlp.mapper.FriendRelationMapper;
import com.jlp.pojo.FriendRelation;
import com.jlp.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "friendrelationservice")
@Service
public class FriendRelationService {

    @Resource
    FriendRelationMapper friendRelationMapper;

    //只要userid1 或者userid2 是用户名，则就存在好友关系
    public List<FriendRelation> getFriendRelation(User user) {
        return friendRelationMapper.selectByUserid(user.getUserid());
    }

    public List<User> getFriendRelationToUsers(User user) {
        return friendRelationMapper.selectByUseridToUsers(user.getUserid());
    }

    public Integer insert(FriendRelation friendRelation) {
        return friendRelationMapper.insert(friendRelation);
    }

    public Integer deleteByFriendRelationid(FriendRelation friendRelation) {
        return friendRelationMapper.deleteByPrimaryKey(friendRelation.getFriendrelationid());
    }

    public FriendRelation selectByUserid1AndUserid2(FriendRelation relation) {
        return friendRelationMapper.selectByUserid1AndUserid2(relation);
    }

}

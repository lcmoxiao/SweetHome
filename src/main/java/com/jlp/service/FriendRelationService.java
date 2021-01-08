package com.jlp.service;

import com.jlp.mapper.FriendRelationMapper;
import com.jlp.pojo.FriendRelation;
import com.jlp.pojo.User;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "friendrelation")
@Service
public class FriendRelationService {

    @Resource
    FriendRelationMapper friendRelationMapper;

    @Caching(put = {@CachePut(key = "#user.userid+'friend'")})
    public List<FriendRelation> getFriendRelation(User user){
        return friendRelationMapper.selectByUserid1(user.getUserid());
    }

    @Caching(put = {@CachePut(key = "#friendRelation.userid1+'friend'")})
    public Integer insert(FriendRelation friendRelation) {
        return friendRelationMapper.insert(friendRelation);
    }

    @Caching(evict = {@CacheEvict(key = "#friendRelation.userid1+'friend'")})
    public Integer deleteByFriendRelationid(FriendRelation friendRelation) {
        return friendRelationMapper.deleteByPrimaryKey(friendRelation.getFriendrelationid());
    }

    @Caching(put = {@CachePut(key = "#relation.userid1+'friend'")})
    public FriendRelation selectByUserid1AndUserid2(FriendRelation relation){
        return friendRelationMapper.selectByUserid1AndUserid2(relation);
    }

}

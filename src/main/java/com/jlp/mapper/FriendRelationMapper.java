package com.jlp.mapper;

import com.jlp.pojo.FriendRelation;
import com.jlp.pojo.User;

import java.util.List;

public interface FriendRelationMapper {
    int deleteByPrimaryKey(Integer friendrelationid);

    int insert(FriendRelation record);

    List<FriendRelation> selectByUserid(Integer Userid1);

    List<User> selectByUseridToUsers(Integer Userid1);

    FriendRelation selectByUserid1AndUserid2(FriendRelation relation);

}
package com.jlp.mapper;

import com.jlp.pojo.FriendRelation;

import java.util.List;

public interface FriendRelationMapper {
    int deleteByPrimaryKey(Integer friendrelationid);

    int insert(FriendRelation record);

    List<FriendRelation> selectByUserid1(Integer Userid1);

    FriendRelation selectByUserid1AndUserid2(FriendRelation relation);

}
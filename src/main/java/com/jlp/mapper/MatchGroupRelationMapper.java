package com.jlp.mapper;

import com.jlp.pojo.MatchGroupRelation;

import java.util.List;

public interface MatchGroupRelationMapper {
    int insert(MatchGroupRelation record);

    int deleteByUserid(Integer Userid);

    int deleteByMatchGroupid(Integer MatchGroupid);


    List<MatchGroupRelation> selectByUserid(Integer Userid);

    List<MatchGroupRelation> selectByMatchGroupid(Integer MatchGroupid);
}
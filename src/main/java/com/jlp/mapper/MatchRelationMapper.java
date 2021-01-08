package com.jlp.mapper;

import com.jlp.pojo.MatchRelation;

import java.util.List;

public interface MatchRelationMapper {
    int deleteByPrimaryKey(Integer matchRelationid);

    int insert(MatchRelation record);

    List<MatchRelation> selectByUserid1(Integer Userid1);

    MatchRelation selectByUserid1AndUserid2(MatchRelation relation);

}
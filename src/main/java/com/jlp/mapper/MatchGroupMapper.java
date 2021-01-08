package com.jlp.mapper;

import com.jlp.pojo.MatchGroup;

public interface MatchGroupMapper {

    int deleteByPrimaryKey(Integer matchgroupid);

    int insert(MatchGroup record);

    int insertSelective(MatchGroup record);

    MatchGroup selectByPrimaryKey(Integer matchgroupid);

    int updateByPrimaryKeySelective(MatchGroup record);

    int updateByPrimaryKey(MatchGroup record);

}
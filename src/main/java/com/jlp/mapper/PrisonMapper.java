package com.jlp.mapper;

import com.jlp.pojo.Prison;

public interface PrisonMapper {
    int deleteByPrimaryKey(Integer prisonid);

    int insert(Prison record);

    int insertSelective(Prison record);

    Prison selectByPrimaryKey(Integer prisonid);

    Prison selectByUserid(Integer userid);

    int updateByPrimaryKeySelective(Prison record);

    int updateByPrimaryKey(Prison record);
}
package com.jlp.mapper;

import com.jlp.pojo.Report;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer reportid);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportid);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);
}
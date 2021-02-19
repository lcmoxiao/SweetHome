package com.jlp.service;

import com.jlp.mapper.ReportMapper;
import com.jlp.pojo.Report;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReportService {

    @Resource
    ReportMapper reportMapper;

    public Report get(Integer reportid) {
        return reportMapper.selectByPrimaryKey(reportid);
    }

    public int insertSelective(Report report) {
        return reportMapper.insertSelective(report);
    }

    public int update(Report report) {
        return reportMapper.updateByPrimaryKey(report);
    }

    public int delete(Report report) {
        return reportMapper.deleteByPrimaryKey(report.getReportid());
    }

}

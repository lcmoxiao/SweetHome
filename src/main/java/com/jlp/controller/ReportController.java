package com.jlp.controller;


import com.jlp.pojo.Report;
import com.jlp.service.ReportService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("ReportController")
@RestController
@RequestMapping("/report")
public class ReportController {

    final static Logger logger = LoggerFactory.getLogger(ReportController.class);
    @Resource
    ReportService reportService;

    @PostMapping
    int insert(@RequestBody Report report) {
        return reportService.insertSelective(report);
    }

    @PutMapping
    int update(@RequestBody Report report) {
        return reportService.update(report);
    }

    @DeleteMapping
    int delete(@RequestBody Report report) {
        return reportService.delete(report);
    }

    @GetMapping
    Report get(int report) {
        return reportService.get(report);
    }


}

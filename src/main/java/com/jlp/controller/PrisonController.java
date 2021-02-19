package com.jlp.controller;


import com.jlp.pojo.Prison;
import com.jlp.service.PrisonService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api("PrisonController")
@RestController
@RequestMapping("/prison")
public class PrisonController {

    final static Logger logger = LoggerFactory.getLogger(PrisonController.class);

    @Resource
    PrisonService prisonService;

    @PostMapping
    int insert(@RequestBody Prison Prison) {
        return prisonService.insertSelective(Prison);
    }

    @PutMapping
    int update(@RequestBody Prison Prison) {
        return prisonService.update(Prison);
    }

    @DeleteMapping
    int delete(@RequestBody Prison Prison) {
        return prisonService.delete(Prison);
    }

    @GetMapping
    Prison get(int Prison) {
        return prisonService.get(Prison);
    }

    @GetMapping("/find")
    Prison find(int userid) {
        return prisonService.find(userid);
    }


}

package com.jlp.service;

import com.jlp.mapper.PrisonMapper;
import com.jlp.pojo.Prison;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PrisonService {

    @Resource
    PrisonMapper prisonMapper;

    public Prison get(Integer prisonid) {
        return prisonMapper.selectByPrimaryKey(prisonid);
    }

    public Prison find(Integer userid) {
        return prisonMapper.selectByUserid(userid);
    }

    public int insertSelective(Prison prison) {
        return prisonMapper.insertSelective(prison);
    }

    public int update(Prison prison) {
        return prisonMapper.updateByPrimaryKey(prison);
    }

    public int delete(Prison prison) {
        return prisonMapper.deleteByPrimaryKey(prison.getPrisonid());
    }

}

package com.jlp.service;


import com.jlp.mapper.MatchGroupMapper;
import com.jlp.pojo.MatchGroup;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@CacheConfig(cacheNames = "matchgroupservice")
@Service
public class MatchGroupService {

    @Resource
    MatchGroupMapper matchGroupMapper;

    public MatchGroup getMatchGroup(MatchGroup matchGroup) {
        return matchGroupMapper.selectByPrimaryKey(matchGroup.getMatchgroupid());
    }

    public Integer insert(MatchGroup matchGroup) {
        return matchGroupMapper.insert(matchGroup);
    }

    public Integer deleteByMatchGroup(MatchGroup matchGroup) {
        return matchGroupMapper.deleteByPrimaryKey(matchGroup.getMatchgroupid());
    }


}

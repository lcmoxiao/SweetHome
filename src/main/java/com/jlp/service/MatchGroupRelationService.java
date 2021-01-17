package com.jlp.service;


import com.jlp.mapper.MatchGroupRelationMapper;
import com.jlp.pojo.MatchGroupRelation;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "matchgrouprelationservice")
@Service
public class MatchGroupRelationService {

    @Resource
    MatchGroupRelationMapper matchGroupRelationMapper;

    public int insertMatchGroupRelation(MatchGroupRelation matchGroupRelation) {
        return matchGroupRelationMapper.insert(matchGroupRelation);
    }

    public int deleteMatchGroupRelationByMatchGroupid(Integer matchGroupid) {
        return matchGroupRelationMapper.deleteByMatchGroupid(matchGroupid);
    }

    public int deleteByUserid(Integer userid) {
        return matchGroupRelationMapper.deleteByUserid(userid);
    }

    public List<MatchGroupRelation> selectByUserid(Integer userid) {
        return matchGroupRelationMapper.selectByUserid(userid);
    }

    public List<MatchGroupRelation> selectByMatchGroupid(Integer matchgroupid) {
        return matchGroupRelationMapper.selectByMatchGroupid(matchgroupid);
    }


}

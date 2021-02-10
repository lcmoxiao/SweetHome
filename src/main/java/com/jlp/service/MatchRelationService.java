package com.jlp.service;

import com.jlp.mapper.MatchRelationMapper;
import com.jlp.pojo.MatchRelation;
import com.jlp.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "matchrelationservice")
@Service
public class MatchRelationService {

    @Resource
    MatchRelationMapper matchRelationMapper;

    @Caching(put = {@CachePut(key = "#user.userid+'matchrelation'")})
    public List<MatchRelation> getMatchRelation(User user) {
        return matchRelationMapper.selectByUserid1(user.getUserid());
    }

    @Caching(put = {@CachePut(key = "#matchRelation.userid1+'matchrelation'")})
    public Integer insert(MatchRelation matchRelation) {
        return matchRelationMapper.insert(matchRelation);
    }

    @Caching(evict = {@CacheEvict(key = "#matchRelation.userid1+'matchrelation'")})
    public Integer deleteByMatchRelationid(MatchRelation matchRelation) {
        return matchRelationMapper.deleteByPrimaryKey(matchRelation.getMatchrelationid());
    }

    @Caching(put = {@CachePut(key = "#relation.userid1+'matchrelation'")})
    public MatchRelation selectByUserid1AndUserid2(MatchRelation relation) {
        return matchRelationMapper.selectByUserid1AndUserid2(relation);
    }

}


package com.jlp.service;


import com.jlp.pojo.UserStateInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserStateService {

    @Resource
    private RedisTemplate<String, UserStateInfo> redisTemplate;

    public void setUserState(UserStateInfo userStateInfo) {
        String key = "UserStateInfo:" + userStateInfo.getUserid();
        redisTemplate.opsForValue().set(key, userStateInfo);
    }

    public void deleteUserState(Integer userid) {
        String key = "UserStateInfo:" + userid;
        redisTemplate.delete(key);
    }

    public UserStateInfo getUserState(Integer userid) {
        //从缓存查询
        String key = "UserStateInfo:" + userid;
        return redisTemplate.opsForValue().get(key);
    }


}

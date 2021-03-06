package com.jlp.config.security;

import com.jlp.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Resource
    UserMapper userMapper;

    @PostConstruct
    private void init() {
        logger.info("超级账号为 ATM 123");
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername:" + s);
        if (s.equals("ATM"))
            return new User(s, "123", getATMAuthorities());
        com.jlp.pojo.User user = userMapper.selectByUsername(s);
        if (user != null)
            return new User(s, user.getUserpassword(), getWorkAuthorities());
        else return null;
    }

    private Collection<GrantedAuthority> getATMAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ADMIN"));
        authList.add(new SimpleGrantedAuthority("WORK"));
        return authList;
    }

    private Collection<GrantedAuthority> getWorkAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("WORK"));
        return authList;
    }
}